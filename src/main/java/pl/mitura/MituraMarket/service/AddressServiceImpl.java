package pl.mitura.MituraMarket.service;

import pl.mitura.MituraMarket.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mitura.MituraMarket.repo.AddressRepoList;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepoList addressRepoList = new AddressRepoList();

    @Autowired
    public AddressServiceImpl(AddressRepoList addressRepoList) {
        this.addressRepoList = addressRepoList;
    }

    public AddressServiceImpl() {
    }

    @Override
    public List<Address> getAll() {
        return addressRepoList.getAll();
    }

    @Override
    public List<Address> add(Integer id, String city, String street, String zipCode) {
        Address newADdress = AddressPreparationService.addressPreparation(id, city, street, zipCode);
        addressRepoList.add(newADdress);
        return addressRepoList.getAll();
    }

    @Override
    public List<Address> remove(Integer id) {
        Address addressToRemove = addressRepoList.getAll().stream().filter(address -> address.getId().equals(id)).findAny().get();
        addressRepoList.remove(addressToRemove);
        return addressRepoList.getAll();
    }

    @Override
    public List<Address> modification(Integer id, String city, String street, String zipcode) {
        Address addressToModidication = addressRepoList.getAll().stream().filter(address -> address.getId().equals(id)).findAny().get();
        addressToModidication.setCity(city);
        addressToModidication.setStreet(street);
        addressToModidication.setZipCode(zipcode);

        return addressRepoList.getAll();
    }
}
