package cn.meow.binarysearch.findsmallest;

public class FindSmallest2 {

    /**
     * 记录存在的字母
     */
    public char nextGreatestLetter(char[] letters, char target) {
        boolean[] seen = new boolean[26];
        for (char c : letters)
            seen[c - 'a'] = true;

        //让target去找大于它并最小的数
        while (true) {
            target++;
            if (target > 'z') target = 'a';
            if (seen[target - 'a']) return target;
        }
    }

    /**
     * 线性扫描
     */
    public char nextGreatestLetter2(char[] letters, char target) {
        for (char c : letters) {
            if (c > target) {
                return c;
            }
        }
        return letters[0];
    }

    /**
     * 二分查找
     */
    public char nextGreatestLetter3(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return letters[left % letters.length];
    }
}
