package ru.virtusystems.money.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "policyholder")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Policyholder {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "birth_date")
    private LocalDate birth_date;

    @Column(name = "passport_series")
    private Integer passport_series;

    @Column(name = "passport_number")
    private Integer passport_number;
}
