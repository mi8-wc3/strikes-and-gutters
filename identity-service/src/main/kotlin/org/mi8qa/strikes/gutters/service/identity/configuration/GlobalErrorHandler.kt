package org.mi8qa.strikes.gutters.service.identity.configuration

import org.springframework.core.annotation.Order
import org.springframework.core.codec.DecodingException
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebExceptionHandler
import reactor.core.publisher.Mono

@Component
@Order(-2)
class GlobalErrorHandler : WebExceptionHandler {

    override fun handle(exchange: ServerWebExchange, ex: Throwable): Mono<Void> {
        if (ex is DecodingException) {
            exchange.response.statusCode = HttpStatus.BAD_REQUEST
            val dataBuffer = exchange.response.bufferFactory().wrap("Error occurred".toByteArray())
            return exchange.response.writeWith(Mono.just(dataBuffer))
        }
        return Mono.error(ex)
    }
}
