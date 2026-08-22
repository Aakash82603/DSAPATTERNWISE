class Solution {
    public boolean checkDivisibility(int n) {
        int org=n;
        int plus=0;
        int product=1;
        int totalsum=0;
        while(n>0){
               int digit=n%10;
                plus+=digit;
                product*=digit;
                
                  n=n/10;

        }
        totalsum+=plus+product;
        
        return org%totalsum==0;     
    }
}