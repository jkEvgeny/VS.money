package ru.virtusystems.money.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.virtusystems.money.dto.CalculationDto;
import ru.virtusystems.money.dto.PolicyholderDto;
import ru.virtusystems.money.model.Calculation;
import ru.virtusystems.money.service.CalculationService;

@Controller
public class CalculationController {
    private final CalculationService calculationService;

    public CalculationController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @PostMapping("/calculation")
    public String createCalculation(Model model, PolicyholderDto dto){
        CalculationDto calculationDto1 = calculationService.saveCalculationAndUpdatePrizeAndSettlementDate(dto);
        model.addAttribute("dto", calculationDto1);
        return "redirect:/contract-create";
    }

    @GetMapping("/calculation")
    public String createCalculationForm(Model model){
        model.addAttribute("calculation", new Calculation());
        return "calculation";
    }

}
