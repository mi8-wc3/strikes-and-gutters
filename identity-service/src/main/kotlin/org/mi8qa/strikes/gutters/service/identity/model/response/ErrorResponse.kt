package org.mi8qa.strikes.gutters.service.identity.model.response

/**
 * Response for generic errors.
 */
data class ErrorResponse(
    val field: String,
    val jsonPath: String,
    val reason: String
)
