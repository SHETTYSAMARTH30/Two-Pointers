class TwoSumLessThanK {
    public int twoSumLessThanK(int[] nums, int k) {
        
        //We will sort the array. Then we will add the first and last element, if its greater than or equal to k then decrease right. If its less than k increase left
        Arrays.sort(nums);
        
        int answer = -1;
        
        int left = 0;
        int right = nums.length - 1;
        
        while(left < right){
            
            int sum = nums[left] + nums[right];
            
            //Then this might be solution hence we save it
            if(sum < k){
                
                answer = Math.max(answer, sum);
                
                //We will increment left and see if we can find max sum > answer
                left++;
            }
            else{
                
                //We want the sum to be less than k
                right--;
            }
        }
        
        return answer;
        
    }
}
