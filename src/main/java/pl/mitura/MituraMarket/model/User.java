package pl.mitura.MituraMarket.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private Address address;
    private String accountNumber;

    /*@Override
    public String toString() {
        return  String.format("%s %s", firstName, lastName);
    }*/
}