package ru.virtusystems.money.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.virtusystems.money.dto.CalculationDto;
import ru.virtusystems.money.dto.PolicyholderDto;
import ru.virtusystems.money.mapper.CalculationMapper;
import ru.virtusystems.money.model.Calculation;
import ru.virtusystems.money.repository.CalculationRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.logging.Logger;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
@RequiredArgsConstructor
@Slf4j
public class CalculationService {

    private final CalculationRepository calculationRepository;

    private final CalculationMapper mapper;

    @Transactional
    public CalculationDto saveCalculationAndUpdatePrizeAndSettlementDate(final PolicyholderDto policyholderDto) {
        double propertyTypeRatio = 0;
        double yearOfConstructionRatio = 0;
        double areaRatio = 0;
        CalculationDto calculationDto = policyholderDto.getCalculation();
        long daysBetween = DAYS.between(LocalDate.parse(calculationDto.getValidityPeriodFrom()), LocalDate.parse(calculationDto.getValidityPeriodTo()));
        if (daysBetween > 0) {
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

            double prize;
            prize = (calculationDto.getInsuranceAmount() / daysBetween) * propertyTypeRatio * yearOfConstructionRatio * areaRatio;

            BigDecimal result = new BigDecimal(prize);
            result = result.setScale(2, RoundingMode.DOWN);

            Calculation calculation = mapper.mapToModel(calculationDto);
            calculation.setPrize(result.toString());
            calculation.setSettlementDate(settlementDate);

            calculationDto.setSettlementDate(settlementDate);
            calculationDto.setPrize(String.valueOf(result));
            return calculationDto;
        } else {
            log.info( "Null pointer exception");
            return null;
        }
    }
}
