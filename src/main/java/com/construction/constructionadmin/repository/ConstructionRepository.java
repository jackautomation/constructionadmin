package com.construction.constructionadmin.repository;


import com.construction.constructionadmin.entity.AccountCreation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConstructionRepository extends JpaRepository<AccountCreation, Long> {
    Optional<AccountCreation> findByEmail(String email);
}
