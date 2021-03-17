package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class WorkHours {

    private List<Work> works = new ArrayList<>();

    public String minWork(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        String name2 = null;
        int number2 = 0;
        String date2 = null;
        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(fileName));) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                int number = Integer.parseInt(parts[1]);
                String date = parts[2];
                works.add(new Work(name, number, date));
            }
            int min = Integer.MAX_VALUE;

            for (Work work : works) {
                if (work.getNumber() < min) {
                    min = work.getNumber();
                    name2 = work.getName();
                    number2 = work.getNumber();
                    date2 = work.getDate();
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read the file", ioe);
        }
        stringBuilder.append(name2);
        stringBuilder.append(": ");
        stringBuilder.append(date2);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        WorkHours workHours = new WorkHours();
        System.out.println(workHours.minWork("D:\\training\\training-solutions\\src\\test\\resources\\hu.nive.ujratervezes.zarovizsga.workhours\\workhours.txt"));
    }

//    private List<Work> result = new ArrayList<>();
//
//    public String minWork(String file) {
//
//        StringBuilder stringBuilder;
//        try (Scanner scanner = new
//                Scanner(WorkHours.class.getResourceAsStream("/hu.nive.ujratervezes.zarovizsga.workhours/workhours.txt"))) {
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                String[] parts = line.split(",");
//                String name = parts[0];
//                int numberOfWorkHours = Integer.parseInt(parts[1]);
//                String date = parts[2];
//                result.add(new Work(name, numberOfWorkHours, date));
//            }
//            int min = Integer.MAX_VALUE;
//            stringBuilder = new StringBuilder();
//            for (Work work : result) {
//                if (work.getNumberOfWorkHours() < min) {
//                    min = work.getNumberOfWorkHours();
//                    stringBuilder.append(work.getName());
//                    stringBuilder.append(": ");
//                    stringBuilder.append(work.getDate());
//                }
//            }
//        }
//        stringBuilder.delete(0, 40);
//        return stringBuilder.toString();
//    }
}
