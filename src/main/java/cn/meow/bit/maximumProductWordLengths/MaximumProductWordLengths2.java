package cn.meow.bit.maximumProductWordLengths;

public class MaximumProductWordLengths2 {

    /**
     * 由于字符串只含有小写字符，总共 26 位，因此可以用一个 32 位的整数来存储每个字符是否出现过
     */
    public int maxProduct(String[] words) {
        //单词数
        int n = words.length;
        int[] val = new int[n];
        for (int i = 0; i < n; i++) {
            //遍历每个单词的字符
            for (char c : words[i].toCharArray()) {
                //把单词放在对应'位'上
                val[i] |= 1 << (c - 'a');
            }
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                //两个单词没有公共'位'(公共字母)
                if ((val[i] & val[j]) == 0) {
                    ret = Math.max(ret, words[i].length() * words[j].length());
                }
            }
        }
        return ret;
    }
}
