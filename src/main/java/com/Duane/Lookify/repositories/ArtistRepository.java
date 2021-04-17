package com.Duane.Lookify.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Duane.Lookify.models.ArtistModel;

@Repository
public interface ArtistRepository extends CrudRepository<ArtistModel, Long> {
	
}

