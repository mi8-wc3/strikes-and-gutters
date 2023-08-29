package org.mi8qa.strikes.gutters.service.identity.model.request

/**
 * Concrete class for creating a new user password.
 */
data class CreateUserPasswordRequest(
    override val userLogin: String,
    override val userEmail: String,
    override val userPassword: String
) : CreateUserRequestBase(userLogin, userEmail, userPassword)
