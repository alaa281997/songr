package com.example.demo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class DemoApplicationTests {
	@Autowired
	private TestRestTemplate restTemplate;
	@Autowired
	private MockMvc mockMvc;
	@LocalServerPort
	private int port;


	@Test
	public void testHelloWorlds() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/hello", String.class)).contains("Hello from hello Route");
	}

	@Test
	public void testHelloWorld() throws Exception {
		this.mockMvc.perform(get("/hello")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello from hello Route")));	}
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
