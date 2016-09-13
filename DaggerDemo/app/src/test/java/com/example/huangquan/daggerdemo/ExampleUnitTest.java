package com.example.huangquan.daggerdemo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

   // @Test
    public void testClassMemberInjectParam1() {
        Tweeter tweeter = new Tweeter();

        //1.创建component,并将所需要的module new 进去
        BeanComponent beanComponent = DaggerBeanComponent.builder().beanModule(new BeanModule()).build();

        beanComponent.inject(tweeter);
        tweeter.userPrint();
        tweeter.personPrint();
    }

   // @Test
    public void testClassMemberInjectParam2() {
        Tweeter tweeter = new Tweeter();

        //1.创建component,并将所需要的module new 进去
        BeanComponent beanComponent = DaggerBeanComponent.builder().beanModule(new BeanModule(new Person("hq",24))).build();
        //2.为成员变量需要injcet 的对象注入
        beanComponent.inject(tweeter);

        //
        tweeter.userPrint();
        tweeter.personPrint();
    }

    //@Test
    public void testClassConstructorParam() {
        //1.创建component
        BeanComponent beanComponent = DaggerBeanComponent.builder().beanModule(new BeanModule()).build();

        //2. 创建出构造方法参数需要inject 的类
        Tweeter tweeter = beanComponent.tweeter();

        tweeter.mNetManagerPrint();
    }

    @Test
    public void testClassMethodParam() {
        //1.创建component
        BeanComponent beanComponent = DaggerBeanComponent.builder().beanModule(new BeanModule()).build();

        //2. 创建出成员方法参数需要inject 的类:注意:这一步就会自动调用了被 @Inject 修饰的成员方法
        Tweeter tweeter = beanComponent.tweeter();
        tweeter.methodParamPrint();

    }
}