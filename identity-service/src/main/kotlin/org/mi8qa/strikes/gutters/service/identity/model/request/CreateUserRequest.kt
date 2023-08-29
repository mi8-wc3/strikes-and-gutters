package org.mi8qa.strikes.gutters.service.identity.model.request

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

/**
 * Concrete class for creating a new user.
 */
data class CreateUserRequest(
    override val userLogin: String,
    override val userEmail: String,
    @field:NotNull(message = "Password cannot be null.")
    @field:NotBlank(message = "Password cannot be blank.")
    @field:Size(min = 6, max = 50, message = "Password can only contain 6 up to 50 characters.")
    @field:Schema(description = "abcd",
        maxLength = 60,
        minLength = 6
    )
    override val userPassword: String
) : CreateUserRequestBase(userLogin, userEmail, userPassword)
