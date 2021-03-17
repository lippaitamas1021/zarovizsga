package hu.nive.ujratervezes.zarovizsga.workhours;

public class Work {

    private String name;
    private int number;
    private String date;

    public Work(String name, int number, String date) {
        this.name = name;
        this.number = number;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public String getDate() {
        return date;
    }

//    private String name;
//    private int numberOfWorkHours;
//    private String date;
//
//    public Work(String name, int numberOfWorkHours, String date) {
//        this.name = name;
//        this.numberOfWorkHours = numberOfWorkHours;
//        this.date = date;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getNumberOfWorkHours() {
//        return numberOfWorkHours;
//    }
//
//    public String getDate() {
//        return date;
//    }
}
