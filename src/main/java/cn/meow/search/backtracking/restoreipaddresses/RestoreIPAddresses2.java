package cn.meow.search.backtracking.restoreipaddresses;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses2 {

    public List<String> restoreIpAddresses(String s) {
        List<String> addresses = new ArrayList<>();
        StringBuilder tempAddress = new StringBuilder();
        doRestore(0, tempAddress, addresses, s);
        return addresses;
    }

    /**
     * @param k           分了几次
     * @param tempAddress 用于拼接字符串
     * @param addresses   结果集
     * @param s           剩余字符串
     */
    private void doRestore(int k, StringBuilder tempAddress, List<String> addresses, String s) {
        //已经分了四次或者已经没法再分了
        if (k == 4 || s.length() == 0) {
            //已经分了四次并且已经分完
            if (k == 4 && s.length() == 0) {
                addresses.add(tempAddress.toString());
            }
            return;
        }
        //i <= 2 的作用: 第四位必然越界
        for (int i = 0; i < s.length() && i <= 2; i++) {
            //每个段的第一个字符不能为0
            if (i != 0 && s.charAt(0) == '0') {
                break;
            }
            //截断 [0,i+1) => [0,i]
            String part = s.substring(0, i + 1);
            //截取得部分是否在合法范围内
            if (Integer.valueOf(part) <= 255) {
                //不是第一个段,在前面拼上"."
                if (tempAddress.length() != 0) {
                    part = "." + part;
                }
                //字符串拼接
                tempAddress.append(part);
                doRestore(k + 1, tempAddress, addresses, s.substring(i + 1));
                tempAddress.delete(tempAddress.length() - part.length(), tempAddress.length());
            }
        }
    }
}