package com.med.rest.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.med.rest.domain.entitys.Medic;

@Repository
public interface MedicRepository extends JpaRepository<Medic, Long>{
}
