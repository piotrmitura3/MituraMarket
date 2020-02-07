package pl.mitura.MituraMarket.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Auction {
    private Integer id;
    private String title;
    private String description;
    private User user;
    private BigDecimal price;
    private LocalDateTime startDate;
    private LocalDateTime endDate;


}
