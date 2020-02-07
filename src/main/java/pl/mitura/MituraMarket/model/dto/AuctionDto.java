package pl.mitura.MituraMarket.model.dto;

import lombok.*;
import pl.mitura.MituraMarket.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@EqualsAndHashCode

public class AuctionDto {
    private Integer auctionId;
    private String title;
    private String description;
    private BigDecimal price;
    private String startDate;
    private String endDate;
    private Integer userId;
    private User user;

    public AuctionDto() {
    }

    public AuctionDto(Integer auctionId, String title, String description, BigDecimal price, String startDate, String endDate, Integer userId, User user) {
        this.auctionId = auctionId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.userId = userId;
        this.user = user;
    }
}
