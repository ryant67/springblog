package com.example.springblog.controllers;

import com.example.springblog.models.Ad;
import com.example.springblog.repositories.AdRepository;
import com.example.springblog.repositories.OwnerRepository;
import com.example.springblog.services.AdService;
import com.example.springblog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HomeController {
    //Establish adsDao instance properties
    private final AdRepository adsDao;
    private final OwnerRepository ownerDao;
    private final EmailService emailService;
    private final AdService adService;
    //Anytime this controller is used, inject the adsDao, so we can use it...

    public HomeController(AdRepository adsDao, OwnerRepository ownerDao, EmailService emailService, AdService adservice) {
        this.adsDao = adsDao;
        this.ownerDao = ownerDao;
        this.emailService = emailService;
        this.adService = adservice;
    }

    @GetMapping("/")
    @ResponseBody
    public String landing() {
    return "This is the Landing Page!";
    }

    @GetMapping("/ads")
    public String allAds(Model model) {
        List<Ad> ads = adService.getAds();
        //Other methods to remember;
        //.save() - insert new record, or update an existing record.
        //.delete() - delete a record.
        //.findById() - find record by Id.
        model.addAttribute("ads", ads);
        return "ads";
    }

    @GetMapping("/ads/create")
    public String showCreateForm(Model model) {
        model.addAttribute("ad", new Ad());
        return "adCreate";
    }

    @PostMapping("/ads/create")
    public String create(@ModelAttribute Ad ad) {
        adService.createAd(ad);
        return "redirect:/ads";
    }




}
