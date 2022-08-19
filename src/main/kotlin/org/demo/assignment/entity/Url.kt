package org.demo.assignment.entity

import javax.persistence.*

@Entity
data class Url(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long? = 0,

    @Column(name = "original_url", nullable = false)
    val originalUrl: String? = "",

    @Column(name = "short_url", nullable = false)
    val shortUrl: String? = "",

    @Column(name = "created_ts", nullable = false)
    val createdTs: String? = "",

    )
