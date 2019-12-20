package service;

import model.Address;
import model.User;
import model.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getAll();
    List<User> add(Integer id, String firsrName, String lastName, String username, String password, String email,
                 Integer addressId, String city, String street, String zipCode, String accountNumber);
    List<User> remove(Integer id);
    User modification(UserDto userDto);

}
