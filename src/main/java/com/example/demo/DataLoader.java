package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    DirectorRepository directorRepository;

    @Autowired
    MovieRepository movieRepository;

    @Override
    public void run(String...strings) throws Exception {

        Director director;
        director = new Director("Quentin Tarantino", "multi");

        Movie movie1 = new Movie("Kill Bill", "2003", "action");
        movie1.setDirector(director);

        Movie movie2 = new Movie("Pulp Fiction", "1994", "comedy/crime");
        movie2.setDirector(director);


        directorRepository.save(director);
        movieRepository.save(movie1);
        movieRepository.save(movie2);

    }

}
