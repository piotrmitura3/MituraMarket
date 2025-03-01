package pl.mitura.MituraMarket.service;

import pl.mitura.MituraMarket.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class UserServiceImplTest {
    private UserServiceImpl userServiceImpl;

    @BeforeEach
    void setup(){
        //userServiceImpl = new UserServiceImpl();
    }

    /*@Test
    void shouldAddNewUserToList(){
        //given
        int expectedListSize = 2;
        //when
        List<User> actual = userServiceImpl.add(1, "as", "as", "kl", "sda",
                "asd", 2, "asd", "fd", "gsd", "4564");
        int actualListSize = actual.size();
        //then
        assertThat(actualListSize).isEqualTo(expectedListSize);
    }*/

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

    @Test
    void shouldParseStringToLocalDateTime(){
        //given
        String date = "2020-01-30T19:52:40.721012200";
        //when
        LocalDateTime parse = LocalDateTime.parse(date, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        //then
        assertThat(date).isEqualTo(parse.toString());
    }


}