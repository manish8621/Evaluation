fun main()
{
    val arr = arrayOf(15,-2,2,-8,1,7,10,23);
    println(subArrayWithSum0(arr,0)) 
}
fun subArrayWithSum0(arr:Array<Int>,k:Int):ArrayList<Int>
{
    val result = arrayListOf<Int>()
    //from max to min size
    for (size in arr.size-1 downTo 0) {
        
        var pos = 0
        var sum = 0
        
        //clear previous iteration's results 
        if(result.isNotEmpty()) result.clear()

        //initially sum the first part 
        for (index in pos .. pos+size){
            sum += arr[index]
            //keep track of elements added to sum
            result.add(arr[index])
        }
        if(sum == k) return result

        //if sum is not k then try moving to next subarray 
        pos++
        //to next part if available
        while(pos+size<arr.size)
        {
            //subtract the prevoius pos element 
            sum -= arr[pos-1]
            //remove the head element
            result.removeAt(0)

            //add the element that would exist in the end of current subarray
            sum += arr[pos+size] 
            //add the new at last
            result.add(arr[pos+size])

            //check
            if(sum == k) return result
            pos++
        }
    }
    return arrayListOf<Int>()
}