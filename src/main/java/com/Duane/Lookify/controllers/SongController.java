package com.Duane.Lookify.controllers;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Duane.Lookify.models.SongsModel;
import com.Duane.Lookify.services.SongsAPIService;

@Controller
public class SongController {
	
	SongsAPIService songService;
	
	public SongController(SongsAPIService songService) {
		this.songService = songService;
	}

	@GetMapping("/")
	public String Index(Model model) {
		model.addAttribute("aSong", new SongsModel());
		model.addAttribute("allSongs", songService.getAllSongs());
		return "Index.jsp";
	}
	
	@GetMapping("/dashboard")
	public String Dashboard(Model model) {
		model.addAttribute("allSongs", songService.getAllSongs());
		return "Dashboard.jsp";
	}
	@GetMapping("/song/new")
	public String NewSong(@ModelAttribute("aSong") SongsModel aSong) {
		return "Create.jsp";
	}

	@RequestMapping(value = "/song/{id}/view")
	public String findOne(@PathVariable("id") Long id, Model model) {
    	SongsModel songToShow = this.songService.findSong(id);
    	model.addAttribute("SongToShow", songToShow);
    	return "ViewOne.jsp";
	}
	
	@PostMapping("/song/create")
	public String create(@Valid @ModelAttribute("aSong") SongsModel aSong, 
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			// still display notes if validation error
			model.addAttribute("allSongs", songService.getAllSongs()); 
			return "Create.jsp";
		}
		// otherwise create a note and redirect back
		songService.create(aSong);
		return "redirect:/dashboard";
	}
	
	 @RequestMapping(value="/song/{id}/delete")
	    public String destroy(@PathVariable("id") Long id) {
	        songService.deleteSong(id);
	        return "redirect:/dashboard";
	    }
	 @GetMapping("/song/search/")
		public String searchArtist(@RequestParam("artist")String artist, Model model) {
		 	List<SongsModel> songs = songService.searchBy(artist);
		 	model.addAttribute("songs",songs);
		 	model.addAttribute("artist",artist);
		 	System.out.println("**************");
		 	return "Search.jsp";
		}
		
	 @RequestMapping(value ="/song/topTen")
		public String topTen(Model model) {
			List<SongsModel> top = songService.topTen();
			model.addAttribute("top",top);
			return "TopTen.jsp";
			
	}
//	 
}