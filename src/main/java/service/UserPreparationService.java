package service;

import model.Address;
import model.User;
import org.springframework.stereotype.Service;

@Service
public class UserPreparationService {

    static User getUser(Integer userId, String firsrName, String lastName, String username, String password, String email, String accountAddress, Address newAddress) {
        User newUser = new User();
        newUser.setId(userId);
        newUser.setFirstName(firsrName);
        newUser.setLastName(lastName);
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setEmail(email);
        newUser.setAdress(newAddress);
        newUser.setAccountNumber(accountAddress);
        return newUser;
    }
}
