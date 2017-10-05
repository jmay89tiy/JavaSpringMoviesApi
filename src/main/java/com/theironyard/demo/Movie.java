package com.theironyard.demo;

import java.util.List;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.client.RestTemplate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {
    static final String API_URL = "https://api.themoviedb.org/3/movie/now_playing?api_key=be2a38521a7859c95e2d73c48786e4bb";


    private String title;
    @JsonProperty(value = "poster_path")

    private String posterPath;
    private String overView;
    private double popularity;


    //
    // Beans Below
    //

    public Movie() {

    }

    //
    // Getters and Setters Below
    //




    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getOverView() {
        return overView;
    }

    public void setOverView(String overView) {
        this.overView = overView;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    //
    // Override toString Below
    //

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", posterpath='" + posterPath + '\'' +
                ", overView='" + overView + '\'' +
                ", popularity=" + popularity +
                '}';
    }
}


