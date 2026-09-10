class Solution {
    public int solve(int[] position, int m,int mid){
        int ballcnt=1;
        int lastbasket=position[0];
        for(int i=0; i<position.length; i++){
            if(position[i]-lastbasket>=mid){
                ballcnt++;
                lastbasket=position[i];
            }
        }
        return ballcnt;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low=1;
        int high=position[position.length-1]-position[0];
        while(low<=high){
            int mid=low+(high-low)/2;
            if(solve(position,m,mid)>=m){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return high;
    
        
    }
}