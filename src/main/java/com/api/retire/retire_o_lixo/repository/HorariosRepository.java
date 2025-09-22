package com.api.retire.retire_o_lixo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
                "WHERE unaccent(b.nm_bairro) ILIKE unaccent(:nome_bairro) " +
                "  AND unaccent(b.municipio) ILIKE 'Vila Velha' " +
                "  AND NOT EXISTS ( " +
                "      SELECT 1 FROM horarios h2 " +
                "      WHERE unaccent(h2.nome_bairro) ILIKE unaccent(:nome_bairro)" +
                "  )",
        nativeQuery = true
    )
    void salvarHorario(String nome_bairro, String[] dia_horario, String[] dias);
    

    @Query 
    (
     value = "SELECT * FROM horarios", nativeQuery = true
    )
    public List<Horarios> getHorarios();

    @Query 
    (
        value = "SELECT * FROM horarios WHERE bairro_id = :bairro_id",
        nativeQuery = true    )
    public Horarios getHorariosbyBairro(@Param("bairro_id") Long bairro_id);
}
