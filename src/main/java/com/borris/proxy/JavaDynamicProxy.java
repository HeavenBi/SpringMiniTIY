package com.borris.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JavaDynamicProxy implements InvocationHandler {
    private Object targetBean;
    private AspectInvoker aspectObj;

    public JavaDynamicProxy(Object targetBean, AspectInvoker aspectObj) {
        this.targetBean = targetBean;
        this.aspectObj = aspectObj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        if(aspectObj!=null) {
            result = aspectObj.invoke(targetBean, method, args);
        }else{
            result = method.invoke(targetBean,args);
        }
        return result;
    }
}
