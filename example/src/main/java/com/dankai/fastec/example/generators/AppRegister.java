package com.dankai.fastec.example.generators;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.fastec.example.generators
 *  文件名:    WeChatPayEntry
 *  创建者:    WK
 *  时间：     2019/7/18 13:50
 *  描述：     TODO
 */

import com.dankai.latte.annotations.AppRegisterGenerator;
import com.dankai.latte.wechat.templates.AppRegisterTemplate;

@AppRegisterGenerator(
        packageName = "com.dankai.fastec.example",
        registerTemplate = AppRegisterTemplate.class
)
public interface AppRegister {
}
