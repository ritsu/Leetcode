"""
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

	1. Open brackets must be closed by the same type of brackets.
	2. Open brackets must be closed in the correct order.

Note that an empty string is also considered valid.

Example 1:
	Input: "()"
	Output: true

Example 2:
	Input: "()[]{}"
	Output: true

Example 3:
	Input: "(]"
	Output: false

Example 4:
	Input: "([)]"
	Output: false

Example 5:
	Input: "{[]}"
	Output: true
"""


class L020_ValidParentheses:
    def isValid(self, s: str) -> bool:
        # Empty string is considered valid
        if not s:
            return True

        # Valid parentheses pairs
        parens = {'(':')', '[':']', '{':'}'}

        stack = []
        for c in s:
            if c in parens.keys():
                stack.append(c)
            elif len(stack) == 0:
                return False
            elif c != parens[stack.pop()]:
                return False

        return len(stack) == 0


def main():
    obj = L020_ValidParentheses()

    strings = ["()", "()[]{}", "(]", "([)]", "{[]}"]
    for string in strings:
        print(f"{string:>8} {obj.isValid(string)}")


if __name__ == "__main__":
    main()
