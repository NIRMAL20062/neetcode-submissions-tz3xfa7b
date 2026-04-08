class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, target, 0, new ArrayList<>(), 0, result);
        return result;
    }

    public void backtrack(int[] nums, int target, int index,
                          List<Integer> current, int currentSum,
                          List<List<Integer>> result) {

        if (currentSum == target) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (currentSum > target || index == nums.length) {
            return;
        }

        // pick ,stay on same index → reuse allowed
        current.add(nums[index]);
        backtrack(nums, target, index, current, currentSum + nums[index], result);

        // backtrack
        current.remove(current.size() - 1);

        //NOT PICK , move forward
        backtrack(nums, target, index + 1, current, currentSum, result);
    }
}