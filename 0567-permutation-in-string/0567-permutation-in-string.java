class Solution {
    public boolean checkInclusion(String s1, String s2) {
       int []freq1=new int [26];
        int []freq2=new int [26];
       for(char ch:s1.toCharArray()){
        freq1[ch-'a']++;
       }
       for(int i=0; i<s2.length(); i++){
        freq2[s2.charAt(i)-'a']++;
        if(i>=s1.length()){
         freq2[s2.charAt(i -s1.length())-'a']--;
        }
        if(Arrays.equals(freq1,freq2)){
            return true;
        }
       }
       return false;
        
    }
}