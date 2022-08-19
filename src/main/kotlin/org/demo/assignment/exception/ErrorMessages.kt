package org.demo.assignment.exception

object ErrorMessages {
    const val NOT_FOUND = "Short URL not found"

    //  const val EMPTY_SHORT_URL = "Invalid search param:Short URL must not be blank."
    fun notFoundError(name: String) = "$NOT_FOUND:Short URL $name not found. Please enter valid short URL"
}