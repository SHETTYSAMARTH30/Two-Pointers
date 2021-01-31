class MeetingScheduler {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        
        //We will sort the time slots in ascending order of start time
        
        Comparator<int[]> comparator = Comparator.comparingInt(a -> a[0]);
        
        Arrays.sort(slots1, comparator);
        Arrays.sort(slots2, comparator);
        
        //We will use same method as merge interval
        
        //we use 2 pointers that point to start of slots1 and slots2
        int p1 = 0;
        
        int p2 = 0;
        
        List<Integer> result = new ArrayList<>();
        
        while(p1 < slots1.length && p2 < slots2.length){
            
            int slot1[] = slots1[p1];
            int slot2[] = slots2[p2];
            
            //We are finding the time when the 2 have same time slot (Intersection)
            int start = Math.max(slot1[0], slot2[0]);
            int end = Math.min(slot1[1], slot2[1]);
            
            //If intersection time >= duration then we can allot that time
            if((end - start) >= duration){
                
                result.add(start);
                result.add(start + duration);
                break;
            }
            
            //If we can't find a slot then we pass the early ending slot among 2. As the late ending slot might still intersect in future
            if(slot1[1] < slot2[1])
                p1++;
            
            else
                p2++;
        }
        
        return result;
    }
}
