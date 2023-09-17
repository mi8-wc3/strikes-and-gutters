package org.mi8qa.strikes.gutters.service.identity.configuration

import UserRepository
import org.mi8qa.strikes.gutters.service.identity.entity.CustomUserDetails
import org.mi8qa.strikes.gutters.service.identity.repository.UserMy
import org.mockito.Mockito
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import reactor.core.publisher.Mono
import java.security.SecureRandom

@Configuration
class TestConfig {


    @Bean
    fun passwordEncoder(): PasswordEncoder {
        val secureRandom = SecureRandom.getInstanceStrong()
        return BCryptPasswordEncoder(12, secureRandom)
    }

    @Bean
    @Primary
    fun userRepository(): UserRepository {
        val userRepositoryMock = Mockito.mock(UserRepository::class.java)
        val user1 = CustomUserDetails(
            username = "user",
            password = passwordEncoder().encode("user")
        )
        Mockito.`when`(userRepositoryMock.save(user1)).thenReturn(Mono.just(user1))
        Mockito.`when`(userRepositoryMock.findByUsername(user1.username)).thenReturn(Mono.just(user1))
        return userRepositoryMock
    }
}
