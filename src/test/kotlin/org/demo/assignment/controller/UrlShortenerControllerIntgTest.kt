package org.demo.assignment.controller

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ActiveProfiles("dev")
@AutoConfigureWebTestClient
class UrlShortenerControllerIntgTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    //@Test
    fun retrieveOriginalUrl(){
        val shorturl = "gd54f6"
        val originalUrl = "https://www.hindustantimes.com/"
       val result=  webTestClient.get()
            .uri("api/v1/url/originalurl/7U52r9")
            .exchange()
            .expectStatus().is2xxSuccessful
            .expectBody(String::class.java)
            .returnResult()

            Assertions.assertEquals("$originalUrl, https://www.hindustantimes.com/", result.responseBody)

    }
}