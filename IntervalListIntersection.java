class IntervalListIntersection {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        //It will store the intersect intervals
        ArrayList<int[]> output = new ArrayList<>();
        
        //They will point to the intervals of both array
        int i = 0;
        int j = 0;
        
        while(i < firstList.length && j < secondList.length){
            
            int low = Math.max(firstList[i][0], secondList[j][0]);
            
            int high = Math.min(firstList[i][1], secondList[j][1]);
            
            //If low is greater than high then its not intersecting
            if(low <= high){
                
                output.add(new int[]{low, high});
            }
            
             // Remove the interval with the smallest endpoint
            if(firstList[i][1] < secondList[j][1])
                i++;
            
            else
                j++;
        }
        
        //Convert the list to 2D array
        return output.toArray(new int[output.size()][]);
    }
}
