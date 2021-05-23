package ru.virtusystems.money.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "execution")
public class Contract {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name ="contract_number")
    private Integer contractNumber;

    @Column(name = "date_of_conclusion")
    private LocalDateTime dateOfConclusion;
}
