package com.api.retire.retire_o_lixo.repository;

import com.api.retire.retire_o_lixo.model.Pin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PinRepository extends JpaRepository<Pin, String> {

    // Buscar pins por cidade
    List<Pin> findByCidade(String cidade);

    // Buscar pins por tags
    List<Pin> findByTagsContaining(String tag);
}
