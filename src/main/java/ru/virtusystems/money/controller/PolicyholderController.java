package ru.virtusystems.money.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.virtusystems.money.model.Policyholder;
import ru.virtusystems.money.service.PolicyholderService;

import java.util.List;

@Controller
public class PolicyholderController {
    private final PolicyholderService policyholderService;

    public PolicyholderController(PolicyholderService policyholderService) {
        this.policyholderService = policyholderService;
    }

    @GetMapping("/policyholders")
    public String findAll(Model model) {
        List<Policyholder> policyholderList = policyholderService.findAll();
        model.addAttribute("policyholders", policyholderList);
        return "policyholder-list";
    }

    @GetMapping("/policyholder-create")
    public String createPolicyholderForm(Policyholder policyholder) {
        return "policyholder-create";
    }

    @PostMapping("/policyholder-create")
    public String createPolicyholder(Policyholder policyholder) {
        policyholderService.savePolicyholder(policyholder);
        return "redirect:/policyholders";
    }
}
