# Spring for Full-Stack Web Apps
I use the Spring Initializer to create a new application with artifact songr with Web and Thymeleaf (and optionally Devtools) dependencies. Download the zip file and extract the directory it contains. 
I create album class that I can add albums with set of songs, and I used psql to save the albums

Lab: 11

Controllers: <br>
- @GetMapping("/hello"): Render the data from helloWorld.html <br>
- @GetMapping("/capitalize/hello"): Show the name in UpperCase by using request params render it using Capitalized.html file <br>
- @GetMapping("/albums") : Adding Albums in Array list each album have some details such us title, artist, song count, length and image.
<hr>
Lab: 12

Controllers: <br>
- @GetMapping("/addAlbum") : it will render a form from NewAlbum this form for users can insert albums details.
- @PostMapping("/albums"): the user will post the data after put it in the form and will send it to database and save them.
- @GetMapping("/albums") : the same controllers in lab 11 but instead of using array we used database (postgres) to render the album details from database.
<hr>

Lab: 13



*partners:*<br>
We were working as navigator and driver, Alaa Al-Abbas and Amara Albalkhi

<br>

#### Table of contents
| LAB #  |  url |   
|---     |---|
| Lab: 11 - Spring for Full-Stack Web Apps | [URL](https://github.com/alaa281997/songr/tree/lab11)   |  
| Lab: 12 - Spring and REST |[URL](https://github.com/alaa281997/songr/tree/lab12)    |  
| Lab: 13 - Related Resources and Integration Testing | [URL](https://github.com/alaa281997/songr/tree/lab13)  | 