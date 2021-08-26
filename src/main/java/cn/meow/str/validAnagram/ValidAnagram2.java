package cn.meow.str.validAnagram;

public class ValidAnagram2 {

    public boolean isAnagram(String s, String t) {
        int[] cnts = new int[26];
        //生产
        for (char c : s.toCharArray()) {
            cnts[c - 'a']++;
        }
        //消费
        for (char c : t.toCharArray()) {
            cnts[c - 'a']--;
        }
        for (int cnt : cnts) {
            //如果还有存量或者多消耗就不是异位词
            if (cnt != 0) {
                return false;
            }
        }
        return true;
    }
}
