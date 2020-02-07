package pl.mitura.MituraMarket.util;

import pl.mitura.MituraMarket.model.Auction;
import pl.mitura.MituraMarket.model.dto.AuctionDto;

public class AuctionMapper {
    public static AuctionDto mapAuctionDtoFromAuction(Auction auction){
        AuctionDto auctionDto = AuctionDto.builder()
                .auctionId(auction.getId())
                .title(auction.getTitle())
                .description(auction.getDescription())
                .userId(auction.getUser().getId())
                .price(auction.getPrice())
                //.startDate(auction.getStartDate())
                //.endDate(auction.getEndDate())
                .build();
        return auctionDto;
    }
}
