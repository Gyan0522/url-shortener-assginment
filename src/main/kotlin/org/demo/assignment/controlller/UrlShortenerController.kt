package org.demo.assignment.controlller

import org.demo.assignment.entity.Url
import org.demo.assignment.exception.ErrorMessages
import org.demo.assignment.exception.UrlServiceException
import org.demo.assignment.service.UrlService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.time.Instant
import java.time.format.DateTimeFormatter

@RestController
@RequestMapping("/api/v1/url")
class UrlShortenerController(private val urlService: UrlService) {
    private val logger: Logger = LoggerFactory.getLogger(UrlShortenerController::class.java)

    @PostMapping("/shorten")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    fun createShortUrl(@RequestBody url: Url): Url {

        if (url.originalUrl?.isBlank() == true) {
            logger.info("originalUrl is null in the request {}" + url.originalUrl?.isBlank())
            throw UrlServiceException(ErrorMessages.UrlServiceException("originalUrl"))
        }

        val currentTime = DateTimeFormatter.ISO_INSTANT.format(Instant.now())
        logger.info("createShortUrl() : originalUrl: {}", url.originalUrl)


        val urlExist = url.originalUrl?.let { urlService.findOriginalUrl(it) }
        logger.info("createShortUrl()  originalUrl: {}", urlExist)

        val shortUrl = generateRandomUrl()

        if (urlExist == null) {
            logger.info("original URL to shorten doesn't exist : {}", urlExist)
            val url = Url(
                originalUrl = url.originalUrl,
                shortUrl = shortUrl,
                createdTs = currentTime
            )
            return urlService.createShortUrl(url)
        }
        logger.info("Original URL to shorten already exist", urlExist)
        return urlExist
    }

    @GetMapping("/originalurl/{shortUrl}")
    @ResponseBody
    fun getOriginalUrl(@PathVariable("shortUrl") shortUrl: String): Url? {
        logger.info("getOriginalUrl() : shortUrl: {}", shortUrl)
        return urlService.responseById(shortUrl)
    }

    fun generateRandomUrl(length: Int = 6): String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1..length)
            .map { allowedChars.random() }
            .joinToString("")
    }

}



