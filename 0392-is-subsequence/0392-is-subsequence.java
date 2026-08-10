class Solution {
    public boolean isSubsequence(String s, String t) {
        int left=0;
        int right=0;
        while(left<s.length() && right<t.length()){
            int l=s.charAt(left);
            int r=t.charAt(right);
            if(l==r){
                left++;
                right++;
            }else{
                right++;
            }
        }
        return left == s.length();//if (left == s.length()) {
                                //     return true;
// } else {
//     return false;// simply agar hmara left ka size equal hona chahiye length se 
// }//left == s.length() → all characters matched → true
      //left != s.length() → not all matched → false
        
        
    }
}