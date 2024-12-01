package com.yowyob.gestion_organisation.infrastructure.persistence.repository;

import java.util.List;
import java.util.UUID;

import com.yowyob.gestion_organisation.domain.model.Organisation;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;


public interface  OrganisationRepository extends CassandraRepository<Organisation,UUID> {
    @Query("select * from agency where domainKey = ?0 ALLOW FILTRING")
    List<Organisation> findByDomainKey(UUID domainKey);
    
}
