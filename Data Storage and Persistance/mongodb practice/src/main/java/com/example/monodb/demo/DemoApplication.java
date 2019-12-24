package com.example.monodb.demo;

import com.example.monodb.demo.entity.Address;
import com.example.monodb.demo.entity.Member;
import com.example.monodb.demo.repository.MemberRepository;
import com.google.gson.Gson;
import com.mongodb.client.*;
import org.bson.types.ObjectId;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.bson.Document;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Optional;

@SpringBootApplication
public class DemoApplication {
   /* private  static  final String uri = "mongodb://localhost:27017";
    private static final MongoClient mongoClient = MongoClients.create(uri);
    private static final MongoDatabase database = mongoClient.getDatabase("srikanth");*/

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        /*database.createCollection("members");
        MongoCollection<Document> members = database.getCollection("members");
        //Member member = new Member("Jane", "Doe", "female" , 45, new Address("123 Main st", "Chicago", "IL") ,new String [] {"pilates","swim","crossfit"}, 125.20);

        //Document member = new Document();
        Document member = new Document().append("first_name", "Jane")
                                        .append("last_name", "Doe")
                                        .append("age", 45)
                                        .append("gender", "female")
                                        .append("interests", Arrays.asList("pilates","swim","crossfit"))
                                        .append("balance", 125.20)
                                        .append("address", new Document().append("street", "123 Main st")
                                                                        .append("city", "Chicago"));
        members.insertOne(member);

        MongoCursor <Document> cursor = members.find().iterator();
        try{
            while(cursor.hasNext()){
                System.out.println(cursor.next().toJson());
            }
        }finally {
            cursor.close();
        }

        mongoClient.close();*/
    }

    @Bean
    public CommandLineRunner commandLineRunner(MemberRepository memberRepository){
        return args -> {
            Member member = new Member("Jane", "Doe", "female" , 45, new Address("123 Main st", "Chicago", "IL") ,new String [] {"pilates","swim","crossfit"}, 125.20);

            Member member1 = memberRepository.save(member);

            Optional<Member> optionalMember = memberRepository.findByFirstName("Jane");
            if(optionalMember.isPresent()){
                System.err.println(new Gson().toJson(optionalMember.get()));
            }

            String id = member1.getId();
            Optional<Member> optionalMember1 = memberRepository.findById(id);
            if(optionalMember1.isPresent()){
                System.err.println(new Gson().toJson(optionalMember.get()));
            }

        };
    }
}
