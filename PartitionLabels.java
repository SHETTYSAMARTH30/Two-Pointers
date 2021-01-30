class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        
        //We will put the index of last occurence of every character in array
        int[] last = new int[26];
        
        int n = S.length();
        
        for(int i = 0; i < n; i++){
            
            last[S.charAt(i) - 'a'] = i;
        }
        
        //Now we will use 2 pointer approach.
        
        ArrayList<Integer> result = new ArrayList<>();
        
        //It keeps the end of partition
        int j = 0;
        
        //It is used to keep track of start of partition
        int anchor = 0;
        
        for(int i = 0; i < n; i++){
            
            j = Math.max(j, last[S.charAt(i) - 'a']);
            
            //We have found partition where each letter appears at most 1 part. Hence we stop and store the answer and start the next partition.
            if(i == j){
                
                result.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        
        return result;
        
    }
}
