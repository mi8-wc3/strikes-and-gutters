package org.mi8qa.strikes.gutters.service.identity.entity

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

/**
 * Represents a User entity in the database.
 *
 * @property userId The unique identifier for the user.
 * @property userLogin The login name of the user.
 * @property userEmail The email address of the user.
 * @property userPassword The hashed password for the user.
 * @property createdDate The date and time when the user was created.
 * @property modifiedDate The date and time when the user was last modified.
 */
@Table("users")
data class User(
    @Id val userId: Long? = null,

    @Column("user_login") // Explicitly map to the column in database
    @NotEmpty // Ensure the field is not empty
    val userLogin: String,

    @Column("user_email")
    @Email // Ensure the field is a valid email address
    @NotEmpty
    val userEmail: String,

    @Column("user_password")
    @NotEmpty
    val userPassword: String,

    @CreatedDate
    @Column("created_date")
    val createdDate: LocalDateTime? = null,

    @LastModifiedDate
    @Column("modified_date")
    val modifiedDate: LocalDateTime? = null
)
