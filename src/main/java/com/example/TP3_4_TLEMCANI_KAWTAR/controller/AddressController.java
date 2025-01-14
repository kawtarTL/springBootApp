package com.example.TP3_4_TLEMCANI_KAWTAR.controller;

import com.example.TP3_4_TLEMCANI_KAWTAR.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddressController {
    @Autowired
    AddressRepository addressRepository;
    @GetMapping("/adresses")
    public String showAddresses(Model model) {
        model.addAttribute("allAddresses", addressRepository.findAll());
        return "adresses";
    }
}