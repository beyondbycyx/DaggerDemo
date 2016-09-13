package com.example.huangquan.daggerdemo;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by huangquan on 16/9/13.
 */
public class Tweeter {

    private static final String TAG = "Tweeter";
    private  NetManager mNetManager;

    //注意:这些inject 的成员变量必须保证都能通过 component 用module 传入进来,即下面这些成员变量最终不能为null
    @Inject User user;
    @Inject  Person person;

    //由@Inject 修饰的成员方法 传值进来
    private MethodParam mParam;


    public Tweeter() {

    }

    @Inject
    public Tweeter(NetManager manager) {
        this.mNetManager = manager;
    }

    @Inject
    public void setMethodParam(MethodParam param) {
        //注意@Inject 修饰的方法(成员方法和构造方法),在被component new 出该类的对象是,这些被@Inject 修饰的方法都会被调用的
        System.out.println("MethodParam.strParam = " + param.strParam);
        this.mParam = param;
    }

    public void methodParamPrint() {
        System.out.println("methodParamPrint: methodParam.strParam =" + mParam.strParam);
    }

    public void userPrint() {

        System.out.println("userPrint():user.name = " + user.name + ",user.age = " + user.age);
    }

    public void personPrint() {
         System.out.println("personPrint():user.name = " + person.name + ",user.age = " + person.age);

    }

    public void mNetManagerPrint() {
        System.out.println("NetManager-msg :"+this.mNetManager.msg);
    }

}
