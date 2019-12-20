package model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Address {
    private Integer id;
    private String city;
    private String street;
    private String zipCode;
}
