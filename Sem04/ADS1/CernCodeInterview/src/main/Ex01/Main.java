package Ex01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CollectionUtil<String> collection = new CollectionUtil<>();

        ArrayList<String> list = new ArrayList<>(Arrays.asList("b", "a", "c", "c", "e", "a", "c", "d", "c", "d"));

        List<String> duplicatesFromList = collection.getDuplicatesFromList(list);

        for (String s : duplicatesFromList) {
            System.out.println(s);
        }

    }
}
