package pl.mitura.MituraMarket.repo;

import pl.mitura.MituraMarket.model.Address;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class AddressRepoList {

    private List<Address> addressList = new ArrayList<Address>();

    public AddressRepoList() {
        Address address1 = Address.builder()
                .id(3)
                .city("Lublin")
                .street("Koncertowa")
                .zipCode("20-960")
                .build();

        Address address2 = Address.builder()
                .id(4)
                .city("Lublin")
                .street("Elsnera")
                .zipCode("20-900")
                .build();

        Address address3 = Address.builder()
                .id(5)
                .city("Warszawa")
                .street("Choiny")
                .zipCode("20-345")
                .build();

        addressList.add(address1);
        addressList.add(address2);
        addressList.add(address3);
    }

    public List<Address> getAll(){
        return addressList;
    }

    public void add(Address newAddress) {
        addressList.add(newAddress);
    }

    public void remove(Address addressToRemove){
        addressList.remove(addressToRemove);
    }

    public Address getAddress(Integer id){
        return getAll().stream().filter(address -> address.getId().equals(id)).findAny().get();
    }
}