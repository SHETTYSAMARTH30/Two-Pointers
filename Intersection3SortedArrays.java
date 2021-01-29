class Intersection3SortedArrays {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        
        //We can maker use of HashMap and put all the element along with their frequency to map. If frequency of any element == 3 then that's present in all 3 arrays
        
        //2 pointer approach can be used to make use of sorting
        
        //Pointers pointing to start of arr1, arr2, arr3
        int p1 = 0, p2 = 0, p3 = 0;
        
        ArrayList<Integer> result = new ArrayList<>();
        
        while(p1 < arr1.length && p2 < arr2.length && p3 < arr3.length){
            
            //If all the 3 elements are same then we add the element to result and increment pointers
            if(arr1[p1] == arr2[p2] && arr2[p2] == arr3[p3]){
                
                result.add(arr1[p1]);
                
                p1++;
                p2++;
                p3++;
            }
            else{
                
                //We will move the pointer of lower element so that all the pointer stop at same element
                if(arr1[p1] < arr2[p2])
                    p1++;
                
                else if(arr2[p2] < arr3[p3])
                    p2++;
                
                //In this case:- arr1[p1] >= arr2[p2] > arr3[p3]
                else
                    p3++;
            }
            
        }
        
        return result;
        
    }
}
