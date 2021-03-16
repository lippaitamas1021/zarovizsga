package hu.nive.ujratervezes.zarovizsga.digitscounter;

import java.util.ArrayList;
import java.util.List;

public class DigitsCounter {


    public int getCountOfDigits(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int key = Integer.parseInt(String.valueOf(s.charAt(i)));
                if (!result.contains(key)) {
                    result.add(key);
                }
            }
        return result.size();
    }
}

