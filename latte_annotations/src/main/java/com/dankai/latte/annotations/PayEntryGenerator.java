package com.dankai.latte.annotations;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.annotations
 *  文件名:    PayEntryGenerator
 *  创建者:    WK
 *  时间：     2019/7/17 14:14
 *  描述：     TODO
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface PayEntryGenerator {
    String packageName();

    Class<?> payEntryTemplate();
}
