class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, target, 0, new ArrayList<>(), 0, result);
        return result;
        
    }
    public static void backtrack(int[] nums, int target, int index,
                          List<Integer> current, int currentSum,
                          List<List<Integer>> result){

    if (currentSum == target) {
            result.add(new ArrayList<>(current));
            return;
    }

    if (currentSum > target)
        return;

    for (int i =index ;i<nums.length;i++){
        current.add(nums[i]);             // ← can reuse, so pass i (not i+1)
        backtrack(nums, target, i, current, currentSum + nums[i], result);
        current.remove(current.size() - 1);            //← backtrack
        
        }
    }
}
