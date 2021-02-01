class 3SumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        
        //We will sort the array first
        Arrays.sort(nums);
        
        //Stores the result of number of three sum in array
        int sum = 0;
        
        for(int i = 0; i < nums.length - 2; i++){
            
            //We will 2 sum from next index to end with target = target - nums[i]
            sum += twoSumSmaller(nums, i + 1, target - nums[i]);
        }
        
        return sum;
        
    }
    
    //Find 2 sum from start to end
    public int twoSumSmaller(int[] nums, int startIndex, int target){
        
        int sum = 0;
        
        int left = startIndex;
        int right = nums.length - 1;
        
        while(left < right){
            
            //Then we found the ans, if (left, right)==target then all the elements less than right + left will also be < target. So we save right - left in sum
            if(nums[left] + nums[right] < target){
                
                //no of pairs that fulfill 
                sum += right - left;
                left++;
            }
            else{
                
                right--;
            }
            
        }
        
        //No of 2 sums that's < target
        return sum;
        
    }
}
