package ru.virtusystems.money.mapper;

import org.springframework.stereotype.Component;
import ru.virtusystems.money.dto.CalculationDto;
import ru.virtusystems.money.dto.PolicyholderDto;
import ru.virtusystems.money.model.Calculation;
import ru.virtusystems.money.model.Policyholder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class CalculationMapper {

    public CalculationDto mapToDto(Calculation model) {
        if (model == null) return null;
        return CalculationDto.builder()
                .id(model.getId())
                .insuranceAmount(model.getInsuranceAmount())
                .validityPeriodFrom(model.getValidityPeriodFrom() == null ? null : LocalDate.parse(model.getValidityPeriodFrom().toString()))
                .validityPeriodTo(model.getValidityPeriodTo() == null ? null : LocalDate.parse(model.getValidityPeriodTo().toString()))
                .propertyType(model.getPropertyType())
                .yearOfConstruction(model.getYearOfConstruction())
                .area(model.getArea())
                .settlementDate(model.getSettlementDate() == null ? null: LocalDateTime.parse(model.getSettlementDate().toString()))
                .prize(model.getPrize())
                .build();
    }

    public Calculation mapToModel(CalculationDto dto) {
        if (dto == null) return null;
        return Calculation.builder()
                .id(dto.getId())
                .insuranceAmount(dto.getInsuranceAmount())
                .validityPeriodFrom(dto.getValidityPeriodFrom() == null ? null : LocalDate.parse(dto.getValidityPeriodFrom().toString()))
                .validityPeriodTo(dto.getValidityPeriodTo() == null ? null : LocalDate.parse(dto.getValidityPeriodTo().toString()))
                .propertyType(dto.getPropertyType())
                .yearOfConstruction(dto.getYearOfConstruction())
                .area(dto.getArea())
                .settlementDate(dto.getSettlementDate() == null ? null: LocalDateTime.parse(dto.getSettlementDate().toString()))
                .prize(dto.getPrize())
                .build();
    }
}
