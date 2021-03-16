package hu.nive.ujratervezes.zarovizsga.kennel;

import java.util.ArrayList;
import java.util.List;

public class Kennel {

    private List<Dog> dogs = new ArrayList<>();

    public List<Dog> getDogs() {
        return new ArrayList<>(dogs);
    }

    public void addDog(Dog dog) {
        dogs.add(dog);
    }

    public void feedAll() {
        for (Dog dog : dogs) {
            dog.feed();
        }
    }

    public Dog findByName(String name) {
        Dog d = null;
        for (Dog dog : dogs) {
            if (dog.getName().equals(name)) {
                d = new Husky(dog.getName());
            } else {
                throw new IllegalArgumentException("Can not find dog under this name");
            }
        }
        return d;
    }

    public void playWith(String name, int hours) {
        for (Dog dog : dogs) {
            if (name.equals(dog.getName())) {
                    dog.play(hours);
                }
            }
        }

    public List<String> getHappyDogNames(int minHappiness) {
        List<String> result = new ArrayList<>();

        for (Dog dog : dogs) {
            if (minHappiness < dog.getHappiness()) {
                result.add(dog.getName());
            }
        }
        return result;
    }
}

