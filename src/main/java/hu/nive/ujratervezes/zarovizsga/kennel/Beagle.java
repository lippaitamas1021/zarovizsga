package hu.nive.ujratervezes.zarovizsga.kennel;

public class Beagle extends Dog {

    public Beagle(String name) {
        super(name);
    }

    @Override
    void feed() {
        happiness += 2;
    }

    @Override
    void play(int hours) {
        happiness += hours * 2;
    }

//    public Beagle(String name) {
//        super(name);
//    }
//
//    @Override
//    void feed() {
//        this.happiness += 2;
//    }
//
//    @Override
//    void play(int hours) {
//        this.happiness += hours * 2;
//    }
}
