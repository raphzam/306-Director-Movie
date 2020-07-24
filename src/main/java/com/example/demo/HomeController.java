package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    DirectorRepository directorRepository;

    @Autowired
    MovieRepository movieRepository;

    @RequestMapping("/")
    public String loadHome(Model model){
        model.addAttribute("directors", directorRepository.findAll());
        return "home";
}

    @RequestMapping("/newdirector")
    public String loadDirectorForm(Model model){
        model.addAttribute("director", new Director());
        return "newdirector";
    }

    @PostMapping("/confirmdirector")
    public String confirmDirector(@ModelAttribute Director director){
        directorRepository.save(director);
        return "redirect:/";
    }

    @RequestMapping("/directorDetail/{id}")
    public String directorDetail(@PathVariable("id") long directorID, Model model){
        model.addAttribute("director", directorRepository.findById(directorID).get());
        return "directordetail";
    }

    @RequestMapping("/updateDirector/{id}")
    public String updateDirector(@PathVariable("id") long directorID, Model model){
        model.addAttribute("director", directorRepository.findById(directorID).get()); //find and send Director obj to model
        return "newdirector";
    }

    @RequestMapping("/deleteDirector/{id}")
    public String deleteDirector(@PathVariable("id") long directorID){
        directorRepository.deleteById(directorID); // remove director from director repository
        return "redirect:/";
    }

    @RequestMapping("/allDirectors")
    public String allDirectors(Model model){
        model.addAttribute("directors", directorRepository.findAll());
        return "directors";
    }


    @RequestMapping("/newmovie")
    public String loadMovieForm(Model model){
        model.addAttribute("movie", new Movie()); //send Movie constructor to model
        model.addAttribute("directors", directorRepository.findAll()); //send all directors to model
        return "newmovie";
    }

    @PostMapping("/confirmmovie")
    public String confirmMovie(@ModelAttribute Movie movie, @RequestParam("directorID") long directorID){
        movie.setDirector(directorRepository.findById(directorID).get());
        movieRepository.save(movie);
        return "redirect:/";
    }

    @RequestMapping("/movieDetail/{id}")
    public String movieDetail(@PathVariable("id") long movieID, Model model){
        model.addAttribute("movie", movieRepository.findById(movieID).get());
        return "moviedetail";
    }

    @RequestMapping("/updateMovie/{id}")
    public String updateMovie(@PathVariable("id") long movieID, Model model){
        model.addAttribute("movie", movieRepository.findById(movieID).get()); //find Movie object put it in the model
        model.addAttribute("directors", directorRepository.findAll()); // put all directors in the model
        return "newmovie";
    }

    @RequestMapping("/deleteMovie/{id}")
    public String deleteMovie(@PathVariable("id") long movieID, Model model){
        movieRepository.deleteById(movieID); //remove movie from movie repository
                                            //  ???
        return "redirect:/";
    }

    @RequestMapping("/allMovies")
    public String allMovies(Model model){
        model.addAttribute("movies", movieRepository.findAll());
        return "movies";
    }






}
