package pl.mitura.MituraMarket.service;

import pl.mitura.MituraMarket.model.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAll();
    List<Address> add(Integer id, String city, String street, String zipCode);
    List<Address> remove(Integer id);
    List<Address> modification(Integer id, String city, String street, String zipcode);
    }

