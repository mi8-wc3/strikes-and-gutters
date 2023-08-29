package org.mi8qa.strikes.gutters.service.identity.repository

import org.mi8qa.strikes.gutters.service.identity.entity.User
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

/**
 * Repository for managing `User` entities.
 */
@Repository
interface UserRepository : ReactiveCrudRepository<User, Long> {

    /**
     * Finds a user by email.
     *
     * @param email The email of the user.
     * @return A Mono emitting the found user or Mono.empty() if not found.
     */
    fun findByUserEmail(email: String): Mono<User>

    //@Transactional databaseClient.inTransaction { transactionalDatabaseClient ->
    //            transactionalDatabaseClient.insert().into(User::class.java)
    //                .using(user)
    //                .fetch()
    //                .one()
    //                .cast(User::class.java)
}
