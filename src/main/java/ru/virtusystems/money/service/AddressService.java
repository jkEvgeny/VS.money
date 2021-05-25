package ru.virtusystems.money.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.virtusystems.money.dto.AddressDto;
import ru.virtusystems.money.dto.PolicyholderDto;
import ru.virtusystems.money.mapper.AddressMapper;
import ru.virtusystems.money.mapper.PolicyholderMapper;
import ru.virtusystems.money.model.Address;
import ru.virtusystems.money.model.Policyholder;
import ru.virtusystems.money.repository.AddressRepository;
import ru.virtusystems.money.repository.PolicyholderRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    private AddressMapper mapper;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressDto findById(Integer id) {
        return mapper.mapToDto(addressRepository.findById(id).orElse(null));
    }

    /*public AddressDto getByName(String name) {
        return addressRepository.getByName(name);
    }*/

    public List<AddressDto> findAll() {
        return addressRepository.findAll().stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void saveAddress(AddressDto addressDto) {
        if (addressDto.getId() == null) {
            addressRepository.save(mapper.mapToModel(addressDto));
        } else {
            Optional<Address> address = addressRepository.findById(addressDto.getId());
            address.get().setState(addressDto.getState());
            address.get().setIndex(addressDto.getIndex());
            address.get().setRegion(addressDto.getRegion());
            address.get().setDistrict(addressDto.getDistrict());
            address.get().setLocality(addressDto.getLocality());
            address.get().setStreet(addressDto.getStreet());
            address.get().setHouse(addressDto.getHouse());
            address.get().setHousing(addressDto.getHousing());
            address.get().setStructure(addressDto.getStructure());
            address.get().setFlat(addressDto.getFlat());
            address.get().setComment(addressDto.getComment());
        }
    }
}
