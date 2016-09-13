package com.example.huangquan.daggerdemo;

import dagger.Module;
import dagger.Provides;

/**
 * Created by huangquan on 16/9/13.
 *
 * 相当于工厂,生成各种对象,传值可以通过构造方法,方法内部变量,方法参数
 */
@Module
public class BeanModule {

    private  Person person;

    public BeanModule(Person person) {
        this.person = person;
    }

    public BeanModule() {

    }

    @Provides
    public User provideUser() {
        return new User("defaultUser", 10);
    }


/*
    错误:一个Module 里不可以出现返回参数重复的方法,如下面的也是返回"Person" 则程序无法知道要调用那个方法
    @Provides
    public Person providePerson(String name, int age) {

        return new Person(name, age);
    }*/

    @Provides
    public Person providePersonByDefault() {

        //注意:由于module 构造方法有两个,所以person 变量有可能为null
        if (null == person) {
            return new Person("defaultPerson", 111);
        }
        return new Person(person.name, person.age);
    }


    @Provides
    public NetManager provideNetManager() {
        return new NetManager("I am NetManager");
    }

    //类的方法参数需要inject
    @Provides
    public MethodParam provideMethodParam() {
        return new MethodParam("I am a MethodParam !");
    }
}
