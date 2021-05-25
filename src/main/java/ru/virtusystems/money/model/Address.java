package ru.virtusystems.money.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "address")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "state")
    private String state;

    @Column(name = "index")
    private String index;

    @Column(name = "region")
    private String region;

    @Column(name = "district")
    private String district;

    @Column(name = "locality")
    private String locality;

    @Column(name = "street")
    private String street;

    @Column(name = "house")
    private Integer house;

    @Column(name = "housing")
    private String housing;

    @Column(name = "structure")
    private String structure;

    @Column(name = "flat")
    private String flat;

    @Column(name = "comment")
    private String comment;
}
