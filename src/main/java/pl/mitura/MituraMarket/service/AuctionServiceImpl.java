package pl.mitura.MituraMarket.service;

import pl.mitura.MituraMarket.model.Auction;
import pl.mitura.MituraMarket.model.User;
import pl.mitura.MituraMarket.model.dto.AuctionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mitura.MituraMarket.repo.AuctionRepoList;
import pl.mitura.MituraMarket.repo.UserRepoList;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static pl.mitura.MituraMarket.service.AddressPreparationService.addressPreparation;
import static pl.mitura.MituraMarket.service.UserPreparationService.getUser;

@Service
public class AuctionServiceImpl implements AuctionService {
    private UserRepoList userRepoList;
    private AuctionRepoList auctionRepoList;


    @Autowired
    public AuctionServiceImpl(AuctionRepoList auctionRepoList, UserRepoList userRepoList) {
        this.auctionRepoList = auctionRepoList;
        this.userRepoList = userRepoList;
    }

    @Override
    public List<Auction> getAll() {
        return auctionRepoList.getAll();
    }

    /*@Override
    public List<Auction> addAuction(Integer auctionId, String title, String description, Integer userId,
                           String firsrName, String lastName, String username, String password, String email,
                           Integer addressId, String city, String street, String zipCode, String accountNumber,
                           BigDecimal price, LocalDateTime startDate,
                           LocalDateTime endDate) {

        Auction newAuction = auctionPreparation(auctionId, title, description,
                userPreparation(userId, firsrName, lastName, username, password, email, accountNumber,
                        addressPreparation(addressId, city, street, zipCode)),
                price, startDate, endDate);

        auctionRepoList.auctionAdd(newAuction);

        return auctionRepoList.getAll();
    }*/

    /*@Override
    public void addAuction(Integer auctionId, String title, String description, Integer userId, String firsrName, String lastName, String username, String password, String email, Integer addressId, String city, String street, String zipCode, String accountNumber, BigDecimal price, LocalDateTime startDate, LocalDateTime endDate) {
        Auction newAuction = auctionPreparation(auctionId, title, description,
                getUser(userId, firsrName, lastName, username, password, email, accountNumber,
                        addressPreparation(addressId, city, street, zipCode)),
                price, startDate, endDate);

        auctionRepoList.auctionAdd(newAuction);
    }*/

    @Override
    public void addAuction(AuctionDto auctionDto) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime startDate = LocalDateTime.parse(auctionDto.getStartDate(), formatter);
        LocalDateTime endDate = LocalDateTime.parse(auctionDto.getEndDate(), formatter);

        Auction newAuction = auctionPreparation(auctionDto.getAuctionId(), auctionDto.getTitle(),auctionDto.getDescription(),
                userRepoList.getUser(auctionDto.getUserId()), auctionDto.getPrice(), startDate,
                endDate);
        auctionRepoList.auctionAdd(newAuction);

        //zamienic przychodzacego Stringa z daty( auctionDto) na localdatetime
    }

    @Override
    public List<Auction> removeAuction(Integer id) {
        Auction remove = auctionRepoList.getAll().stream().filter(auction -> auction.getId().equals(id)).findAny().get();
        auctionRepoList.auctionRemove(remove);
        return auctionRepoList.getAll();
    }

    @Override
    public Auction modificationAuction(AuctionDto auctionDto) {
        LocalDateTime startDate = LocalDateTime.parse(auctionDto.getStartDate());
        LocalDateTime endDate = LocalDateTime.parse(auctionDto.getEndDate());
        Auction modification = auctionRepoList.getAuction(auctionDto.getAuctionId());
        modification.setTitle(auctionDto.getTitle());
        modification.setDescription(auctionDto.getDescription());
        modification.setPrice(auctionDto.getPrice());
        modification.setStartDate(startDate);
        modification.setEndDate(endDate);
        modification.setUser(userRepoList.getUser(auctionDto.getUserId()));
        return auctionRepoList.getAuction(auctionDto.getAuctionId());
    }


    private Auction auctionPreparation(Integer auctionId, String title, String description, User user,
                                       BigDecimal price, LocalDateTime startDate, LocalDateTime endDate) {
        Auction auction = new Auction();
        auction.setId(auctionId);
        auction.setTitle(title);
        auction.setDescription(description);
        auction.setUser(user);
        auction.setPrice(price);
        auction.setStartDate(startDate);
        auction.setEndDate(endDate);
        return auction;
    }

}
