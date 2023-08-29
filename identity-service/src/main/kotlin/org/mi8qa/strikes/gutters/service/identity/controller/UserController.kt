package org.mi8qa.strikes.gutters.service.identity.controller

import jakarta.validation.Valid
import org.mi8qa.strikes.gutters.service.identity.entity.User
import org.mi8qa.strikes.gutters.service.identity.facade.UserFacade
import org.mi8qa.strikes.gutters.service.identity.model.request.CreateUserRequest
import org.mi8qa.strikes.gutters.service.identity.model.response.UserCreatedResponse
import org.mi8qa.strikes.gutters.service.identity.model.response.UserResponseBase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@Validated
@RequestMapping("/users")
class UserController(@Autowired private val userFacade: UserFacade) {

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    fun getUser(@PathVariable id: Long): Mono<UserCreatedResponse> {
        return userFacade.getUserById(id)
            .map { UserCreatedResponse(it.userId!!, it.userLogin, it.userEmail, it.userPassword, it.createdDate!!, it.modifiedDate!!) }
    }

    @GetMapping
    fun getAllUsers(): Flux<UserResponseBase> {
        return userFacade.getAllUsers()
            .map { UserCreatedResponse(it.userId!!, it.userLogin, it.userEmail, it.userPassword, it.createdDate!!, it.modifiedDate!!) }
    }

    @PostMapping
    fun createUser(@Valid @RequestBody request: CreateUserRequest): Mono<UserResponseBase> {
        val newUser =
            User(userLogin = request.userLogin, userEmail = request.userEmail, userPassword = request.userPassword)
        return userFacade.registerUser(newUser)
            .map { UserCreatedResponse(it.userId!!, it.userLogin, it.userEmail, it.userPassword, it.createdDate!!, it.modifiedDate!!) }
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long): Mono<Void> {
        return userFacade.removeUserById(id)
    }
}
