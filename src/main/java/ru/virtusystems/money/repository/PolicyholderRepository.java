package ru.virtusystems.money.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.virtusystems.money.dto.PolicyholderDto;
import ru.virtusystems.money.model.Policyholder;

import java.util.List;

@Repository
public interface PolicyholderRepository extends JpaRepository<Policyholder, Integer> {
    @Query("SELECT p FROM Policyholder p WHERE p.name=?1")
    List<Policyholder> findByName(String param);

    @Query("SELECT p FROM Policyholder p WHERE p.surname=?1")
    List<Policyholder> findBySurname(String param);

    @Query("SELECT p FROM Policyholder p WHERE p.patronymic=?1")
    List<Policyholder> findByPatronymic(String param);

    @Query("SELECT p FROM Policyholder p WHERE p.name=?1 AND p.surname=?2")
    List<Policyholder> findByNameAndSurname (String name, String surname);

    @Query("SELECT p FROM Policyholder p WHERE p.surname=?1 AND p.patronymic=?2")
    List<Policyholder> findBySurnameAndPatronymic (String surname, String patronymic);

    @Query("SELECT p FROM Policyholder p WHERE p.name=?1 AND p.patronymic=?2")
    List<Policyholder> findByNameAndPatronymic (String name, String patronymic);

    @Query("SELECT p FROM Policyholder p WHERE p.name=?1 AND p.surname=?2 AND p.patronymic=?3")
    List<Policyholder> findByFIO (String name, String surname, String patronymic);
}

