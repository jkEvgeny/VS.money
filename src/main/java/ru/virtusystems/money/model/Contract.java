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
@Table(name = "execution")
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
