package ru.virtusystems.money.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.virtusystems.money.dto.ContractDto;
import ru.virtusystems.money.mapper.ContractMapper;
import ru.virtusystems.money.mapper.PolicyholderMapper;
import ru.virtusystems.money.model.Contract;
import ru.virtusystems.money.model.Policyholder;
import ru.virtusystems.money.repository.ContractRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ContractService {
    private final ContractRepository contractRepository;
    @Autowired
    private ContractMapper mapper;

    public ContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    public Contract findById(Integer id) {
        return contractRepository.findById(id).orElse(null);
    }

    public void saveContract(ContractDto contractDto) {
        if (contractDto.getId() == null) {
            contractRepository.save(mapper.mapToModel(contractDto));
        } else {
            Optional<Contract> contract = contractRepository.findById(contractDto.getId());
            contract.get().setContractNumber(contractDto.getContractNumber());
            contract.get().setDateOfConclusion(contractDto.getDateOfConclusion());
        }
    }
}
