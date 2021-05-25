package ru.virtusystems.money.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.virtusystems.money.dto.PolicyholderDto;
import ru.virtusystems.money.model.Policyholder;

@Repository
public interface PolicyholderRepository extends JpaRepository<Policyholder, Integer> {
    /*@EntityGraph(attributePaths = {"name"})
    @Query("SELECT p FROM Policyholder p WHERE p.name=?1")
    PolicyholderDto getByName(String name);*/
}

