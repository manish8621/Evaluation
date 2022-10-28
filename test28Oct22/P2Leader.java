import java.util.ArrayList;

public class P2Leader {
    public static void main(String[] args) {
        int[] arr = {16,17,4,3,5,2};

        //scanner 

        System.out.println(printLeaders(arr)); 
    }

    private static ArrayList<Integer> printLeaders(int[] arr) {
        ArrayList<Integer> leaders = new ArrayList<>() ;
        //go from last
        int max = arr[arr.length-1];
        for (int index = arr.length-1; index >= 0; index--) {
            if(arr[index]>=max){
                //keep track of max element from last compare it with current
                max = arr[index];
                leaders.add(0,arr[index]);
            }
        }
        return leaders;
    }
}
