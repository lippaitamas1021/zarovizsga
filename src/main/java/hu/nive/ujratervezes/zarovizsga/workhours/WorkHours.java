package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WorkHours {

    public String minWork(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Path.of(fileName));
            return findMin(lines);
        } catch (IOException e) {
            throw new IllegalStateException("Can not read the file", e);
        }
    }

    private String findMin(List<String> lines) {
        int minHours = 25;
        String result = null;
        for (String line : lines) {
            String[] parts = line.split(",");
            String name = parts[0];
            int hour = Integer.parseInt(parts[1]);
            String date = parts[2];
            if (hour < minHours) {
                minHours = hour;
                result = name + ": " + date;
            }
        }
        return result;
    }
}