package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.SneakyThrows;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

// BEGIN

// END
@Value
public class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    @SneakyThrows
    public String serialize() {
        return new ObjectMapper().writeValueAsString(this);
    }

    @SneakyThrows
    public static Car deserialize(String content) {
        return new ObjectMapper().readValue(content, Car.class);
    }
    // END
}
