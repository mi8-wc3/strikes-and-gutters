package org.mi8qa.strikes.gutters.service.identity.service

import org.mi8qa.strikes.gutters.service.identity.entity.User
import org.mi8qa.strikes.gutters.service.identity.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * Service for managing `User` entities.
 */
@Service
class UserService(@Autowired private val userRepository: UserRepository) {

    /**
     * Finds a user by ID.
     */
    fun findById(id: Long): Mono<User> {
        return userRepository.findById(id)
    }

    /**
     * Finds all users.
     */
    fun findAll(): Flux<User> {
        return userRepository.findAll()
    }

    /**
     * Saves a new user.
     */
    fun save(user: User): Mono<User> {
        return userRepository.save(user)
    }

    /**
     * Deletes a user by ID.
     */
    fun deleteById(id: Long): Mono<Void> {
        return userRepository.deleteById(id)
    }
}
