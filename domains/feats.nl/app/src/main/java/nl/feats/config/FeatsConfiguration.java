package nl.feats.config;

import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.net.UnknownHostException;

/**
 * Main Spring configuration class
 * User: martin
 * Date: 2/22/13
 * Time: 1:27 PM
 */
@Configuration
@ComponentScan(basePackages = {"nl.feats"})
public class FeatsConfiguration {

    @Bean
    public MongoTemplate getMongoTemplate() throws UnknownHostException {
//        MongoDbFactory factory = new SimpleMongoDbFactory(new Mongo(), "feats",new UserCredentials("featsdb", "DahliaPumpkinSalmonShelfSpandex"));
        MongoDbFactory factory = new SimpleMongoDbFactory(new Mongo(), "feats");
        return new MongoTemplate(factory);
    }

}
