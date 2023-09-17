package org.mi8qa.strikes.gutters.service.identity.configuration

import com.mongodb.reactivestreams.client.MongoClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories


@Configuration
@EnableReactiveMongoRepositories("org.mi8qa.strikes.gutters.service.identity.repository")
class MongoConfig {

    @Bean
    fun reactiveMongoTemplate(): ReactiveMongoTemplate {
        return ReactiveMongoTemplate(simpleReactiveDatabaseFactory())
    }

    @Bean
    fun simpleReactiveDatabaseFactory(): SimpleReactiveMongoDatabaseFactory {
        return SimpleReactiveMongoDatabaseFactory(MongoClients.create(), "yourDatabaseName")
    }
}
