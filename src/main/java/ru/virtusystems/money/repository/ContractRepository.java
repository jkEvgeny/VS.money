package ru.virtusystems.money.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.virtusystems.money.model.Contract;

public interface ContractRepository extends JpaRepository<Contract, Integer> {
}
