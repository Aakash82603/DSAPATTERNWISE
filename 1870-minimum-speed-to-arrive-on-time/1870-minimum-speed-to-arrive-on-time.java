class Solution {
    public double solve(int[] dist, double hour,int mid){
    double result=0;
    for(int i=0; i<dist.length-1; i++){
        result+=Math.ceil((double)dist[i]/mid);

    }
    result+=(double)dist[dist.length-1]/mid;
    return result;
}
    public int minSpeedOnTime(int[] dist, double hour) {
        int left=1;
        int right=10000000;
        if(solve(dist,hour,10000000)>hour){
            return -1;
        }
        while(left<=right){
            int mid=left+(right-left)/2;
            double ans=solve(dist,hour,mid);
            if(ans<=hour){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;

    }
}
