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
            if((movies.get(i).getName()).equals(name)){
                return movies.get(i);
            }
        }
        return null;
    }

    public Director getDirectorByName(String name){
        for(int i=0;i<directors.size();i++){
            if((directors.get(i).getName()).equals(name)){
                return directors.get(i);
            }
        }
        return null;
    }

    public void addMovieDirectorPair(String movie,String director){
        Movie moviePair=null;
        Director directorPair=null;

        for(int i=0;i<movies.size();i++){
            String movieName=movies.get(i).getName();
            if(movieName.equals(movie)){
                moviePair=movies.get(i);
            }
        }
        for(int i=0;i<directors.size();i++){
            String directorName=directors.get(i).getName();
            if(directorName.equals(director)){
                directorPair=directors.get(i);
            }
        }

        movieDirectorPair.put(moviePair,directorPair);
    }

    public void deleteDirectorByName(String name){

        List<Movie> toBeDeleted=new ArrayList<>();
        Director deleting=null;
        for(int i=0;i<directors.size();i++){
            String directorName=directors.get(i).getName();
            if(directorName.equals(name)){
                deleting=directors.get(i);
            }
        }
        directors.remove(deleting);
        for(Movie movie:movieDirectorPair.keySet()){
                String directorName=movieDirectorPair.get(movie).getName();
                if(directorName.equals(name)){
                    toBeDeleted.add(movie);
            }
        }
        for(int i=0;i<toBeDeleted.size();i++){
            movieDirectorPair.remove(toBeDeleted.get(i));
            movies.remove(toBeDeleted.get(i));
        }
    }

    public void deleteAllDirectors(){
        directors=new ArrayList<>();
        for(Movie movie:movieDirectorPair.keySet()){
            movies.remove(movie);
        }
        movieDirectorPair=new HashMap<>();
    }

    public List<String> getMoviesByDirectorName(String director){
        List<String> allMovies=new ArrayList<>();
        for(Movie movie:movieDirectorPair.keySet()){
            String directorName=movieDirectorPair.get(movie).getName();
            if(directorName.equals(director)){
               // System.out.println((movieDirectorPair.get(movie)).getName());
                allMovies.add(movie.getName());
            }
        }
        return allMovies;
    }

}
