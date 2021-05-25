package ru.virtusystems.money.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private Integer id;

    private String state;

    private String index;

    private String region;

    private String district;

    private String locality;

    private String street;

    private Integer house;

    private String housing;

    private String structure;

    private String flat;

    private String comment;

}
