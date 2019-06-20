package com.hmq.study.chapter1;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 第一章-1
 * 静态工厂方法代替构造器
 *
 * Created by  Hmq
 * @date on 2019/2/20.
 */
public class Constructor {


    /**
     * 静态工程方法代替构造器
     * @author Hmq
     * @date 2019/2/20 20:36
     */
    public void staticFactoryConstruct(){
        Boolean bool = Boolean.valueOf(1 > 0);

        Collections.emptyList();

//        EnumSet.of();

    }


    public static void main(String[] args) {
        Services.registerProvider(new LoginProvider(),"login");
        Service login = Services.newInstance("login");
        login.login();
    }




}

/**
 * 1-1 服务提供者框架中重要的三个组成组件
 * 1.Service Interface (服务接口) 这是提供者实现的
 * 2.Provider Registration API (提供者注册API) 这是系统用来注册实现的，让客户端访问他们的
 * 3.Service Access API (服务访问API) 是客户端获取服务实例
 * 4.(可选)Service Provider Interface (服务提供者接口) 负责创建其服务的实例
 */

// Service interface (服务接口)
interface Service{
    public void login();
}

// Service provider interface (服务提供者接口)
interface Provider{
    Service newServece();
}

class Services{
    private Services() {
    }

    private static final Map<String,Provider>  providers = new ConcurrentHashMap<String, Provider>();

    public static final String DEFAULT_PROVIDER_NAME = "<def>";


    // Provider Registration API (提供者注册API)
    public static void registerDefaultProvider(Provider provider){
        registerProvider(provider,DEFAULT_PROVIDER_NAME);
    }

    public static void registerProvider(Provider provider,String name){
        providers.put(name,provider);
    }


    // Service Access API (服务访问API)
    public static Service newInstance(){
        return newInstance(DEFAULT_PROVIDER_NAME);
    }


    public static Service newInstance(String name){
        Provider p = providers.get(name);
        if (null == p){
            throw new IllegalArgumentException("No provider");
        }
        return p.newServece();
    }


}


class LoginProvider implements Provider{

    public Service newServece() {
        return new LoginService();
    }
}

class LoginService implements Service{

    public void login() {
        System.out.println("login success");
    }
}


