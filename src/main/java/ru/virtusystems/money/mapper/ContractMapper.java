package ru.virtusystems.money.mapper;

import org.springframework.stereotype.Component;
import ru.virtusystems.money.dto.CalculationDto;
import ru.virtusystems.money.dto.ContractDto;
import ru.virtusystems.money.model.Calculation;
import ru.virtusystems.money.model.Contract;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class ContractMapper {

    public ContractDto mapToDto(Contract model) {
        if (model == null) return null;
        return ContractDto.builder()
                .id(model.getId())
                .contractNumber(model.getContractNumber())
                .dateOfConclusion(model.getDateOfConclusion())
                .build();
    }

    public Contract mapToModel(ContractDto dto) {
        if (dto == null) return null;
        return Contract.builder()
                .id(dto.getId())
                .contractNumber(dto.getContractNumber())
                .dateOfConclusion(dto.getDateOfConclusion())
                .build();
    }
}
