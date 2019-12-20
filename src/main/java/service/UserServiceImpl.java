package service;

import model.Address;
import model.User;
import model.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.AddressRepoList;
import repo.UserRepoList;

import java.util.List;

import static service.AddressPreparationService.addressPreparation;
import static service.UserPreparationService.getUser;

@Service
public class UserServiceImpl implements UserService{
    private AddressRepoList addressRepoList;
    private UserRepoList userRepoList;

    @Autowired
    public UserServiceImpl(UserRepoList userRepoList, AddressRepoList addressRepoList) {
        this.userRepoList = userRepoList;
        this.addressRepoList = addressRepoList;
    }

    @Override
    public List<User> getAll() {
        return userRepoList.getAll();
    }

    @Override
    public List<User> add(Integer id, String firsrName, String lastName, String username,
                        String password, String email, Integer addressId, String city,
                        String street, String zipCode, String accountNumber) {
        User newUser = userPreparation(id, firsrName, lastName, username, password, email, accountNumber,
                addressPreparation(addressId, city, street, zipCode));

        userRepoList.addUser(newUser);
        return userRepoList.getAll();
    }

    @Override
    public List<User> remove(Integer id) {
        User userToRemove = userRepoList.getAll().stream().filter(user -> user.getId().equals(id)).findAny().get();
        userRepoList.removeUser(userToRemove);
        return userRepoList.getAll();
    }

    @Override
    public User modification(UserDto userDto) {
        User modification = userRepoList.getUser(userDto.getUserId());
        modification.setFirstName(userDto.getFirstName());
        modification.setLastName(userDto.getLastName());
        modification.setUsername(userDto.getUsername());
        modification.setPassword(userDto.getPassword());
        modification.setEmail(userDto.getEmail());
        modification.setAccountNumber(userDto.getAccountNumber());
        modification.setAdress(addressRepoList.getAddress(userDto.getAddresId()));
        return userRepoList.getUser(userDto.getUserId());
    }


    private User userPreparation(Integer userId, String firsrName, String lastName, String username,
                                 String password, String email, String accountAddress, Address newAddress) {
        return getUser(userId, firsrName, lastName, username, password, email, accountAddress, newAddress);
    }
}
