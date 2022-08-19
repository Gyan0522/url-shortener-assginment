package org.demo.assignment.exception

class UrlServiceException(message: String) : RuntimeException(message)

class NotFoundException(message: String) : RuntimeException(message)