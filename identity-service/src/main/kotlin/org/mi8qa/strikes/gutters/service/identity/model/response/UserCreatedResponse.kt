package org.mi8qa.strikes.gutters.service.identity.model.response

import java.time.LocalDateTime

/**
 * Response for successful user creation.
 */
data class UserCreatedResponse(
    override val userId: Long,
    override val userLogin: String,
    override val userEmail: String,
    override val userPassword: String,
    override val createdDate: LocalDateTime,
    override val modifiedDate: LocalDateTime
) : UserResponseBase(userId, userLogin, userEmail, userPassword, createdDate, modifiedDate)
