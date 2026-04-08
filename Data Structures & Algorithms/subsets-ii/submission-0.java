class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // key: sort first
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    void backtrack(int[] nums, int start,
                   List<Integer> current,
                   List<List<Integer>> result) {

        result.add(new ArrayList<>(current)); // add at every node

        for (int i = start; i < nums.length; i++) {
            // skip duplicate: same value as previous sibling at this level
            if (i > start && nums[i] == nums[i - 1]) continue;

            current.add(nums[i]);
            backtrack(nums, i + 1, current, result);
            current.remove(current.size() - 1); // backtrack
        }
    }
}