package controller;

import model.Auction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.AuctionService;

import java.util.List;

@RestController
public class AuctionController {
    @Autowired
    private AuctionService auctionService;


    @GetMapping(value = "all")
    public String showAllAuctions(Model model){
        model.addAttribute("auctions", auctionService.getAll());
        return "all";
    }

    @GetMapping(value = "/")
    public String pokazujeStrone(){
        return "hello";
    }
}
