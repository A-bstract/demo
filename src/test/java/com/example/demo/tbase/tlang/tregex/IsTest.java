package com.example.demo.tbase.tlang.tregex;

import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description: test
 * @author: chuan
 * @create: 2019-09-19 15:41
 **/
@Slf4j
public class IsTest {

    public static void main(String args[]){
        String regex = "";
        String src = "";

        //匹配小数
        /*regex = "(-?[0]|-?[1-9]{1,10})(\\.)([0-9]{1,10})";
        src = "-8.1415926";*/

        //匹配日期
        /*regex = "(\\d{4})([-])(\\d{2})([-])(\\d{2})";
        src = "2019-01-01";*/

        //匹配密码  8 - 20位 开头必须包含大写字母 必须包含数字 & 英文字母
        /*regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}";
        src = "eeeeeeee55555e5e";*/



        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(src);
        boolean matches = matcher.matches();
        log.debug("matcher：" + matches);
    }
}
