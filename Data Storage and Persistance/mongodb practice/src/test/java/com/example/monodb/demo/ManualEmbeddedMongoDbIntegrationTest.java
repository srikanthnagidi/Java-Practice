package com.example.monodb.demo;


import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
@ExtendWith(SpringExtension.class)
public class ManualEmbeddedMongoDbIntegrationTest {

    private MongodExecutable mongodExecutable;
    private MongoTemplate mongoTemplate;

    private  static  final String uri = "mongodb://localhost:27017";
    private static final MongoClient mongoClient = MongoClients.create(uri);

    @AfterEach
    public void clean(){
        mongodExecutable.stop();
    }

    @BeforeEach
    public void setup() throws Exception{
        String ip = "localhost";
        int port = 27017;

        IMongodConfig mongodConfig = new MongodConfigBuilder().version(Version.Main.PRODUCTION)
                .net(new Net(ip, port, Network.localhostIsIPv6()))
                .build();

        MongodStarter starter = MongodStarter.getDefaultInstance();
        mongodExecutable = starter.prepare(mongodConfig);
        mongodExecutable.start();

        mongoTemplate = new MongoTemplate(mongoClient, "test");

    }

    @DisplayName("given object to save"
            + " when save object using MongoDB template"
            + " then object is saved")
    @Test
    public void test() throws Exception {
        // given
        DBObject objectToSave = BasicDBObjectBuilder.start()
                .add("key", "value")
                .get();

        // when
        mongoTemplate.save(objectToSave, "collection");

        // then
        assertThat(mongoTemplate.findAll(DBObject.class, "collection")).extracting("key")
                .containsOnly("value");
    }
}
