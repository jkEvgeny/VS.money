package ru.virtusystems.money.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.virtusystems.money.model.Calculation;
import ru.virtusystems.money.model.Contract;

public interface CalculationRepository extends JpaRepository<Calculation, Integer> {
}
