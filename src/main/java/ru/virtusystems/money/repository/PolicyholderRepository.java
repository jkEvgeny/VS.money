package ru.virtusystems.money.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.virtusystems.money.model.Policyholder;

public interface PolicyholderRepository extends JpaRepository<Policyholder, Integer> {
}

