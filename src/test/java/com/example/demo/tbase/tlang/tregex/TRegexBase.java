package com.example.demo.tbase.tlang.tregex;

import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  Java正则基础
 */
@Slf4j
public class TRegexBase {

    public static void main(String args[]){

        String regex = null;
        String src = null;

        /**
         *  Java用 两个'\\'代表一个'\'  而正则表达式要用四个 '\\\\'匹配一个'\'
         */
        /*regex = "\\\\";
        src = "\\";
        log.debug("\\");*/

        /**
         * [] 代表字符集合 每一个集合对应原字符串的一个字符 依次按顺序匹配
         * []会将里面的表达式失效，例如'+'、'.'、'|'（\\）除外
         */
        regex = "[appt][ddjkhflfjhjt][kkkt]";
        src = "pdt";

        /**
         *  '^' 代表除了。。之外  a-d表示 a、b、c、d 左右都闭
         */
        /*regex = "[^a-d]";
        src = "a";*/

        /**
         * '.'匹配任意一个字符 匹配'.'就要用 '//.'
         */
        /*regex = "a.";
        src = "ad";*/

        /**
         * 'X*' 代表x出现0次或多次 ;'x+'（>1）;'x?' (<=1)
         *  X{n}     X，恰好 n 次
         *  X{n,}     X，至少 n 次
         *  X{n,m}     X，至少 n 次，但是不超过 m 次
         */
        /*//regex = "a.*";
        //src = "adddpp";
        //regex = "[\\d][d\\+]\\.\\d+";//'+'在中括号里没有意义 只代表+
        //src = "0+.259";
        regex = "\\d+[@][q]{2}\\.com";
        src = "188888888@qq.com";*/

        /**
         * '()'代表一个子表达式，也是分割组
         * '|'代表或者
         * '\\num'表示匹配哪个组 起手两组  一组分不清是不是组 ；一个组多个匹配后加'+'
         */
        //regex = "([0]|[1-9]+)(\\.)([0-9]+)";//匹配正小数
        //src = "0.01";
        //regex = "(a)\\1+";
        //src = "aaa";
        //regex = "(.)\\1+(.)\\2+";
        //src = "AABB";
        //regex = "(..)\\1+";
        //src = "ABABABABABAB";

        /**
         * '?!'限制后面表达式的格式 不完全匹配
         */
        regex = "windows(?![0-9]+$)[\\w]+";
        src = "windowsddddd";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(src);
        boolean matches = matcher.matches();
        log.debug("matches：" + matches);
        matcher.reset();
        int num = 0;
        try {
            while (matcher.find()){
                log.debug("组" + num + "：" + matcher.group(num));
                num++;
                matcher.reset();
            }
        } catch (Exception e) {

        }
    }
}
