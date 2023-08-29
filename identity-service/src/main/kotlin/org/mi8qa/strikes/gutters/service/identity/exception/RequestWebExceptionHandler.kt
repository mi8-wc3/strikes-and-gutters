package org.mi8qa.strikes.gutters.service.identity.exception

import com.fasterxml.jackson.databind.JsonMappingException
import org.mi8qa.strikes.gutters.service.identity.model.response.ErrorResponse
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebExceptionHandler
import reactor.core.publisher.Mono

@Component
@Order(-2)
class RequestWebExceptionHandler : WebExceptionHandler {

    override fun handle(exchange: ServerWebExchange, ex: Throwable): Mono<Void> {
        if (ex is JsonMappingException && ex.path.isNotEmpty()) {
            val field = ex.path.first().fieldName
            val error = ErrorResponse(
                field = field,
                jsonPath = "$.${ex.path.joinToString(".") { it.fieldName }}",
                reason = "Invalid format for $field."
            )
            exchange.response.statusCode = HttpStatus.BAD_REQUEST
            // Записать error в ответ можно, например, через DataBuffer
            // ...

            return Mono.empty()
        }
        return Mono.error(ex)
    }
}
