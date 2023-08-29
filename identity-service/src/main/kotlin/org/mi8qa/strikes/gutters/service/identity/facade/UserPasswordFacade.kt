package org.mi8qa.strikes.gutters.service.identity.facade

import org.mi8qa.strikes.gutters.service.identity.entity.UserPassword
import org.mi8qa.strikes.gutters.service.identity.service.UserPasswordService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * Facade for managing `UserPassword` entities.
 */
@Component
class UserPasswordFacade(@Autowired private val userPasswordService: UserPasswordService) {

    /**
     * Finds a user password by ID.
     */
    fun getUserPasswordById(id: Long): Mono<UserPassword> {
        return userPasswordService.findById(id)
    }

    /**
     * Gets all user passwords.
     */
    fun getAllUserPasswords(): Flux<UserPassword> {
        return userPasswordService.findAll()
    }

    /**
     * Stores a new user password.
     */
    fun storeUserPassword(userPassword: UserPassword): Mono<UserPassword> {
        // Add any additional business logic here.
        return userPasswordService.save(userPassword)
    }

    /**
     * Removes a user password by ID.
     */
    fun removeUserPasswordById(id: Long): Mono<Void> {
        return userPasswordService.deleteById(id)
    }
}
