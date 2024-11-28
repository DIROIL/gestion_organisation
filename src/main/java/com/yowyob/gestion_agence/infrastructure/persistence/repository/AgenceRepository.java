package com.yowyob.gestion_agence.infrastructure.persistence.repository;

import java.util.UUID;

import com.yowyob.gestion_agence.domain.model.Agence;
import org.springframework.data.cassandra.repository.CassandraRepository;


public interface  AgenceRepository extends CassandraRepository<Agence,UUID> {
    
}
