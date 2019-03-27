"""
Determine whether an integer is a palindrome. Do this without extra space.

Example:
    Input:  121
    Output: True

    Input:  -121
    Output: False

    Input:  10
    Output: False

Follow up:
    Could you solve it without converting the integer to a string?

"""

from collections import deque

class L009_PalindromeNumber:
    def isPalindrome(self, x: int) -> bool:
        d = deque(str(x))
        while len(d) > 1:
            if d.pop() != d.popleft():
                return False
        return True
    
    def isPalindrome2(self, x: int) -> bool:
        if x < 0:
            return False
        if x < 10:
            return True
        
        y = 10
        while y <= x:
            y *= 10
        y /= 10

        while x > 0:
            left = x // y
            right = x % 10
            if left != right:
                return False
            x -= x // y * y
            x //= 10
            y /= 100
        return True

def main():
    obj = L009_PalindromeNumber()
    nums = [121, -121, 10, 10001, 1002001, 10022001, 1000021]
    for num in nums:
        print("{:>10} {} {}\n".format(num, obj.isPalindrome(num), obj.isPalindrome2(num)))

if __name__ == "__main__":
    main()

