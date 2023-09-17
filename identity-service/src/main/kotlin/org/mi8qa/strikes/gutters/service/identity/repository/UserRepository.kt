import org.mi8qa.strikes.gutters.service.identity.entity.CustomUserDetails
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono


@Repository
interface UserRepository : ReactiveMongoRepository<CustomUserDetails, Long> {
    fun findByUsername(username: String): Mono<CustomUserDetails>

}
