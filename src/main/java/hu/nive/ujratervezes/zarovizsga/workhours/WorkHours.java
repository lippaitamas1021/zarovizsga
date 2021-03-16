package hu.nive.ujratervezes.zarovizsga.workhours;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WorkHours {

    private List<Work> result = new ArrayList<>();

    public String minWork(String file) {

        StringBuilder stringBuilder;
        try (Scanner scanner = new
                Scanner(WorkHours.class.getResourceAsStream("/hu.nive.ujratervezes.zarovizsga.workhours/workhours.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String name = parts[0];
                int numberOfWorkHours = Integer.parseInt(parts[1]);
                String date = parts[2];
                result.add(new Work(name, numberOfWorkHours, date));
            }
            int min = Integer.MAX_VALUE;
            stringBuilder = new StringBuilder();
            for (Work work : result) {
                if (work.getNumberOfWorkHours() < min) {
                    min = work.getNumberOfWorkHours();
                    stringBuilder.append(work.getName());
                    stringBuilder.append(": ");
                    stringBuilder.append(work.getDate());
                }
            }
        }
        stringBuilder.delete(0, 40);
        return stringBuilder.toString();
    }
}
