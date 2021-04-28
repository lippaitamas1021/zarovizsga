package ioreadwritebytes.temperatures;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemperaturesReader {

    public Temperatures readTemperatures(String pathString) {
        try {
            byte[] b = Files.readAllBytes(Path.of(pathString));
            return new Temperatures(b);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read the file", ioe);
        }
    }
}
