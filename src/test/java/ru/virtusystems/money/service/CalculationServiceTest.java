package ru.virtusystems.money.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.virtusystems.money.dto.CalculationDto;
import ru.virtusystems.money.dto.PolicyholderDto;
import ru.virtusystems.money.mapper.CalculationMapper;
import ru.virtusystems.money.model.Calculation;
import ru.virtusystems.money.repository.CalculationRepository;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalculationServiceTest {

    @Mock
    private CalculationRepository calculationRepository;

    @Mock
    private CalculationMapper mapper;

    @InjectMocks
    private CalculationService calculationService;

    @Test
    public void saveCalculationAndUpdatePrizeAndSettlementDateTest() {

        when(mapper.mapToModel(any())).thenReturn(new Calculation());
        PolicyholderDto policyholderDto = initDto(32000, "2021-05-26", "2022-05-26", "квартира", "2020", "75", null);
        String expectedResult = "443.70";
        CalculationDto result = calculationService.saveCalculationAndUpdatePrizeAndSettlementDate(policyholderDto);
        assertEquals(expectedResult, result.getPrize());
    }


    private PolicyholderDto initDto(int p1, String p2, String p3, String p4, String p5, String p6, LocalDateTime p7) {
        PolicyholderDto policyholderDto = new PolicyholderDto();
        CalculationDto calculationDto = new CalculationDto();
        calculationDto.setInsuranceAmount(p1);
        calculationDto.setValidityPeriodFrom(p2);
        calculationDto.setValidityPeriodTo(p3);
        calculationDto.setPropertyType(p4);
        calculationDto.setYearOfConstruction(p5);
        calculationDto.setArea(p6);
        calculationDto.setSettlementDate(p7);
        policyholderDto.setCalculation(calculationDto);

        return policyholderDto;
    }
}