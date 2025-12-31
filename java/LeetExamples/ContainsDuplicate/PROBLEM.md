Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Solution: Convert the Array of nums into a set. Because an inherent property of sets is that duplicates are not allowed, if the size of the resulting set is less than the length of the initial array, then there were duplicates present.