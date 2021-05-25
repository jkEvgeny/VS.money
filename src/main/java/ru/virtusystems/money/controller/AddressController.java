package ru.virtusystems.money.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.virtusystems.money.dto.AddressDto;
import ru.virtusystems.money.dto.PolicyholderDto;
import ru.virtusystems.money.model.Policyholder;
import ru.virtusystems.money.service.AddressService;
import ru.virtusystems.money.service.PolicyholderService;

import java.util.List;

@Controller
public class AddressController {

    private final AddressService service;

    public AddressController(AddressService service) {
        this.service = service;
    }

    @PostMapping("/contracts")
    public String createPolicyholder(AddressDto address) {
        service.saveAddress(address);
        return "redirect:/contracts";
    }


}
