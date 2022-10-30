package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie){

        movieRepository.addMovie(movie);
    }

    public List<Movie> gelAllMovies(){

        return movieRepository.getAllMovies();
    }

    public void addDirector(Director director){
        movieRepository.addDirector(director);
    }

    public Movie getMovieByName(String name){
        return movieRepository.getMovieByName(name);
    }

    public Director getDirectorByName(String name){
        return movieRepository.getDirectorByName(name);
    }

    public void addMovieDirectorPair(String movie,String director){

        movieRepository.addMovieDirectorPair(movie,director);
    }

    public void deleteDirectorByName(String name){
        movieRepository.deleteDirectorByName(name);
    }

    public void deleteAllDirectors(){
        movieRepository.deleteAllDirectors();
    }

    public List<Movie> getMoviesByDirectorName(String director){

        return movieRepository.getMoviesByDirectorName(director);

    }
}
