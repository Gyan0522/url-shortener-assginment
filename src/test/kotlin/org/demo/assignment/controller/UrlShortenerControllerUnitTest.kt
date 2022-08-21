package org.demo.assignment.controller

import org.demo.assignment.controlller.UrlShortenerController
import org.demo.assignment.service.UrlService

import org.junit.jupiter.api.Assertions
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.reactive.server.WebTestClient

@WebMvcTest(controllers = [UrlShortenerController::class])
@AutoConfigureWebTestClient
class UrlShortenerControllerUnitTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @MockBean
    lateinit var urlServiceMock: UrlService

    //@Test
    fun retrieveOriginalUrl() {

        val shorturl = "gd54f6"
        val originalUrl = "https://www.hindustantimes.com/"
        val result=  webTestClient.get()
            .uri("api/v1/url/originalurl/shorturl")
            .exchange()
            .expectStatus().is2xxSuccessful
            .expectBody(String::class.java)
            .returnResult()

        Assertions.assertEquals("$originalUrl, https://www.hindustantimes.com/", result.responseBody)

    }
}