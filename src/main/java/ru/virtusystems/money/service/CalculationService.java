package ru.virtusystems.money.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.virtusystems.money.dto.CalculationDto;
import ru.virtusystems.money.mapper.CalculationMapper;
import ru.virtusystems.money.model.Calculation;
import ru.virtusystems.money.repository.CalculationRepository;
import java.util.Optional;

@Service
public class CalculationService {
    private final CalculationRepository calculationRepository;

    @Autowired
    private CalculationMapper mapper;

    public CalculationService(CalculationRepository calculationRepository) {
        this.calculationRepository = calculationRepository;
    }

    public Calculation findById(Integer id) {
        return calculationRepository.findById(id).orElse(null);
    }

    @Transactional
    public void saveCalculation(CalculationDto calculationDto) {

        if (calculationDto.getId() == null) {
            calculationRepository.save(mapper.mapToModel(calculationDto));
        } else {
            Optional<Calculation> calculation = calculationRepository.findById(calculationDto.getId());
            calculation.get().setInsuranceAmount(calculationDto.getInsuranceAmount());
            calculation.get().setValidityPeriodFrom(calculationDto.getValidityPeriodFrom());
            calculation.get().setValidityPeriodTo(calculationDto.getValidityPeriodTo());
            calculation.get().setPropertyType(calculationDto.getPropertyType());
            calculation.get().setYearOfConstruction(calculationDto.getYearOfConstruction());
            calculation.get().setArea(calculationDto.getArea());
            calculation.get().setSettlementDate(calculationDto.getSettlementDate());
            calculation.get().setPrize(calculationDto.getPrize());
        }
    }
}
