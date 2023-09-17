package org.mi8qa.strikes.gutters.service.identity.repository

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class UserMy(
    val id: Long? = null,
    @field:NotNull(message = "User name cannot be null")
    @field:Pattern(regexp = "^[^а-яА-Я]+$", message = "Login should not contain Cyrillic characters")
    val username: String,
    val password: String,
    val roles: List<String> = listOf("USER")
)
