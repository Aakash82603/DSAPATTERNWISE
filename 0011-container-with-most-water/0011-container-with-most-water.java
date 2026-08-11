class Solution {
    public int maxArea(int[] height) {
        int maxarea=0;
        int l=0, r=height.length-1;
        while(l<r){
            int h=Math.min(height[l],height[r]);
            int width=r-l;
            int area=h*width;
           
            maxarea=Math.max(area,maxarea);
            if(height[l]<=height[r]){
                l++;
            }else{
                r--;
            }

        }
        return maxarea;
        
    }
}