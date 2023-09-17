package org.mi8qa.strikes.gutters.service.identity.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.format.Formatter
import org.springframework.format.FormatterRegistry
import org.springframework.web.reactive.config.WebFluxConfigurer
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

@Configuration
class WebConfig : WebFluxConfigurer {

    override fun addFormatters(registry: FormatterRegistry) {
        registry.addFormatter(LocalDateFormatter())
    }
}

class LocalDateFormatter : Formatter<LocalDate> {

    private val dateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    override fun print(obj: LocalDate, locale: Locale): String {
        return dateFormatter.format(obj)
    }

    override fun parse(text: String, locale: Locale): LocalDate {
        return LocalDate.parse(text, dateFormatter)
    }
}
