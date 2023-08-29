package org.mi8qa.strikes.gutters.service.identity.facade

import org.mi8qa.strikes.gutters.service.identity.entity.User
import org.mi8qa.strikes.gutters.service.identity.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * Facade for managing `User` entities.
 */
@Component
class UserFacade(@Autowired private val userService: UserService) {

    /**
     * Finds a user by ID.
     */
    fun getUserById(id: Long): Mono<User> {
        return userService.findById(id)
    }

    /**
     * Gets all users.
     */
    fun getAllUsers(): Flux<User> {
        return userService.findAll()
    }

    /**
     * Registers a new user.
     */
    fun registerUser(user: User): Mono<User> {
        // Add any additional business logic here.
        return userService.save(user)
    }

    /**
     * Removes a user by ID.
     */
    fun removeUserById(id: Long): Mono<Void> {
        return userService.deleteById(id)
    }
}
