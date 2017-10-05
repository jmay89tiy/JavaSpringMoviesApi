package com.theironyard.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import org.springframework.ui.Model;
import java.util.List;
import java.util.stream.Collectors;


//
//
//

@Controller
public class MovieController {
    static final String API_URL = "https://api.themoviedb.org/3/movie/now_playing?api_key=be2a38521a7859c95e2d73c48786e4bb";
//
//    static final String API_KEY = "?api_key=be2a38521a7859c95e2d73c48786e4bb";
//

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home() {
        return "home"; //returns homepage path
    }


    // link up medium-popular-long-name.html
    @RequestMapping(path = "/medium-popular-long-name", method = RequestMethod.GET)
    public String mediumPop(Model model) {
        List<Movie> movies = getMovies("/medium-popular-long-name").stream()
                .filter((movie) -> {
                    return movie.getTitle().length() > 9;})
                .filter((movie) -> {
                    return movie.getPopularity() > 30 &&  movie.getPopularity() <80;
                })
                .collect(Collectors.toList());
        model.addAttribute("movies", movies);
        //above dictates the template
        //take in model as a parameter
        //created a list
        //filtered with various streams
        //put it in the list, collect everything and throw into the list you made
        //add attributes aka all your info gets tossed into this template aka your list
        return "medium-popular-long-name";
    }

    @RequestMapping(path = "/now-playing", method = RequestMethod.GET)
        public String getMovie(Model model) {
        model.addAttribute("movies", getMovies("now-playing"));
            return "now-playing";
        }

    public static List<Movie> getMovies(String route) {
        RestTemplate restTemplate = new RestTemplate();
        ResultsPage results = restTemplate.getForObject(API_URL, ResultsPage.class);
        return results.getResults();


    }}