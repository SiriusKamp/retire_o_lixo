package com.api.retire.retire_o_lixo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.retire.retire_o_lixo.model.Horarios;

import jakarta.transaction.Transactional;

@Repository
public interface HorariosRepository extends JpaRepository<Horarios, Long> {

    @Transactional
    @Modifying
    @Query(
        value = "INSERT INTO horarios (bairro_id, nome_bairro, \"Dia_horario\", \"Dias\") " +
                "SELECT b.id, :nome_bairro, :dia_horario, :dias " +
                "FROM bairros b " +
                "WHERE b.nm_bairro ILIKE :nome_bairro and b.municipio ILIKE 'Vila Velha'",
        nativeQuery = true
    )
    void salvarHorario(String nome_bairro, String[] dia_horario, String[] dias);
    

    @Query 
    (
     value = "SELECT * FROM horarios", nativeQuery = true
    )
    public List<Horarios> getHorarios();
}
