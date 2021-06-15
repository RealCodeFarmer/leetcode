package cn.meow.binarySearch.findSmallest;

public class FindSmallest {

    /**
     * 二分查找
     */
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] > target) {
                right = mid - 1;
            } else if (letters[mid] < target) {
                left = mid + 1;
            } else {
                //如果相等,去找后一个    例如: ["e","e","e","e","e","e","n","n","n","n"], target="e"
                while (letters[mid] == letters[(mid + 1) % letters.length]) {
                    mid++;
                }
                right = mid;
                break;
            }
        }
        //如果不在数组的氛围内, 返回数组第一个   例如: ["a","b"], target="z"
        if (left >= letters.length || right < 0) {
            return letters[0];
        }
        //题意: 字母是依序循环出现的
        //类似循环队列的处理
        return letters[(right + 1) % letters.length];
    }
}
