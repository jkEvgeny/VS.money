package ru.virtusystems.money.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.virtusystems.money.model.Contract;
import ru.virtusystems.money.service.ContractService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ContractController {
    private final ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

/*    @GetMapping("/contracts")
    public String findAll(Model model) {
        List<Contract> contractList = contractService.findAll();
        model.addAttribute("contracts", contractList);
        return "contract-list";
    }

    @GetMapping("/contract-create")
    public String createContractForm(Contract contract){
        return "contract-create";
    }

    @PostMapping("/contract-create")
    public String createConract(Contract contract){
        contractService.saveContract(contract);
        return "redirect:/contracts";
    }*/
}
