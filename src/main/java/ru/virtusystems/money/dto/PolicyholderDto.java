package ru.virtusystems.money.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PolicyholderDto {

    private Integer id;

    private String name;

    private String surname;

    private String patronymic;

    private String birth_date;

    private String passport_series;

    private String passport_number;

    private String passport;

    private String user;

}
