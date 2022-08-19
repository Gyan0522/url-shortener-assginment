package org.demo.assignment.repository

import org.demo.assignment.entity.Url
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UrlRepository : JpaRepository<Url, Long> {
    fun findByShortUrl(shortUrl: String): Url?
    fun findByOriginalUrl(originalUrl: String): Url?
}
