class SparseVector {
    
    //It will store the index of non zero values in array
    Map<Integer, Integer> mapping;
    
    SparseVector(int[] nums) {
        
        mapping = new HashMap<>();
        
        //We store all the non zero values in map. Key = index, value = non zero element
        for(int i = 0; i < nums.length; i++){
            
            if(nums[i] != 0){
                
                mapping.put(i, nums[i]);
            }
        }
        
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        
        //Store the dot product of non zero values
        int result = 0;
        
        //We will iterate through all the index in key set. If the index is also present in the mappings of vec then we cross product their values
        for(int i : this.mapping.keySet()){
            
            //If the map of vector also contains a non zero element at the index i
            //Then we can cross product else it will be 0
            if(vec.mapping.containsKey(i)){
                
                result += this.mapping.get(i) * vec.mapping.get(i);
            }
        }
        
        return result;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
