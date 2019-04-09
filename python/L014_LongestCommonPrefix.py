"""
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Note: All given inputs are in lowercase letters a-z.
"""

from typing import List
import random
import string
import time


class L014_LongestCommonPrefix:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if not strs:
            return ""
        plen = len(strs[0])
        for s in strs:
            plen = min(plen, len(s))
            p = 0
            while p < plen and s[p] == strs[0][p]:
                p += 1
            plen = p
        return strs[0][:plen]

    def longestCommonPrefixSet(self, strs: List[str]) -> str:
        if not strs:
            return ""
        if len(set(strs)) == 1:
            return strs[0]
        pmax = min([len(s) for s in strs])
        plen = 0
        while plen <= pmax:
            if len(set([s[:plen] for s in strs])) == 1:
                plen += 1
            else:
                break
        return strs[0][:plen-1]

    def longestCommonPrefixSort(self, strs: List[str]) -> str:
        if not strs:
            return ""
        strs_sorted = sorted(strs)
        if len(strs_sorted) <= 1:
            return strs_sorted[0]
        pos = 0
        maxpos = min(len(strs_sorted[0]), len(strs_sorted[-1]))
        while pos < maxpos and strs_sorted[0][pos] == strs_sorted[-1][pos]:
            pos += 1
        return strs_sorted[0][:pos]

    def randomStrs(self, list_size: int, word_size: int) -> List[str]:
        strs = []
        strs.append(''.join(random.choice(string.ascii_lowercase) for i in range(word_size)))
        list_size -= 1
        while list_size > 0:
            p = random.randint(word_size/2, word_size)
            strs.append(strs[-1][:p] + ''.join(random.choice(string.ascii_lowercase) for i in range(word_size - p)))
            list_size -= 1
        return strs


def main():
    obj = L014_LongestCommonPrefix()

    strs_list = []
    strs_list.append(["flower","flow","flight"])
    strs_list.append(["dog","racecar","car"])
    strs_list.append(["asdf"])
    strs_list.append([""])

    for strs in strs_list:
        print("     {:>10} : {}".format(obj.longestCommonPrefix(strs), ", ".join(strs)))
        print("sort {:>10} : {}".format(obj.longestCommonPrefixSort(strs), ", ".join(strs)))
        print("set  {:>10} : {}".format(obj.longestCommonPrefixSet(strs), ", ".join(strs)))

    # Compare running times
    n = 64
    w = 8
    while n < 2000000:
        strs = obj.randomStrs(n, w)
        t0 = time.time()
        p1 = obj.longestCommonPrefix(strs)
        t1 = time.time()
        p2 = obj.longestCommonPrefixSort(strs)
        t2 = time.time()
        p3 = obj.longestCommonPrefixSet(strs)
        t3 = time.time()
        print("n = {:8}, t1 = {:7.4f}, t2 = {:7.4f}, t3 = {:7.4f}, p1 = {}, p2 = {}, p3 = {}".format(n, t1 - t0, t2 - t1, t3 - t2, p1, p2, p3))
        n *= 2


if __name__ == "__main__":
    main()
