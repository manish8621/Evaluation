
import java.util.HashMap;

import java.util.Set;

public class P4EqualArrays {

    public static void main(String[] args) {
        int[] arrA = {1,2,2,9,8};
        int[] arrB = {2,2,2,2,1};

        if(equals(arrA,arrB)){
            System.out.println("Equals");
        }
        else
            System.out.println("Not Equals");
    }

    private static boolean equals(int[] arrA, int[] arrB) {
        //if length not equal
        if(arrA.length != arrB.length) return false;
        
        HashMap<Integer,Integer> hashMapA = new HashMap<>();
        HashMap<Integer,Integer> hashMapB = new HashMap<>();

        for (int item : arrA){
            if(hashMapA.containsKey(item))
                hashMapA.put(item,hashMapA.get(item)+1);
            else
                hashMapA.put(item,1);
        }
        for (int item : arrB){
            if(hashMapB.containsKey(item))
                hashMapB.put(item,hashMapA.get(item)+1);
            else
                hashMapB.put(item,1);
        }
        if(hashMapA.keySet().size()!=hashMapB.keySet().size()) return false;
        Set<Integer> keysA = hashMapA.keySet();
        Set<Integer> keysB = hashMapA.keySet();

         for (Integer keyA : keysA) {
                if(hashMapB.containsKey(keyA))
                {
                    //count
                    if(hashMapA.get(keyA) != hashMapB.get(keyA))
                    {
                        return false;
                    }
                }
                else return false;
         }       
          return true;
    }

    // private static boolean equals1(int[] arrA, int[] arrB) {
    //     //if length not equal
    //     if(arrA.length != arrB.length) return false;
        
    //     // put in HashSet so duplicates also removed
    //     HashSet<Integer> hashSetA = new HashSet<>();
    //     HashSet<Integer> hashSetB = new HashSet<>();

    //     for (int item : arrA)
    //         hashSetA.add(item);
    //     for (int item : arrB)
    //         hashSetB.add(item);

    //     //after duplicates removed check size
    //     if(hashSetA.size() != hashSetB.size()) return false;
    //     else
    //     {
    //         for (Integer itemInA : hashSetA) {
    //             //check if contains and remove from B
    //             if(hashSetB.contains(itemInA)) hashSetB.remove(itemInA);
    //             else return false;
    //         }
    //     }
    //     //passed all cases
    //     return true;
    // }

}