class SortedSquares {
    public int[] sortedSquares(int[] nums) {
        
        //We can find the square and then sort but its nlogn
        
        int n = nums.length;
        
        int[] output = new int[n];
        
        int left = 0;
        int right = n - 1;
        
        //The negative numbers are in reverse order and pos num are in increasing order. So at both ends we have greater number in absolute form
        for(int i = n - 1; i >= 0; i--){
            
            int square;
            
            //We will compare which number is greater
            if(Math.abs(nums[right]) > Math.abs(nums[left])){
                
                square = nums[right];
                right--;
            }
            else{
                
                square = nums[left];
                left++;
            }
            
            output[i] = square * square;
            
        }
        
        return output;
    }
}
