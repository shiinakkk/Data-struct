package DataStruct.Algorithm;

import java.util.Arrays;

public class KMP {
    String str;
    int len;
    int[] match;

    public KMP(String str){
        this.str = str;
        this.len = str.length();
        match = new int[str.length()];
        for(int i = 0; i < str.length(); i ++){
            String s = str.substring(0, i + 1);
            int max = 0;
            for(int j = 1; j < s.length(); j ++){
                if(s.substring(0, j).equals(s.substring(s.length() - j))){
                    max = j;
                }
            }
            match[i] = max;
        }
    }

    public int kmpMatch(String s){
        int pointer = 0, matched = 0;
        while(pointer < s.length()){
            if(str.charAt(matched) == s.charAt(pointer)){
                matched ++;
                pointer ++;
            }else{
                if(matched == 0){
                    pointer ++;
                }else{
                    matched = match[matched - 1];
                }
            }
            if(matched == len){
                return pointer - len;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        KMP kmp = new KMP("abcac");
        System.out.println(kmp.kmpMatch("ababcabcacbab"));
    }
}
