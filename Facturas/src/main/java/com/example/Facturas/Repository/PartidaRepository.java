package com.example.Facturas.Repository;

import com.example.Facturas.Model.Partida;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidaRepository extends CrudRepository<Partida, Long> {
    
}
