class SubarraysKDistinctInt {
    public int subarraysWithKDistinct(int[] A, int K) {
        
        //See comments
        //In this problem we will find the number of different subarrays when we have K different elements in sliding window and for K-1 elements in sliding window. Then we take difference between them to find num of subarrays for exactly K diff elements.
        //Number of subarrays = endPt - startPt ie for array of size N we will have N subarrays.
        
        Window w1 = new Window();
        Window w2 = new Window();
        
        int left1 = 0, left2 = 0;
        
        //The number of subarrays
        int sub = 0;
        
        for(int right = 0; right < A.length; right++){
            
            //We will add elements
            w1.add(A[right]);
            w2.add(A[right]);
            
            //If num of different elements in window is > K then we have to remove them until it becomes = K
            while(w1.differentElements() > K){
                
                w1.remove(A[left1++]);
            }
            
            //If num of different elements in window is > K-1 then we have to remove them until it becomes = K-1
            while(w2.differentElements() >= K){
                
                w2.remove(A[left2++]);
            }
            
/*
i. Number of possible sub-arrays of first window = N (with <= K distinct integers)
ii. Number of possible sub-arrays of second window = M (with < K distinct integers)
Total number of sub-arrays with 'exactly' K distinct integers = N - M,
since N = right - left1
and M = right - left2
N - M = left2 - left1 */
            
            sub += left2 - left1;
            
        }
        
        return sub;
    }
}
    
class Window{
    
    //Keeps count of elements in array
    Map<Integer, Integer> count;
    
    //Number of different elements in window
    int different;
    
    Window(){
        
        count = new HashMap<>();
        different = 0;
    }
    
    public void add(int x){
        
        count.put(x, count.getOrDefault(x, 0) + 1);
        
        //If an element is added for first time then its different
        if(count.get(x) == 1)
            different++;
    }
    
    //To remove the element from window
    public void remove(int x){
        
        //Reduce the count
        count.put(x, count.get(x) - 1);
        
        //If count becomes 0 then the element isnt present in map
        if(count.get(x) == 0)
            different--;
    }
    
    //Gives the number of different elements in the window
    public int differentElements(){
        
        return different;
    }
         
}
