package ru.virtusystems.money.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.virtusystems.money.model.Policyholder;
import ru.virtusystems.money.repository.PolicyholderRepository;

import java.util.List;

@Service
public class PolicyholderService {

    private final PolicyholderRepository policyholderRepository;

    public PolicyholderService(PolicyholderRepository policyholderRepository) {
        this.policyholderRepository = policyholderRepository;
    }

    public Policyholder findById(Integer id) {
        return policyholderRepository.findById(id).orElse(null);
    }

    public List<Policyholder> findAll() {
        return policyholderRepository.findAll();
    }

    public Policyholder savePolicyholder(Policyholder policyholder) {
        return policyholderRepository.save(policyholder);
    }
}
