class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            int[] freq = new int[26];

            // count characters
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }

            // build key from frequency array
            StringBuilder key = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                key.append('#');     // separator avoids ambiguity
                key.append(freq[i]);
            }

            String k = key.toString();

            // group words
            map.computeIfAbsent(k, x -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(map.values());
    }
}
