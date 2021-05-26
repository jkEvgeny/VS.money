package ru.virtusystems.money.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.virtusystems.money.dto.CalculationDto;
import ru.virtusystems.money.mapper.CalculationMapper;
import ru.virtusystems.money.model.Calculation;
import ru.virtusystems.money.repository.CalculationRepository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Optional;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class CalculationService {
    private final CalculationRepository calculationRepository;

    @Autowired
    private CalculationMapper mapper;

    public CalculationService(CalculationRepository calculationRepository) {
        this.calculationRepository = calculationRepository;
    }

    @Transactional
    public CalculationDto saveCalculationAndUpdatePrizeAndSettlementDate(final CalculationDto calculationDto) {
        double propertyTypeRatio = 0;
        double yearOfConstructionRatio = 0;
        double areaRatio = 0;
        long daysBetween = DAYS.between(calculationDto.getValidityPeriodFrom(), calculationDto.getValidityPeriodTo());
        double prize;
        LocalDateTime settlementDate = LocalDateTime.now();

        switch (calculationDto.getPropertyType().toLowerCase(Locale.ROOT)) {
            case "квартира":
                propertyTypeRatio = 1.7;
                break;
            case "дом":
                propertyTypeRatio = 1.5;
                break;
            case "комната":
                propertyTypeRatio = 1.3;
                break;
        }

        if (Integer.parseInt(calculationDto.getYearOfConstruction()) < 2000) {
            yearOfConstructionRatio = 1.3;
        } else if (Integer.parseInt(calculationDto.getYearOfConstruction()) >= 2000 &&
                Integer.parseInt(calculationDto.getYearOfConstruction()) <= 2014) {
            yearOfConstructionRatio = 1.6;
        } else if (Integer.parseInt(calculationDto.getYearOfConstruction()) > 2014) {
            yearOfConstructionRatio = 2;
        }

        if (Integer.parseInt(calculationDto.getArea()) < 50) {
            areaRatio = 1.2;
        } else if (Integer.parseInt(calculationDto.getArea()) >= 50 &&
                Integer.parseInt(calculationDto.getArea()) <= 100) {
            areaRatio = 1.5;
        } else if (Integer.parseInt(calculationDto.getArea()) > 100) {
            areaRatio = 2;
        }

        prize = (calculationDto.getInsuranceAmount() / daysBetween) * propertyTypeRatio * yearOfConstructionRatio * areaRatio;

        BigDecimal result = new BigDecimal(prize);
        result = result.setScale(2, RoundingMode.DOWN);

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
            calculation.get().setSettlementDate(settlementDate);
            calculation.get().setPrize(String.valueOf(result));
        }
        calculationDto.setPrize(String.valueOf(result));
        return calculationDto;
    }
}
