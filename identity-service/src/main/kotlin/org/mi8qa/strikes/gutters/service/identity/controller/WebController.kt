package org.mi8qa.strikes.gutters.service.identity.controller

import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

@Controller
class WebController {

    @GetMapping("/session-details")
    @ResponseBody
    fun getSessionDetails(
        @AuthenticationPrincipal userDetails: UserDetails?,
        exchange: ServerWebExchange
    ): Mono<String> {
        return exchange.session.flatMap { session ->
            val details = session?.attributes?.get("SPRING_SECURITY_CONTEXT")?.let {
                "Session ID: ${session.id}\nUser Details: ${userDetails?.username}\nAuthorities: ${userDetails?.authorities}"
            } ?: "No session available"
            Mono.just(details)
        }
    }

}
