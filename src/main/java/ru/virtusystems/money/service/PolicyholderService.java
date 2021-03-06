package ru.virtusystems.money.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.virtusystems.money.dto.PolicyholderDto;
import ru.virtusystems.money.mapper.PolicyholderMapper;
import ru.virtusystems.money.model.Policyholder;
import ru.virtusystems.money.repository.PolicyholderRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PolicyholderService {

    private final PolicyholderRepository policyholderRepository;

    @Autowired
    private PolicyholderMapper mapper;

    public PolicyholderService(PolicyholderRepository policyholderRepository) {
        this.policyholderRepository = policyholderRepository;
    }

    public PolicyholderDto findById(Integer id) {
        return mapper.mapToDto(policyholderRepository.findById(id).orElse(null));
    }

    public List<PolicyholderDto> findByParam(PolicyholderDto dto) {
        List<Policyholder> policyholderList = new ArrayList<>();
        if (dto.getName() == null || dto.getName().equals("")) {
            if (dto.getSurname() == null || dto.getSurname().equals("")) {
                if (dto.getPatronymic() == null || dto.getPatronymic().equals("")) {
                } else {
                    policyholderList = policyholderRepository.findByPatronymic(dto.getPatronymic());
                }
            } else {
                if (dto.getPatronymic() == null || dto.getPatronymic().equals("")) {
                    policyholderList = policyholderRepository.findBySurname(dto.getSurname());
                } else {
                    policyholderList = policyholderRepository.findBySurnameAndPatronymic(dto.getSurname(), dto.getPatronymic());
                }
            }
        } else {
            if (dto.getSurname() == null || dto.getSurname().equals("")) {
                if (dto.getPatronymic() == null || dto.getPatronymic().equals("")) {
                    policyholderList = policyholderRepository.findByName(dto.getName());
                } else {
                    policyholderList = policyholderRepository.findByNameAndPatronymic(dto.getName(), dto.getPatronymic());
                }
            } else {
                if (dto.getPatronymic() == null || dto.getPatronymic().equals("")) {
                    policyholderList = policyholderRepository.findByNameAndSurname(dto.getName(), dto.getSurname());
                } else {
                    policyholderList = policyholderRepository.findByFIO(dto.getName(), dto.getSurname(), dto.getPatronymic());
                }
            }
        }
        return policyholderList.stream().map(mapper::mapToDto).collect(Collectors.toList());
    }

    public List<PolicyholderDto> findAll() {
        return policyholderRepository.findAll().stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void savePolicyholder(PolicyholderDto policyholderDto) {
        if (policyholderDto.getId() == null) {
            policyholderRepository.save(mapper.mapToModel(policyholderDto));
        } else {
            Optional<Policyholder> policyholder = policyholderRepository.findById(policyholderDto.getId());
            policyholder.get().setName(policyholderDto.getName());
            policyholder.get().setSurname(policyholderDto.getSurname());
            policyholder.get().setPatronymic(policyholderDto.getPatronymic());
            policyholder.get().setBirth_date(LocalDate.parse(policyholderDto.getBirth_date()));
            policyholder.get().setPassport_number(Integer.valueOf(policyholderDto.getPassport_number()));
            policyholder.get().setPassport_series(Integer.valueOf(policyholderDto.getPassport_series()));
        }
    }
}
