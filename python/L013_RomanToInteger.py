"""
Given a roman numeral, convert it to an integer.
Input is guaranteed to be within the range from 1 to 3999.

Symbol       I       V       X       L       C       D       M
Value        1       5       10      50      100     500     1,000
"""

class L013_RomanToInteger:
    def romanToInt(self, s: str) -> int:
        rdict = { 'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500,  'M': 1000 }
        result = rdict[s[-1]]
        for i in reversed(range(len(s) - 1)):
            if rdict[s[i]] < rdict[s[i + 1]]:
                result -= rdict[s[i]]
            else:
                result += rdict[s[i]]
        return result


def main():
    obj = L013_RomanToInteger()
    rstrings = ["III", "IV", "IX", "LVIII", "MCMXCIV"]
    for rstring in rstrings:
        print("{:8} : {:>5}".format(rstring, obj.romanToInt(rstring)))

if __name__ == "__main__":
    main()


