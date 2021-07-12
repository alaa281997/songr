package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@Controller
public class HelloController {
    @Autowired
    private AlbumRepository albumRepository;

    @GetMapping("/hello")
    String hello() {
        return "helloWorld";
    }


    @GetMapping("/capitalize/hello")
    String hello(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        System.out.println(name);
        return "Capitalized";
    }


    @GetMapping("/albums")
    public String albums(Model model) {
//        ArrayList<Album> albums= new ArrayList<>();
//
//        Album album =  new Album("Title","Artist",20,1200,"https://via.placeholder.com/150");
//        Album album1 = new Album("Title1","Artist1",20,1200,"https://via.placeholder.com/150");
//        Album album2 =  new Album("Title 3","Artist 3",25,1300,"https://via.placeholder.com/150");
//
//        albums.add(album);
//        albums.add(album1);
//        albums.add(album2);
//        model.addAttribute("album", albums);
        model.addAttribute("albums", albumRepository.findAll());
        return "albums";
    }
    @GetMapping("/addAlbum")
    public String getAddAlbumView(){
        return "NewAlbum";
    }

    @PostMapping("/albums")
    public RedirectView AlbumAdd(@RequestParam(value = "title") String title ,
                                 @RequestParam(value= "artist") String artist,
                                 @RequestParam(value="songCount") double songCount,
                                 @RequestParam(value="length") double length,
                                 @RequestParam(value="imageUrl") String imageUrl){
        Album album = new Album(title,artist,songCount,length,imageUrl);
        albumRepository.save(album);
        return  new RedirectView("/albums");
  }

}
