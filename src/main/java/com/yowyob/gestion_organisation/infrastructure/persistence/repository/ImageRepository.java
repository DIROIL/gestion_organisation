package com.yowyob.gestion_organisation.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.yowyob.gestion_organisation.domain.model.Image;

@Repository
public interface ImageRepository extends CassandraRepository<Image, String>{
	@Query("SELECT * FROM images WHERE idOrganisation = ?0 ALLOW FILTERING")
	List<Image> findByIdOrganisation(String idOrganisation);
}