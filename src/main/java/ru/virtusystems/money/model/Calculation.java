package ru.virtusystems.money.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "calculation")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Calculation {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "insurance_amount")
    private Integer insuranceAmount;

    @Column(name = "validity_period_from")
    private LocalDate validityPeriodFrom;

    @Column(name = "validity_period_to")
    private LocalDate validityPeriodTo;

    @Column(name = "property_type")
    private String propertyType;

    @Column(name = "year_of_construction")
    private String yearOfConstruction;

    @Column(name = "area")
    private String area;

    @Column(name = "settlement_date")
    private LocalDateTime settlementDate;

    @Column(name = "prize")
    private String prize;
}
