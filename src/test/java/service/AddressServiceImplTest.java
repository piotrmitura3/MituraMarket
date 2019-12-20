package service;

import model.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repo.AddressRepoList;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class AddressServiceImplTest {

    private AddressServiceImpl addressServiceImpl;

    @BeforeEach
    void setup(){
        addressServiceImpl = new AddressServiceImpl();
    }

    @Test
    void shouldAddAddressToList(){
        //given
        int expectedListSize = 4;
        //when
        List<Address> actualList = addressServiceImpl.add(12, "ds", "asd", "asd");
        int actualListSize = actualList.size();
        //then
        assertThat(actualListSize).isEqualTo(expectedListSize);
    }

    @Test
    void shouldRemoveAddresFromList(){
        //given
        int expectedListSize = 2;
        //when
        List<Address> actualList = addressServiceImpl.remove(3);
        int actualListSize = actualList.size();
        //then
        assertThat(actualListSize).isEqualTo(expectedListSize);
    }

    @Test
    void shouldModificateAddress(){
        //given
        Address expectedAddress = Address.builder()
                .id(3)
                .city("ds")
                .street("dfs")
                .zipCode("sdfs")
                .build();
        //when
        List<Address> actual = addressServiceImpl.modification(3, "ds", "dfs", "sdfs");
        //then
        assertThat(actual).isEqualTo(expectedAddress);
    }

}