package com.Duane.Lookify.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="songs")
public class SongsModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Title cannot be blank")
	@Size(min=5, message="Must be 5 characters or more")
	private String title;
	
	@NotEmpty(message="Artist cannot be blank......unless it's Prince")
	@Size(min=5, message="Must be 5 characters or more")
	private String artist;
	
	@NotNull @Min(1) @Max(100)
	private Integer rating;
	
	@OneToMany(mappedBy ="artist", fetch = FetchType.LAZY)
	private List<ArtistModel> artists;
//	
	public List<ArtistModel> getArtists() {
		return artists;
	}

	public void setArtists(List<ArtistModel> artists) {
		this.artists = artists;
	}

	public SongsModel() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

}


