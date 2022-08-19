package org.demo.assignment.service

import org.demo.assignment.entity.Url
import org.demo.assignment.exception.ErrorMessages
import org.demo.assignment.exception.NotFoundException
import org.demo.assignment.repository.UrlRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Example
import org.springframework.stereotype.Service

@Service
class UrlService(private val urlRepository: UrlRepository) {
    private val logger: Logger = LoggerFactory.getLogger(Example::class.java)

    fun findOriginalUrl(originalUrl: String): Url? {
        logger.info("createShortUrl() : findOriginalUrl: {}")
        val urlExist = urlRepository.findByOriginalUrl(originalUrl)
        if (urlExist != null) {
            return urlExist
        }
        return null
    }

    fun createShortUrl(url: Url): Url {
        logger.info("createShortUrl() : {}")
        return urlRepository.save(url)
    }

    fun responseById(shortUrl: String): Url? {
        logger.info("responseById() shortUrl: {}$shortUrl")

        val shortenUrl = urlRepository.findByShortUrl(shortUrl) ?: throw NotFoundException(
            ErrorMessages.notFoundError(shortUrl)
        )
        return shortenUrl
    }
}