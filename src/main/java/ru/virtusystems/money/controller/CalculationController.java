package ru.virtusystems.money.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.virtusystems.money.dto.PolicyholderDto;
import ru.virtusystems.money.model.Calculation;
import ru.virtusystems.money.model.Contract;
import ru.virtusystems.money.model.Policyholder;
import ru.virtusystems.money.service.CalculationService;
import ru.virtusystems.money.service.ContractService;

import java.util.List;

@Controller
public class CalculationController {
    private final CalculationService calculationService;

    public CalculationController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @GetMapping("/calculation")
    public String createCalculationForm(){
        return "calculation";
    }

    @PostMapping("/calculation")
    public String createCalculation(Calculation calculation){
        calculationService.saveCalculation(calculation);
        return "redirect:/contracts";
    }

    /*@GetMapping("/policyholder-update")
    public String updatePolicyholderForm(Model model) {
        model.addAttribute("policyholder", new Policyholder());
        return "policyholder-update";
    }

    @PostMapping("/policyholder-update")
    public String createPolicyholder(PolicyholderDto policyholder) {
        service.savePolicyholder(policyholder);
        return "redirect:/policyholders";
    }*/
}
