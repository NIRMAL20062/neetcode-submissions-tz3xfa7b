class Solution {

// {"ram" ,  "raghu" , "hello"}
// 3#ram5#raghu5#hello

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
        int sharp = str.indexOf('#', i);
        int len = Integer.parseInt(str.substring(i, sharp));

        int start = sharp + 1;
        int end = start + len;
        String word = str.substring(start, end);

        ans.add(word);

        i = end;
    }

    return ans;
}

}
