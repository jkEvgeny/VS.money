package ru.virtusystems.money.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.virtusystems.money.dto.PolicyholderDto;
import ru.virtusystems.money.model.Policyholder;
import ru.virtusystems.money.service.PolicyholderService;

import java.util.List;

@Controller
public class PolicyholderController {

    private final PolicyholderService service;

    public PolicyholderController(PolicyholderService service) {
        this.service = service;
    }

    @GetMapping("/policyholders")
    public String findAll(Model model) {
        List<PolicyholderDto> policyholderList = service.findAll();
        model.addAttribute("policyholders", policyholderList);
        return "policyholder-list";
    }

    @GetMapping("/policyholder-update")
    public String updatePolicyholderForm(Model model) {
        model.addAttribute("policyholder", new Policyholder());
        return "policyholder-update";
    }

    @PostMapping("/policyholder-update")
    public String createPolicyholder(PolicyholderDto policyholder) {
        service.savePolicyholder(policyholder);
        return "redirect:/policyholders";
    }

    @GetMapping("/policyholder-update/{id}")
    public String updatePolicyholderForm(Model model, @PathVariable Integer id) {
        model.addAttribute("policyholder", service.findById(id));
        return "policyholder-update";
    }

    @PostMapping("/policyholder-update/{id}")
    public String updateUser(PolicyholderDto policyholder) {
        service.savePolicyholder(policyholder);
        return "redirect:/policyholders";
    }
}
