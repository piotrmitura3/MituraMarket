package pl.mitura.MituraMarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.mitura.MituraMarket.model.Auction;
import pl.mitura.MituraMarket.model.User;
import pl.mitura.MituraMarket.model.dto.AuctionDto;
import pl.mitura.MituraMarket.service.AuctionService;
import pl.mitura.MituraMarket.service.UserService;
import pl.mitura.MituraMarket.util.AuctionMapper;

@Controller
public class AuctionController {
    @Autowired
    private AuctionService auctionService;
    @Autowired
    private UserService userService;

    private User getUser(){
        return userService.getAll().get(0);
    }


    @GetMapping(value = "all")
    public String showAllAuctions(Model model){
        //AuctionDto auctionDto = new AuctionDto();
        model.addAttribute("auctions", auctionService.getAll());
        //model.addAttribute("remove" , auctionDto.getAuctionId());
        model.addAttribute("user", userService.getAll());
        return "auction";
    }

    @RequestMapping(value = "/auctions/{auctionId}/delete", method = RequestMethod.POST)
    public String removeAuction(@PathVariable("auctionId") int auctionId, final RedirectAttributes redirectAttributes){
        auctionService.removeAuction(auctionId);
        return "redirect:/successAuctionForm";
    }
/*
    @RequestMapping(method = RequestMethod.POST)
    public String modifySubmit(@ModelAttribute ("modify")AuctionDto modifyForm){
        modifyForm.setUserId(getUser().getId());
        auctionService.modificationAuction(modifyForm);
        return "redirect:/modifyForm";
    }*/

    @PostMapping(value = "modifyForm")
    public String modifyAuction(Model model){
        AuctionDto auctionDto = new AuctionDto();

        model.addAttribute("modificate", auctionDto);
        return "modifyForm";
    }

    @GetMapping(value = "auctionForm")
    public String addAuction(Model model){
        AuctionDto auctionDto = new AuctionDto();
        model.addAttribute("auctionDetails", auctionDto);
        model.addAttribute("user", userService.getAll());
        return "auctionForm";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitForm(@ModelAttribute("auctionDetails") AuctionDto auctionDetails){
        auctionDetails.setUserId(getUser().getId());
        auctionService.addAuction(auctionDetails);
        return "redirect:/successAuctionForm";
    }

    @GetMapping(value = "/successAuctionForm")
    public String success(){
        return "successAdd";
    }

    @GetMapping(value = "/")
    public String pokazujeStrone(){
        return "auctionForm";
    }
}
