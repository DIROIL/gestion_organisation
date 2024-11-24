package com.yowyob.gestion_organisation.infrastructure.persistence.repository;

import java.util.UUID;

import com.yowyob.gestion_organisation.domain.model.Organisation;
import org.springframework.data.cassandra.repository.CassandraRepository;


public interface  OrganisationRepository extends CassandraRepository<Organisation,UUID> {
    
}
