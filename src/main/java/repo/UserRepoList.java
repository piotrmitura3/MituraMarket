package repo;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UserRepoList {
    private final AddressRepoList adressRepoList;
    private List<User> userList = new ArrayList<User>();



    @Autowired
    public UserRepoList(AddressRepoList adressRepoList) {
        this.adressRepoList = adressRepoList;
        User user1 = User.builder()
                .id(1)
                .email("sdfsd@Gmail.com")
                .firstName("Pawel")
                .lastName("Kowal")
                .accountNumber("82 1020 5226 0000 6102 0417 7895")
                .adress(adressRepoList.getAll().get(0))
                .username("user1")
                .password("haslo")
                .build();


        userList.add(user1);
    }

    public void addUser(User newUser){
        userList.add(newUser);
    }

    public void removeUser(User userToRemove){
        userList.remove(userToRemove);
    }

    public List<User> getAll(){
        return userList;
    }

    public User getUser(Integer id){
        return getAll().stream().filter(user -> user.getId().equals(id)).findAny().get();
    }
}
