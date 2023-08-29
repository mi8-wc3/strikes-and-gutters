package org.mi8qa.strikes.gutters.service.identity.repository

import org.mi8qa.strikes.gutters.service.identity.entity.UserPassword
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

/**
 * Repository for managing `UserPassword` entities.
 */
@Repository
interface UserPasswordRepository : ReactiveCrudRepository<UserPassword, Long> {

    /**
     * Finds a user password by user login.
     *
     * @param login The login of the user.
     * @return A Mono emitting the found user password or Mono.empty() if not found.
     */
    fun findByUserLogin(login: String): Mono<UserPassword>
}
