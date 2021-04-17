package com.Duane.Lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Duane.Lookify.models.ArtistModel;
import com.Duane.Lookify.models.SongsModel;
import com.Duane.Lookify.repositories.ArtistRepository;
import com.Duane.Lookify.repositories.SongRepository;

@Service
public class SongsAPIService {

		private SongRepository songRepo;
		private ArtistRepository artistRepo;
		
		public SongsAPIService(SongRepository songRepo, ArtistRepository artistRepo) {
			this.songRepo = songRepo;
			this.artistRepo = artistRepo;
		}
		
		public SongsModel create(SongsModel toCreate) {
			return songRepo.save(toCreate);
		}
		
		public ArtistModel create(ArtistModel toCreate) {
			return artistRepo.save(toCreate);
		}
		
		public List<ArtistModel> getAllArtists(){
			return (List<ArtistModel>) artistRepo.findAll();
		}
		
		public List<SongsModel> getAllSongs() {
			return (List<SongsModel>) songRepo.findAll();
		}
		
		public void deleteSong(Long id) {
	    	this.songRepo.deleteById(id);
	    }
		 public SongsModel findSong(Long id) {
		        Optional<SongsModel> optionalSong = this.songRepo.findById(id);
		        if(optionalSong.isPresent()) {
		            return optionalSong.get();
		        } else {
		            return null;
		        }
		    }
		 
		 public List<SongsModel> searchBy(String artist){
				return songRepo.findByArtistContainsAllIgnoreCase(artist);
			}
		
		 public List<SongsModel> topTen(){
				return songRepo.findTop10ByOrderByRatingDesc();
			}
		 
		 
}
