package com.api.retire.retire_o_lixo.repository;

import com.api.retire.retire_o_lixo.model.Pin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PinRepository extends JpaRepository<Pin, String> {
    
    // Buscar pins por cidade
    @Query(value = "SELECT * FROM pins p WHERE p.cidade = :cidade", nativeQuery = true)
    List<Pin> findByCidade(@Param("cidade") String cidade);

    // Buscar pins por tags
    @Query(value = "SELECT * FROM pins p WHERE :tag = ANY(p.tags)", nativeQuery = true)
        List<Pin> findByTagsContaining(String tag);

        @Query(value = "SELECT * FROM pins p", nativeQuery = true)
        List<Pin> findAll();
}
