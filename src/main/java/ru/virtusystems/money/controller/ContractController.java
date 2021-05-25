package ru.virtusystems.money.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.virtusystems.money.dto.ContractDto;
import ru.virtusystems.money.dto.PolicyholderDto;
import ru.virtusystems.money.model.Contract;
import ru.virtusystems.money.model.Policyholder;
import ru.virtusystems.money.service.ContractService;
import ru.virtusystems.money.service.PolicyholderService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ContractController {
    private final ContractService service;
    private  final PolicyholderService policyholderService;

    @GetMapping("/contracts")
    public String findAll(Model model) {
        List<PolicyholderDto> policyholders= policyholderService.findAll();
        model.addAttribute("contracts", policyholders);
        return "contract-list";
    }

    @GetMapping("/contract-create")
    public String createContractForm(Model model){
        model.addAttribute("contract", new Contract());
        return "contract-create";
    }

    @PostMapping("/contract-create")
    public String createConract(ContractDto contract){
        service.saveContract(contract);
        return "redirect:/contracts";
    }

    @GetMapping("/contract-create/{id}")
    public String updateConractForm(Model model, @PathVariable Integer id) {
        model.addAttribute("contract", service.findById(id));
        return "contract-create";
    }

    @PostMapping("/contract-create/{id}")
    public String updateConract(ContractDto contractDto) {
        service.saveContract(contractDto);
        return "redirect:/contracts";
    }
}
