package TwoSum;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) {
            return null;
        }

        for (int j = 0; j < nums.length - 1; j++) {
            int base = nums[j];
            for (int i = j + 1; i < nums.length; i++) {
                int curr = nums[i];
                if (curr + base == target) {
                    int[] toRet = {j, i};
                    return toRet;
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int nums[] = {2, 5, 5, 11};
        int target = 10;
        int[] result = sol.twoSum(nums, target);
        if (result != null) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No two sum solution found."); 
        }
    }
}