from typing import List

"""
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
    Given nums = [2, 7, 11, 15], target = 9,

    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].
"""

class L001_TwoSum:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        num_dict = {}
        for i, num in enumerate(nums):
            if (target - num) in num_dict:
                return [num_dict[target - num], i]
            num_dict[num] = i
        return null

def main():
    nums = [2, 7, 11, 15]
    target = 9
    obj = L001_TwoSum()
    print(obj.twoSum(nums, target))

if __name__ == "__main__":
    main()

