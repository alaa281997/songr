package com.example.demo;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}
/*
    public Album(String title, String artist, double songCount, double length, String imageUrl) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
        this.imageUrl = imageUrl;


    }
 */
	@Test
	void testConstructor() {
		Album album1 = new Album("Title","Artist",20,1200,"https://via.placeholder.com/150");
        album1.setTitle("Title");
        assertEquals("Title",album1.getTitle());
        album1.setArtist("Artist");
        assertEquals("Artist",album1.getArtist());
        album1.setSongCount(2.6);
        assertEquals(2.6,album1.getSongCount(2.6));
		album1.setLength(10000);
		assertEquals(10000 , album1.getLength());
	}
}
