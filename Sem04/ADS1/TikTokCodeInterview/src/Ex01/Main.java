package Ex01;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        String light = "000111";
        int i = beautifulLight(light);
        System.out.println(i);
    }
    public static int beautifulLight(String light) {
        // Write your code here
        int changesWithStringStartingWithZero = 0;
        int changesWithStringStartingWithOne = 0;

        boolean currentState = true;

        for (int i = 0; i < light.length(); i++) {
            if(currentState) {
                if(!(light.charAt(i) == '0')) {
                    changesWithStringStartingWithOne++;
                }
            } else {
                if(!(light.charAt(i) == '1')) {
                    changesWithStringStartingWithOne++;
                }
            }
            currentState = !currentState;
        }

        currentState = false;
        //111000
        for (int i = 0; i < light.length(); i++) {
            if(currentState) {
                if(light.charAt(i) == '1') {
                    changesWithStringStartingWithZero++;
                }
            } else {
                if(light.charAt(i) == '0') {
                    changesWithStringStartingWithZero++;
                }
            }
            currentState = !currentState;
        }

        return Collections.min(Arrays.asList(changesWithStringStartingWithOne, changesWithStringStartingWithZero));
    }
}
