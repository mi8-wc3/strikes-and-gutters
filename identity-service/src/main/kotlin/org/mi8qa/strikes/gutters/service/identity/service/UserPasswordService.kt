package org.mi8qa.strikes.gutters.service.identity.service

import org.mi8qa.strikes.gutters.service.identity.entity.UserPassword
import org.mi8qa.strikes.gutters.service.identity.repository.UserPasswordRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * Service for managing `UserPassword` entities.
 */
@Service
class UserPasswordService(@Autowired private val userPasswordRepository: UserPasswordRepository) {

    /**
     * Finds a user password by ID.
     */
    fun findById(id: Long): Mono<UserPassword> {
        return userPasswordRepository.findById(id)
    }

    /**
     * Finds all user passwords.
     */
    fun findAll(): Flux<UserPassword> {
        return userPasswordRepository.findAll()
    }

    /**
     * Saves a new user password.
     */
    fun save(userPassword: UserPassword): Mono<UserPassword> {
        return userPasswordRepository.save(userPassword)
    }

    /**
     * Deletes a user password by ID.
     */
    fun deleteById(id: Long): Mono<Void> {
        return userPasswordRepository.deleteById(id)
    }
}
