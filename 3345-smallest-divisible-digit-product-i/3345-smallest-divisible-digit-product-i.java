class Solution {
    public int smallestNumber(int n, int t) {
     
        while(true){
            if(digitproduct(n)%t==0){
                return n;
              
            }
              n++;
        }
        
    
        
    }
    int digitproduct(int x){
           int mul=1;
        while(x>0){
            mul*=(x%10);
             x/=10;
        }
        return mul;
    }
}