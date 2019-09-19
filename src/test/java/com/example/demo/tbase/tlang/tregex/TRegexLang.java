package com.example.demo.tbase.tlang.tregex;

import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * @author: chuan
 * @create: 2019-09-18 16:50
 **/
@Slf4j
public class TRegexLang {
    public static void main(String args[]){
        String regex = "\\d[a-z]*";
        String src = "1888888@qq.com";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(src);

        /**
         * 开始匹配的
         * 如没有匹配上会抛出异常
         */
        /*matcher.find();
        int start = matcher.start();
        int end = matcher.end();
        log.debug("匹配开始位置：" + start);
        log.debug("匹配结束位置：" + end);*/

        /**
         *  matcher完全匹配 lookingAt必须从第一个开始匹配
         */
        /*boolean b = matcher.lookingAt();
        log.debug("lookingAt：" + b);*/

        /**
         * replaceAll会把所有匹配该模式的位置都给替换
         */
        /*String r = matcher.replaceAll("啦啦啦");
        log.debug("替换之后：" + r);*/

        /**
         * appendReplacement(StringBuffer sb, String replacement)方法执行渐进式的替换，把替换完的内容添加到sb中，
         * 当遍历执行所有的替换操作完成后，我们可以调用 public StringBuffer appendTail(StringBuffer sb) 方法，把最后剩余的部分添加到sb。
         */
        /*Pattern pattern = Pattern.compile("a|b");
        Matcher m = pattern.matcher("abcabca@126.com");
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, m.group().toUpperCase());
            System.out.println(sb.toString());
        }
        m.appendTail(sb);
        System.out.println(sb.toString());*/
    }
}
