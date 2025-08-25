package com.api.retire.retire_o_lixo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.retire.retire_o_lixo.model.FeatureEntity;

@Repository
public interface FeatureRepository extends JpaRepository<FeatureEntity, Long> {
}
