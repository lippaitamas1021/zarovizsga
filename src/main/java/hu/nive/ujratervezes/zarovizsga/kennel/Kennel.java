package hu.nive.ujratervezes.zarovizsga.kennel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Kennel {

    List<Dog> dogs = new ArrayList<>();

    public List<Dog> getDogs() {
        return dogs;
    }

    public void addDog(Dog dog) {
        dogs.add(dog);
    }

    public void feedAll() {
        for (Dog dog : dogs) {
            dog.feed();
        }
        //dogs.forEach(Dog::feed);
    }

    public Dog findByName(String name) {
        for (Dog dog : dogs) {
            if (dog.getName().equals(name)) {
                return dog;
            }
        }
        throw new IllegalArgumentException("No dog under this name");
        //dogs.stream().filter(d -> d.getName().equals(name)).findAny().orElseThrow(() -> new IllegalArgumentException("No dog under this name"));
    }

    public void playWith(String name, int hours) {
        findByName(name).play(hours);
    }

    public List<String> getHappyDogNames(int minHappiness) {
        List<String> happyDogs = new ArrayList<>();
        for (Dog dog : dogs) {
            if (minHappiness < dog.getHappiness()) {
                happyDogs.add(dog.getName());
            }
        }
        return happyDogs;
        //return dogs.stream().filter(d -> d.getHappiness() > minHappiness).map(Dog::getName).collect(Collectors.toList());
    }
}

