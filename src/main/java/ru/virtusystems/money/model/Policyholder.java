package ru.virtusystems.money.model;

import lombok.Data;
import org.springframework.boot.context.properties.bind.Name;
import org.springframework.cache.annotation.Cacheable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "policyholder")
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

    @Column(name = "change")
    private Boolean change;

}
