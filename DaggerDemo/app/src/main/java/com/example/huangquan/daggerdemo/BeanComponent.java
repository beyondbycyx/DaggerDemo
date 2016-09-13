package com.example.huangquan.daggerdemo;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by huangquan on 16/9/13.
 */
@Singleton
@Component(modules = {BeanModule.class})
 interface BeanComponent {

     /*
    错误写法: inject 时 只能返回void 或 injected 类型即Tweeter
    String inject(Tweeter tweeter);
    */

    //类的字段需要inject 时
    Tweeter inject(Tweeter tweeter);

    /*
    错误写法: 返回一个对象时,则方法参数不可以有
    User user(String name,int age);
    */

    //构造方法的参数需要inject 时
    Tweeter tweeter();




}
