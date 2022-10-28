


fun main() {
    val inputText = "abca"
    println(getSubstringAnagrams(inputText)/2)
}

fun getSubstringAnagrams(inputText:String):Int{
    var count = 0
    //try all sizes of sub arrays 
    for(size in 1 .. inputText.length)
    {
        val subStrings = getSubStrings(inputText.toCharArray(),size)
        //select the sub string to compare with rest of all
        for ((index1,toCheck) in subStrings.withIndex()) {
            //rest of all
            for ((index2,checkWith) in subStrings.withIndex()) {
                //dont compare same items
                if(index1 != index2 )
                    if(areAnagrams(toCheck, checkWith)) count++ 
            }
        }
    }

    return count
}
fun areAnagrams(a:Array<Char>,_b:Array<Char>):Boolean  =equals(a, _b) 

fun equals(arrA:Array<Char>,arrB:Array<Char>):Boolean {
    //if length not equal
    if(arrA.size != arrB.size) return false;
    
    val hashMapA = hashMapOf<Char,Int>();
    val hashMapB = hashMapOf<Char,Int>();


    for (item in arrA){
        if(hashMapA.containsKey(item))
            hashMapA.put(item,(hashMapA.get(item)?:0)+1);
        else
            hashMapA.put(item,1);
    }
    for (item in arrB){
        if(hashMapB.containsKey(item))
            hashMapB.put(item,(hashMapB.get(item)?:0)+1);
        else
            hashMapB.put(item,1);
    }

    if(hashMapA.keys.size!=hashMapB.keys.size) return false;
    
    val keysA = hashMapA.keys

     for (keyA in keysA) {
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

fun getSubStrings(inputText:CharArray,_size:Int):ArrayList<Array<Char>>{
    val result = arrayListOf<Array<Char>>()
    val temp = arrayListOf<Char>() 
    val size = _size-1
    var pos = 0
    //add till THE last according to size
    for (index in 0 .. size )
        temp.add((inputText[index]))
    //add to arrlist
    
    result.add(temp.toTypedArray())
    pos++

    while(pos+size<inputText.size)
    {
        //remove head
        temp.removeFirst()
        
        //ADD NEW tail
        temp.add(inputText[pos+size])
        
        //add tyhe new to result 
        result.add(temp.toTypedArray())

        //MOVE TO NEXT SUBARR
        pos++
    }
    return result
}