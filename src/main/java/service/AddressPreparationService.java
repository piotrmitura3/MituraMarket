package service;

import model.Address;

public class AddressPreparationService {
    static Address addressPreparation(Integer addressId, String city, String street, String zipCode) {
        Address newAddress = new Address();
        newAddress.setId(addressId);
        newAddress.setCity(city);
        newAddress.setStreet(street);
        newAddress.setZipCode(zipCode);
        return newAddress;
    }
}
