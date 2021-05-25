package ru.virtusystems.money.mapper;

import org.springframework.stereotype.Component;
import ru.virtusystems.money.dto.AddressDto;
import ru.virtusystems.money.dto.PolicyholderDto;
import ru.virtusystems.money.model.Address;
import ru.virtusystems.money.model.Policyholder;

import java.time.LocalDate;

@Component
public class AddressMapper {

    public AddressDto mapToDto(Address model) {
        if (model == null) return null;
        return AddressDto.builder()
                .id(model.getId())
                .state(model.getState())
                .index(model.getIndex())
                .region(model.getRegion())
                .district(model.getDistrict())
                .locality(model.getLocality())
                .street(model.getStreet())
                .house(model.getHouse())
                .housing(model.getHousing())
                .structure(model.getStructure())
                .flat(model.getFlat())
                .comment(model.getComment())
                .build();
    }

    public Address mapToModel(AddressDto dto) {
        if (dto == null) return null;
        return Address.builder()
                .id(dto.getId())
                .state(dto.getState())
                .index(dto.getIndex())
                .region(dto.getRegion())
                .district(dto.getDistrict())
                .locality(dto.getLocality())
                .street(dto.getStreet())
                .house(dto.getHouse())
                .housing(dto.getHousing())
                .structure(dto.getStructure())
                .flat(dto.getFlat())
                .comment(dto.getComment())
                .build();

    }
}
