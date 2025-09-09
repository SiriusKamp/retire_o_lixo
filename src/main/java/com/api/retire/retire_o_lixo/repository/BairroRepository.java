package com.api.retire.retire_o_lixo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.retire.retire_o_lixo.model.Bairro;

import jakarta.transaction.Transactional;

@Repository
public interface BairroRepository extends JpaRepository<Bairro, Long> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO bairros (cd_bairro, nm_bairro, municipio, uf, geom) " +
            "VALUES (:cdBairro, :nmBairro, :municipio, :uf, " +
            "ST_SetSRID(ST_GeomFromGeoJSON(:geometry), 4326))", nativeQuery = true)
    void salvarBairro(@Param("cdBairro") String cdBairro,
            @Param("nmBairro") String nmBairro,
            @Param("municipio") String municipio,
            @Param("uf") String uf,
            @Param("geometry") String geometryJson);

    @Query(value = "SELECT id,cd_bairro, nm_bairro, municipio, uf, ST_AsGeoJSON(geom) AS geojson " +
            "FROM bairros", nativeQuery = true)
    List<Object[]> buscarBairrosComGeoJson();

}
