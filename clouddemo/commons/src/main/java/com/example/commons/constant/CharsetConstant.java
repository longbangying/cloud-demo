package com.example.commons.constant;

import java.nio.charset.Charset;

public class CharsetConstant {

    private CharsetConstant(){

    }

    public static final String CHARSET_NAME = "utf-8";

    public static final Charset  CHARSET = Charset.isSupported(CHARSET_NAME) ? Charset.forName(CHARSET_NAME):Charset.defaultCharset();
}
