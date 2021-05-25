package ru.virtusystems.money.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.virtusystems.money.dto.PolicyholderDto;
import ru.virtusystems.money.model.Policyholder;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class PolicyholderMapper {

    private final AddressMapper addressMapper;
    private final ContractMapper contractMapper;
    private  final CalculationMapper calculationMapper;

    public PolicyholderDto mapToDto(Policyholder model) {
        if (model == null) return null;
        return PolicyholderDto.builder()
                .id(model.getId())
                .birth_date(model.getBirth_date() == null ? null : model.getBirth_date().toString())
                .name(model.getName())
                .passport_number(model.getPassport_number() == null ? null : model.getPassport_number().toString())
                .passport_series(model.getPassport_series() == null ? null : model.getPassport_series().toString())
                .patronymic(model.getPatronymic())
                .surname(model.getSurname())
                .passport(model.getPassport_number() + " " + model.getPassport_series())
                .user(model.getSurname() + " " + model.getName() + " " + model.getPatronymic())
                .address(addressMapper.mapToDto(model.getAddress()))
                .calculation(calculationMapper.mapToDto(model.getCalculation()))
                .contract(contractMapper.mapToDto(model.getContract()))
                .build();
    }

    public Policyholder mapToModel(PolicyholderDto dto) {
        if (dto == null) return null;
        return Policyholder.builder()
                .id(dto.getId())
                .birth_date(dto.getBirth_date() == null ? null : LocalDate.parse(dto.getBirth_date()))
                .name(dto.getName())
                .passport_number(dto.getPassport_number() == null ? null : Integer.parseInt(dto.getPassport_number()))
                .passport_series(dto.getPassport_series() == null ? null : Integer.parseInt(dto.getPassport_series()))
                .patronymic(dto.getPatronymic())
                .surname(dto.getSurname())
                .address(addressMapper.mapToModel(dto.getAddress()))
                .calculation(calculationMapper.mapToModel(dto.getCalculation()))
                .contract(contractMapper.mapToModel(dto.getContract()))
                .build();
    }
}
