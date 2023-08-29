package org.mi8qa.strikes.gutters.service.identity.configuration

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration
import io.r2dbc.postgresql.PostgresqlConnectionFactory
import io.r2dbc.spi.ConnectionFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import org.springframework.r2dbc.connection.R2dbcTransactionManager
import org.springframework.transaction.ReactiveTransactionManager

/**
 * R2DBC configuration class.
 */
@Configuration
@EnableR2dbcRepositories(basePackages = ["org.mi8qa.strikes.gutters.service.identity.repository"])
open class DatabaseConfig : AbstractR2dbcConfiguration() {

    @Value("\${spring.r2dbc.url}")
    private lateinit var url: String

    @Value("\${spring.r2dbc.username}")
    private lateinit var username: String

    @Value("\${spring.r2dbc.password}")
    private lateinit var password: String

    /**
     * Creates a new ConnectionFactory.
     *
     * @return a configured ConnectionFactory instance.
     */
    override fun connectionFactory(): ConnectionFactory {
        val config = PostgresqlConnectionConfiguration.builder()
            .host(url)
            .username(username)
            .password(password)
            .build()

        return PostgresqlConnectionFactory(config)
    }

    /**
     * Creates a new R2dbcTransactionManager.
     *
     * @param connectionFactory the ConnectionFactory.
     * @return a configured R2dbcTransactionManager instance.
     */
    @Bean
    fun transactionManager(connectionFactory: ConnectionFactory): ReactiveTransactionManager {
        return R2dbcTransactionManager(connectionFactory)
    }
}
