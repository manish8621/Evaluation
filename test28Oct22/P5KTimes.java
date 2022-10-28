import java.util.HashMap;

public class P5KTimes {
    public static void main(String[] args) {
        int arr[] = {1,2,2,3,4,4,2,4}; 
        int k = 3;
        try {
            int resultIndex = ElementWithKTimes(arr,k);
            if(resultIndex==-1)
            {
                System.out.println("not found");
            }
            else
                System.out.println(arr[resultIndex]);
        }
        catch (Exception e) { System.out.println(e.getMessage()); }
    }

    /**
     * returns index of first element with k times occurances
     */
    private static int ElementWithKTimes(int[] arr, int k) throws Exception {
        
        if(arr.length==0) throw new Exception("Empty array");
        if(k==0) throw new Exception("k should be > 0");
        
        //if k is 1 first element is result
        if(k==1) return 0;
        
        //map each num to occurences
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for (int index =0;index<arr.length;index++) {
            if(hashMap.containsKey(arr[index])){
                int occurences = hashMap.get(arr[index])+1;
                
                //if k times occurs
                if(occurences == k) {
                    return index;
                }

                hashMap.put(arr[index], occurences);
            }
            else hashMap.put(arr[index], 1);
        }
        
        //if not returned till now means condition not met
        return -1;
    }

}
