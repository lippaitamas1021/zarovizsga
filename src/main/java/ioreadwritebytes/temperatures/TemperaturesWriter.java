package ioreadwritebytes.temperatures;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemperaturesWriter {

    public void writeTemperatures(Temperatures temperatures, String pathString) {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(Path.of(pathString))))) {
            for (byte b : temperatures.getData()) {
                dataOutputStream.write(b);
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not write the file", ioe);
        }
    }
}
