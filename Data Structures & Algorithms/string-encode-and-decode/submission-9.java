class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s:strs){
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int idx = str.indexOf('#', i);
            int len = Integer.parseInt(str.substring(i, idx));

            int start=idx+1;
            int end = idx+1+len;

            ans.add(str.substring(start , end));

            
            i =end;
        }
        return ans;
    }
}
