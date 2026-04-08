class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), 0, result);
        return result;
    }

    private void backtrack(int[] nums, int target,
                           int index, List<Integer> current,
                           int currentSum, List<List<Integer>> result) {

        if (currentSum == target) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (currentSum > target || index == nums.length) {
            return;
        }

        current.add(nums[index]);
        backtrack(nums, target, index + 1, current, currentSum + nums[index], result);

        // backtrack
        current.remove(current.size() - 1);

        int nextIndex = index + 1;
        while (nextIndex < nums.length && nums[nextIndex] == nums[index]) {
            nextIndex++;
        }

        backtrack(nums, target, nextIndex, current, currentSum, result);
    }
}