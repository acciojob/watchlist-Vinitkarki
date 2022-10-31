package com.driver;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/movies/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @PostMapping("/movies/add-director")
    public ResponseEntity addDirector(@RequestBody Director director){

        movieService.addDirector(director);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("movie")String movie,@RequestParam("director")String director){
        movieService.addMovieDirectorPair(movie,director);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable String name){

            if(movieService.getMovieByName(name)!=null) {
                return new ResponseEntity<>(movieService.getMovieByName(name), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable String name){

            if(movieService.getDirectorByName(name)!=null) {
                return new ResponseEntity<>(movieService.getDirectorByName(name), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/movies/get-all-movies")
    public ResponseEntity findAllMovies(){

            return new ResponseEntity<>(movieService.gelAllMovies(),HttpStatus.OK);

    }

    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("name") String name){

        movieService.deleteDirectorByName(name);
        return new ResponseEntity<>("success",HttpStatus.OK);
    }

    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){

        movieService.deleteAllDirectors();
        return new ResponseEntity<>("success",HttpStatus.OK);
    }

    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable String director){

        //System.out.println(director);
        List<Movie> allMovies=movieService.getMoviesByDirectorName(director);
        if(!allMovies.isEmpty()) {
            return new ResponseEntity<>(allMovies, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
