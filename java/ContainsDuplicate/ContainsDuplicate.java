package ContainsDuplicate;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        if (numSet.size() != nums.length) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,1};
        System.out.println(solution.containsDuplicate(nums)); // Output: true
    }
}