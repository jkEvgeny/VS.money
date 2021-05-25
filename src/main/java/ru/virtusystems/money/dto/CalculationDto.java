package ru.virtusystems.money.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CalculationDto {

    private Integer id;

    private Integer insuranceAmount;

    private LocalDate validityPeriodFrom;

    private LocalDate validityPeriodTo;

    private String propertyType;

    private String yearOfConstruction;

    private String area;

    private LocalDateTime settlementDate;

    private String prize;

}
