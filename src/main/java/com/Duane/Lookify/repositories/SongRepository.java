package com.Duane.Lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Duane.Lookify.models.SongsModel;

@Repository
public interface SongRepository extends CrudRepository<SongsModel, Long> {
	List<SongsModel> findTop10ByOrderByRatingDesc();
	List<SongsModel> findByArtistContainsAllIgnoreCase(String search);
}
