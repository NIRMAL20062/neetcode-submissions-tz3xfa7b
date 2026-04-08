class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //1. count freq of s1
        // 2. for each substring of s2 of len of s1 if freq of that sub string matches then true else false;

        int n = s1.length();
        int m = s2.length();

        if(n>m) return false;


        int[] freq1 =new int[26];

        for (int i=0;i<n;i++){
            freq1[s1.charAt(i)-'a']++;
        }

        for(int i = 0 ; i<=m-n  ; i++){

            int [] freq2 = new int[26];
            for(int j=i;j<i+n;j++){
                freq2[s2.charAt(j) - 'a']++;
            }

            boolean some = true;
            for(int k=0; k<26;k++){
                if(freq1[k]!=freq2[k]){
                    some=false;
                    break;
                }
            
            }
            if (some) return true;
        }

        return false;
    }
}