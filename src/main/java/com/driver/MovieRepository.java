package com.driver;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class MovieRepository {



    public List<Movie> movies=new ArrayList<>();
    public List<Director> directors=new ArrayList<>();
    public HashMap<Movie,Director> movieDirectorPair=new HashMap<>();

    public List<Movie> getAllMovies(){

        return movies;
    }

    public void addMovie(Movie movie){

        movies.add(movie);

    }
    public void addDirector(Director director){

        directors.add(director);
    }

    public Movie getMovieByName(String name){
        for(int i=0;i<movies.size();i++){
            if(movies.get(i).getName().equals(name)){
                return movies.get(i);
            }
        }
        return null;
    }

    public Director getDirectorByName(String name){
        for(int i=0;i<directors.size();i++){
            if(directors.get(i).getName().equals(name)){
                return directors.get(i);
            }
        }
        return null;
    }

    public void addMovieDirectorPair(String movie,String director){
        Movie moviePair=null;
        Director directorPair=null;

        for(int i=0;i<movies.size();i++){
            if(movies.get(i).getName().equals(movie)){
                moviePair=movies.get(i);
            }
        }
        for(int i=0;i<directors.size();i++){
            if(directors.get(i).getName().equals(director)){
                directorPair=directors.get(i);
            }
        }

        movieDirectorPair.put(moviePair,directorPair);
    }

    public void deleteDirectorByName(String name){

        for(int i=0;i<directors.size();i++){
            if(directors.get(i).getName().equals(name)){
                directors.remove(directors.get(i));
            }
        }
        for(Movie movie:movieDirectorPair.keySet()){
                if(movieDirectorPair.get(movie).getName().equals(name)){
                    movieDirectorPair.remove(movie);
                    movies.remove(movie);
            }
        }
    }

    public void deleteAllDirectors(){
        directors=new ArrayList<>();
        for(Movie movie:movieDirectorPair.keySet()){
            movies.remove(movie);
        }
        movieDirectorPair=new HashMap<>();
    }

    public List<Movie> getMoviesByDirectorName(String director){
        List<Movie> allMovies=new ArrayList<>();
        for(Movie movie:movieDirectorPair.keySet()){
            if(movieDirectorPair.get(movie).getName().equals(director)){
                allMovies.add(movie);
            }
        }
        return allMovies;
    }

}
