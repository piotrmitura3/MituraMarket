/*
package pl.mitura.MituraMarket.service;

import pl.mitura.MituraMarket.model.Address;
import pl.mitura.MituraMarket.model.Auction;
import pl.mitura.MituraMarket.model.User;
import pl.mitura.MituraMarket.model.dto.AuctionDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.mitura.MituraMarket.repo.AuctionRepoList;
import pl.mitura.MituraMarket.repo.UserRepoList;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
@ExtendWith(MockitoExtension.class)
class AuctionServiceImplTest {

    private AuctionService auctionServiceImpl;
    @Mock
    private AuctionRepoList auctionRepoList;
    @Mock
    private UserRepoList userRepoList;

    @BeforeEach
    void setup(){
        auctionServiceImpl = new AuctionServiceImpl(auctionRepoList, userRepoList);
    }

    @Test
    void shouldAddNewAuctionToList(){
        //given
        //int expected = 2;

        //when
        auctionServiceImpl.addAuction(123, "asd", "asd",
                12, "asd", "asd", "sad", "asd", "DS",
                145, "asd", "asda", "asdf", "asd",
                new BigDecimal(231), LocalDateTime.now(), LocalDateTime.now().plus(10, ChronoUnit.DAYS));

        //then
        //assertThat(auctionServiceImpl.getAll().size()).isEqualTo(expected);
        Mockito.verify(auctionRepoList).auctionAdd(Mockito.any(Auction.class));
    }

    @Test
    void shouldRemoveAuctionFromList(){
        //given
        int expected = 0;

        //when
        List<Auction> current = auctionServiceImpl.removeAuction(2);
        int size = current.size();

        //then
        assertThat(size).isEqualTo(expected);
    }

 @Test
    void shouldReturnAuctionAfterModification(){
        //given
        User wantedUser = User.builder()
                .id(1)
                .email("sdfsd@Gmail.com")
                .firstName("Pawel")
                .lastName("Kowal")
                .accountNumber("82 1020 5226 0000 6102 0417 7895")
                .adress(Address.builder()
                        .id(4534)
                        .city("Lublin")
                        .street("Koncertowa")
                        .zipCode("20-960")
                        .build())
                .username("user1")
                .password("haslo")
                .build();

        Auction expected = Auction.builder()
                .id(2)
                .title("a")
                .description("f")
                .user(User.builder()
                        .id(1)
                        .email("sdfsd@Gmail.com")
                        .firstName("Pawel")
                        .lastName("Kowal")
                        .accountNumber("82 1020 5226 0000 6102 0417 7895")
                        .adress(Address.builder()
                                .id(4534)
                                .city("Lublin")
                                .street("Koncertowa")
                                .zipCode("20-960")
                                .build())
                        .username("user1")
                        .password("haslo")
                        .build())
                .price(new BigDecimal(23))
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now().plus(20, ChronoUnit.DAYS))
                .build();
        //when
        List<Auction> current = auctionServiceImpl.modificationAuction(2, "a", "f", new BigDecimal(23),
                LocalDateTime.now(), LocalDateTime.now().plus(20, ChronoUnit.DAYS), wantedUser);

        //then
        assertThat(current).isEqualTo(expected);
    }


    @Test
    void modification(){
        //given
        Auction before = Auction.builder()
                .id(3)
                .title("asd")
                .description("asd")
                .build();

        Auction after = Auction.builder()
                .id(3)
                .title("qwe")
                .description("rty")
                .build();

        AuctionDto auctionDto = AuctionDto.builder()
                .auctionId(3)
                .title("qwe")
                .description("rty")
                .build();

        Mockito.when(auctionRepoList.getAuction(auctionDto.getAuctionId())).thenReturn(before);

        //when
        Auction auction = auctionServiceImpl.modificationAuction(auctionDto);

        //then
        assertThat(auction).isEqualTo(after);
    }


}
*/
