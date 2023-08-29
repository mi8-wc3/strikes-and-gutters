package org.mi8qa.strikes.gutters.service.identity.model.response

import java.time.LocalDateTime

/**
 * Sealed class for user-related responses.
 */
sealed class UserResponseBase(

    open val userId: Long,
    open val userLogin: String,
    open val userEmail: String,
    open val userPassword: String,
    open val createdDate: LocalDateTime,
    open val modifiedDate: LocalDateTime
)
