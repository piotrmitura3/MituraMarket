package model.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

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
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer userId;
}
