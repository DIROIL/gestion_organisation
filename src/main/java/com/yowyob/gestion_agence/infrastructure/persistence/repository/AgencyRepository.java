package com.yowyob.gestion_agence.infrastructure.persistence.repository;

import java.util.List;
import java.util.UUID;

import com.yowyob.gestion_agence.domain.model.Agency;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;


public interface  AgencyRepository extends CassandraRepository<Agency,UUID> {
    @Query("select * from agency where domainKey = ?0 ALLOW FILTRING")
    List<Agency> findByDomainKey(UUID domainKey);
    
}
