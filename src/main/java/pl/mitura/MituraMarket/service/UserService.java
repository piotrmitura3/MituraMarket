package pl.mitura.MituraMarket.service;

import pl.mitura.MituraMarket.model.User;
import pl.mitura.MituraMarket.model.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getAll();
    /*List<User> add(Integer id, String firsrName, String lastName, String username, String password, String email,
                 Integer addressId, String city, String street, String zipCode, String accountNumber);*/
    void addUser(UserDto userDto);
    List<User> remove(Integer id);
    User modification(UserDto userDto);

}
