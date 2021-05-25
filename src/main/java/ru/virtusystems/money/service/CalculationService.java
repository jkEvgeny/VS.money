package ru.virtusystems.money.service;

import org.springframework.stereotype.Service;
import ru.virtusystems.money.model.Calculation;
import ru.virtusystems.money.repository.CalculationRepository;

@Service
public class CalculationService {
    private final CalculationRepository calculationRepository;

    public CalculationService(CalculationRepository calculationRepository) {
        this.calculationRepository = calculationRepository;
    }

    public Calculation findById(Integer id) {
        return calculationRepository.findById(id).orElse(null);
    }

    public Calculation saveCalculation(Calculation calculation) {
        return calculationRepository.save(calculation);
    }
}
