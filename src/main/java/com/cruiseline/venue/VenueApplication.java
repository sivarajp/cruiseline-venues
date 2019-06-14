package com.cruiseline.venue;

import com.cruiseline.venue.model.Venue;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class VenueApplication {

    public static void main(String[] args) {
        SpringApplication.run(VenueApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(VenueService venueService) {
        return args -> {
            // read json and write to db
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Venue>> typeReference = new TypeReference<List<Venue>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/venue.json");
            try {
                List<Venue> venues = mapper.readValue(inputStream,typeReference);
                venueService.save(venues);
                System.out.println("Venues Saved!");
            } catch (IOException e){
                System.out.println("Unable to save venues: " + e.getMessage());
            }
        };
    }
}
