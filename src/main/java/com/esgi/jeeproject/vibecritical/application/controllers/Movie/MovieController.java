package com.esgi.jeeproject.vibecritical.application.controllers.Movie;

import com.esgi.jeeproject.vibecritical.domain.DTOs.MovieDTO;
import com.esgi.jeeproject.vibecritical.domain.entities.Movie.Movie;
import com.esgi.jeeproject.vibecritical.domain.service.Movie.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {


    @Value("${omdbApiKey}")
    private String apiKey;

    @Autowired
    private ModelMapper modelMapper;

    private final MovieService movieService;

    @Autowired
    private RestTemplate restTemplate;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(value = "/{movieName}")
    private ResponseEntity<MovieDTO> getMovieInfo(@PathVariable("movieName") String movieName){

        var movieDTO = restTemplate.getForEntity("http://www.omdbapi.com/?t=" + movieName +  "&apikey="+ apiKey,MovieDTO.class);

        return ResponseEntity.ok().body(movieDTO.getBody());
    }

    @GetMapping()
    private ResponseEntity<List<Movie>> getAllMovies(){
        return ResponseEntity.ok().body(movieService.getAllMovies());
    }

    @PostMapping()
    public ResponseEntity<Movie> saveRole(@RequestBody Movie movie){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(movieService.saveMovie(movie));
    }
}
