package org.example.lib.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    @Value("#{ environment.MONGO_HOST ?: 'localhost' }")
    private String hostname;

    @Value("#{ environment.MONGO_PORT ?: 27017 }")
    private int port;

    @Value("#{ environment.MONGO_COLLECTION ?: 'data' }")
    private String collection;

    @Bean
    public MongoClientFactoryBean mongo() {
        MongoClientFactoryBean mongoClientFactoryBean = new MongoClientFactoryBean();
        mongoClientFactoryBean.setHost(this.hostname);
        mongoClientFactoryBean.setPort(this.port);

        /* User/Pass Example
        MongoCredential mongoCredential = MongoCredential.createCredential(
                "username", 
                "database", 
                "password".toCharArray()
        );
        mongoClientFactoryBean.setCredential(new MongoCredential[]{ mongoCredential });
        */
        
        return mongoClientFactoryBean;
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(
                mongo().getObject(),
                this.collection
        );
    }
}

