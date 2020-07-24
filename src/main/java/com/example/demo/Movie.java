package com.example.demo;

import javax.persistence.*;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;
    private String year;
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)

    @JoinColumn(name = "director_id")
    private Director director;

    private String posterUrl;

    public Movie() {
    }

    public Movie(String title, String year, String description) {
        this.title = title;
        this.year = year;
        this.description = description;
    }

    public Movie(String title, String year, String description, Director director) {
        this.title = title;
        this.year = year;
        this.description = description;
        this.director = director;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }
}
