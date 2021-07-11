package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class HelloController {
    @GetMapping("/hello")
    String hello() {
        return "helloWorld";
    }


    @GetMapping("/capitalize/hello")
    String hello(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        System.out.println(name);
        return "Capitalized";
    }


    @GetMapping("/albums")
    public String albums( Model model) {
        ArrayList<Album> albums= new ArrayList<>();

        Album album =  new Album("Title","Artist",20,1200,"https://via.placeholder.com/150");
        Album album1 = new Album("Title1","Artist1",20,1200,"https://via.placeholder.com/150");
        Album album2 =  new Album("Title 3","Artist 3",25,1300,"https://via.placeholder.com/150");

        albums.add(album);
        albums.add(album1);
        albums.add(album2);
        model.addAttribute("album", albums);
        return "albums";
    }

}
