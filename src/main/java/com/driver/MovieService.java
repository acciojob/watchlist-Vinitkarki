package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    void addMovie(Movie movie){

        movieRepository.addMovie(movie);
    }

    public List<Movie> gelAllMovies(){

        return movieRepository.getAllMovies();
    }

    void addDirector(Director director){
        movieRepository.addDirector(director);
    }

    Movie getMovieByName(String name){
        return movieRepository.getMovieByName(name);
    }

    Director getDirectorByName(String name){
        return movieRepository.getDirectorByName(name);
    }

    void addMovieDirectorPair(String movie,String director){

        movieRepository.addMovieDirectorPair(movie,director);
    }

    void deleteDirectorByName(String name){
        movieRepository.deleteDirectorByName(name);
    }

    void deleteAllDirectors(){
        movieRepository.deleteAllDirectors();
    }
}
