package pl.mitura.MituraMarket.repo;

import lombok.Getter;
import pl.mitura.MituraMarket.model.Auction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
public class AuctionRepoList {
    private UserRepoList userRepoList;
    private List<Auction> auctionList = new ArrayList<>();

    @Autowired
    public AuctionRepoList(UserRepoList userRepoList){
        this.userRepoList = userRepoList;

        Auction auction1 = Auction.builder()
                .id(2)
                .title("Nazwa")
                .description("opis")
                .price(new BigDecimal(1234))
                .user(this.userRepoList.getAll().get(0))
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now().plus(10, ChronoUnit.DAYS))
                .build();

        Auction auction2 = Auction.builder()
                .id(3)
                .title("Nazwaaa")
                .description("opidds")
                .price(new BigDecimal(12344))
                .user(this.userRepoList.getAll().get(0))
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now().plus(10, ChronoUnit.DAYS))
                .build();
        auctionList.add(auction1);
        auctionList.add(auction2);
    }

    public void auctionAdd(Auction newAuction){
        auctionList.add(newAuction);
    }

    public void auctionRemove(Auction auctionToRemove){
        auctionList.remove(auctionToRemove);
    }

    public List<Auction> getAll(){
        return auctionList;
    }

    public Auction getAuction(Integer id){
        return getAll().stream().filter(auction -> auction.getId().equals(id)).findAny().get();
    }
}
