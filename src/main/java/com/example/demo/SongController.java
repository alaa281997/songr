package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class SongController {
    @Autowired
    private SongRepository songRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @GetMapping("/songs")
    public String getAllSongs(Model m){
        List<Song> songs = songRepository.findAll();
        m.addAttribute("songs",songs);
        return "Song";
    }

    @GetMapping("/addSong")
    public String getAddSong(){
        return "addSong.html";
    }

    @PostMapping("/songs")
    public String addSong(@RequestParam(value = "title") String title ,
                          @RequestParam(value= "trackNumber") int trackNumber,
                          @RequestParam(value="length") int length,
                          @RequestParam(value="albumID") long albumID, Model m){
        Album album = albumRepository.findById(albumID).get();
        Song song = new Song(title,length,trackNumber,album);
        songRepository.save(song);
        Album newAlbum = albumRepository.findById(album.getId()).get();
        m.addAttribute("songs", newAlbum.getSongs());
        return "/songs";
    }

}
