package service;

import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import repo.UserRepoList;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
    private UserServiceImpl userServiceImpl;

    @BeforeEach
    void setup(){
        //userServiceImpl = new UserServiceImpl();
    }

    @Test
    void shouldAddNewUserToList(){
        //given
        int expectedListSize = 2;
        //when
        List<User> actual = userServiceImpl.add(1, "as", "as", "kl", "sda",
                "asd", 2, "asd", "fd", "gsd", "4564");
        int actualListSize = actual.size();
        //then
        assertThat(actualListSize).isEqualTo(expectedListSize);
    }

    @Test
    void shouldRemoveUserFromList(){
        //given
        int expectedListSize = 0;
        //when
        List<User> actual = userServiceImpl.remove(1);
        int actualListSize = actual.size();
        //then
        assertThat(actualListSize).isEqualTo(expectedListSize);
    }


}