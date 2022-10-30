package com.driver;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class MovieRepository {



    public HashMap<String,Movie> movies=new HashMap<>();
    public HashMap<String,Director> directors=new HashMap<>();
    public HashMap<Movie,Director> movieDirectorPair=new HashMap<>();

    public List<Movie> getAllMovies(){

        List<Movie> allMovies=new ArrayList<>();
        for(Movie movie:movies.values()){
            allMovies.add(movie);
        }
        return allMovies;
    }

    void addMovie(Movie movie){

        movies.put(movie.getName(),movie);

    }
    void addDirector(Director director){

        directors.put(director.getName(),director);
    }

    Movie getMovieByName(String name){
        if(movies.containsKey(name)){
            return movies.get(name);
        }
        return null;
    }

    Director getDirectorByName(String name){
        if(directors.containsKey(name)){
            return directors.get(name);
        }
        return null;
    }

    void addMovieDirectorPair(String movie,String director){
        Movie moviePair=null;
        Director directorPair=null;

        moviePair=movies.get(movie);
        directorPair=directors.get(director);

        movieDirectorPair.put(moviePair,directorPair);
    }

    void deleteDirectorByName(String name){

        if(directors.containsKey(name)){
            directors.remove(name);
        }
        for(Movie movie:movieDirectorPair.keySet()){
                if(movieDirectorPair.get(movie).getName().equals(name)){
                    movieDirectorPair.remove(movie);
                    movies.remove(movie.getName());
            }
        }
    }

    void deleteAllDirectors(){
        directors=new HashMap<>();
        for(Movie movie:movieDirectorPair.keySet()){
            movies.remove(movie.getName());
        }
        movieDirectorPair=new HashMap<>();
    }

}
