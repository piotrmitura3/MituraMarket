package service;

import model.Auction;
import model.User;
import model.dto.AuctionDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface AuctionService{
    List<Auction> getAll();
    /*List<Auction> addAuction(Integer auctionId, String title, String description, Integer userId,
                    String firsrName, String lastName, String username, String password, String email,
                    Integer addressId, String city, String street, String zipCode, String accountNumber,
                    BigDecimal price, LocalDateTime startDate,
                    LocalDateTime endDate);*/
    void addAuction(Integer auctionId, String title, String description, Integer userId,
                    String firsrName, String lastName, String username, String password, String email,
                    Integer addressId, String city, String street, String zipCode, String accountNumber,
                    BigDecimal price, LocalDateTime startDate,
                    LocalDateTime endDate);
    //void addAuction(AuctionDto auctionDto);
    List<Auction> removeAuction(Integer id);
    Auction modificationAuction(AuctionDto auctionDto);
}

















//interfejs, implementowanie interfejsow, polimorfizm, klasy i metody abstrakcyjne, roznice miedzy klasa
//abstrakcyjna a interfejsem

//dodac usuwanie dodawnaei modyfikowanei
//testy