package org.mi8qa.strikes.gutters.service.identity.controller

import jakarta.validation.Valid
import org.mi8qa.strikes.gutters.service.identity.entity.UserPassword
import org.mi8qa.strikes.gutters.service.identity.facade.UserPasswordFacade
import org.mi8qa.strikes.gutters.service.identity.model.request.CreateUserPasswordRequest
import org.mi8qa.strikes.gutters.service.identity.model.response.PasswordCreatedResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * Controller for managing `UserPassword` entities.
 */
@RestController
@Validated
@RequestMapping("/user-passwords")
class UserPasswordController(@Autowired private val userPasswordFacade: UserPasswordFacade) {

    @GetMapping("/{id}")
    fun getUserPassword(@PathVariable id: Long): Mono<PasswordCreatedResponse> {
        return userPasswordFacade.getUserPasswordById(id)
            .map {
                PasswordCreatedResponse(
                    it.userId!!,
                    it.userLogin,
                    it.userEmail,
                    it.userPassword,
                    it.createdDate!!,
                    it.modifiedDate!!
                )
            }
    }

    @GetMapping
    fun getAllUserPasswords(): Flux<PasswordCreatedResponse> {
        return userPasswordFacade.getAllUserPasswords()
            .map {
                PasswordCreatedResponse(
                    it.userId!!,
                    it.userLogin,
                    it.userEmail,
                    it.userPassword,
                    it.createdDate!!,
                    it.modifiedDate!!
                )
            }
    }

    @PostMapping
    fun createUserPassword(@Valid @RequestBody request: CreateUserPasswordRequest): Mono<PasswordCreatedResponse> {
        val newUserPassword = UserPassword(
            userLogin = request.userLogin,
            userEmail = request.userEmail,
            userPassword = request.userPassword
        )
        return userPasswordFacade.storeUserPassword(newUserPassword)
            .map {
                PasswordCreatedResponse(
                    it.userId!!,
                    it.userLogin,
                    it.userEmail,
                    it.userPassword,
                    it.createdDate!!,
                    it.modifiedDate!!
                )
            }
    }

    @DeleteMapping("/{id}")
    fun deleteUserPassword(@PathVariable id: Long): Mono<Void> {
        return userPasswordFacade.removeUserPasswordById(id)
    }
}
