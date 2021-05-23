package ru.virtusystems.money.service;

import org.springframework.stereotype.Service;
import ru.virtusystems.money.model.Contract;
import ru.virtusystems.money.repository.ContractRepository;

import java.util.List;

@Service
public class ContractService {
    private final ContractRepository contractRepository;

    public ContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    public Contract findById(Integer id) {
        return contractRepository.findById(id).orElse(null);
    }

    public Contract saveContract(Contract contract) {
        return contractRepository.save(contract);
    }
}
