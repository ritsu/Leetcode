"""
Reverse digits of an integer.
 
Example1: x = 123, return 321
Example2: x = -123, return -321
Example3: x = 120, return 21

Note:
The input is assumed to be a 32-bit signed integer.
Your function should return 0 when the reversed integer overflows.
"""

class L007_ReverseInteger:
    def reverse(self, x: int) -> int:
        r = 0
        sign = 1 if x > 0 else -1 
        x *= sign
        while x > 0:
            r *= 10
            r += x % 10
            x //= 10
        # integer operations in python 3 do not overflow
        if (r > 2147483647 or r < -2147483648):
            return 0
        return r * sign

def main():
    nums = [123, -123, 120, 2147483647]
    obj = L007_ReverseInteger()
    for num in nums:
        print(obj.reverse(num))

if __name__ == "__main__":
    main()

            
