package Ex01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionUtil {

    //My more clever solution - O(n)
    public static <E extends Comparable<E>> List<E> getDuplicates(List<E> list) {
        Set<E> previousItems = new HashSet<E>();
        Set<E> result = new HashSet<E>();

        for(int i = 0; i < list.size(); i++) {
            E current = list.get(i);
            if(previousItems.contains(current)) {
                result.add(current);
            } else {
                previousItems.add(current);
            }
        }
        return new ArrayList<E>(result);
    }


    // My stupid solution - O(n^2)
//    public static <E extends Comparable<E>> List<E> getDuplicates(List<E> list) {
//        Set<E> set = new HashSet<E>();
//        for(int i = 0; i < list.size(); i++){
//            for(int j = 0; j < list.size(); j++) {
//                if(i == j) {
//                    continue;
//                }
//                if(list.get(i).compareTo(list.get(j)) == 0) {
//                    set.add(list.get(i));
//                }
//            }
//        }
//        return new ArrayList<E>(set);
//    }
}

//Notes

//I guess that the collection is collection for any type - therefore I will use generic E.
//To make it comparable, we will need to have E extend Comparable
//Now we can use generic E and method compareTo to compare whenever the objects are equal.
//My first solution will be a stupid one - very non efficient but it is the working one.
//Now the case can happen that I will add duplicate to the list several times. The best solution I think that I can come up with is to use Set that contains only unique values.
//I haven't worked with sets in Java before, therefore I will check them out on internet
//I have tested the method in IDE and it seems to work
//The solution is O(n^2)
//Not sure if the method should be static or not. I guess it should
//Now I would create test methods for the solution
//I will use junit and ZOMBIES, I won't create all test cases.
//I am using internet and previous exercises from my pc for the solution
//I have run the tests and they seem all to pass.
//I don't really like my solution but this is the first thing that came up to my mind and is easy to implement.
//I would definetly use internet for some more efficient algorithms but then it wouldn't be my solution.
//I usually do not make notes, I am trying to create code that is easy to read with naming conventions, I am doing it now for the interview
//One solution that I can see now is to use set:
//  Iterate through the input array and for each item check if the value is already in auxiliary.
//  If yes, push the item to the result set
//  If no, push the item to auxiliary set
//The solution would be O(n)