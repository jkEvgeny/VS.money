package ru.virtusystems.money.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.virtusystems.money.model.Address;
import ru.virtusystems.money.model.Policyholder;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    /*@EntityGraph(attributePaths = {"name"})
    @Query("SELECT p FROM Policyholder p WHERE p.name=?1")
    PolicyholderDto getByName(String name);*/
}

