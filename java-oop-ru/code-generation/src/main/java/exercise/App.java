package exercise;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import static exercise.Car.deserialize;

// BEGIN
public class App {
    @SneakyThrows
    public static void save(Path path, Car car) {
        String json = car.serialize();
        BufferedWriter bf = new BufferedWriter(new FileWriter(path.toFile()));
        bf.write(json);
        bf.close();
    }

    @SneakyThrows
    public static Car extract(Path path) {
        String json = Files.readString(path);
        return deserialize(json);
    }


}
// END
