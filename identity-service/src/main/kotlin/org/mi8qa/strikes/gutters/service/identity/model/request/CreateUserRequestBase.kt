package org.mi8qa.strikes.gutters.service.identity.model.request

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.*

/**
 * Sealed class for creating user and user password requests.
 */
sealed class CreateUserRequestBase(
    @field:NotNull(message = "Login cannot be null.")
    @field:NotBlank(message = "Login cannot be blank.")
    @field:Size(min = 6, max = 50, message = "Login can only contain 6 up to 50 characters.")
    @field:Pattern(regexp = "^[a-zA-Z0-9._-]+$", message = "Login can only contain latin characters, numbers, ., _, -.")
    @Schema(
        maxLength = 50,
        minLength = 6,
        pattern = "^[a-zA-Z0-9._-]+$"
    )
    open val userLogin: String,

    @field:Email(message = "Invalid email format.")
    @field:Size(max = 254, message = "Email cannot exceed 254 characters.")
    @Schema(
        maxLength = 254,
        minLength = 1
    )
    open val userEmail: String,

    @field:NotNull(message = "Password cannot be null.")
    @field:NotBlank(message = "Password cannot be blank.")
    @field:Size(min = 6, max = 50, message = "Password can only contain 6 up to 50 characters.")
    @field:Schema(description = "abcd",
        maxLength = 60,
        minLength = 6
    )
    open val userPassword: String
)
