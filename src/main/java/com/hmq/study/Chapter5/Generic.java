package com.hmq.study.Chapter5;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.*;

/**
 * 泛型
 * Created by  Hmq
 * @date on 2019/2/27.
 */
public class Generic {


    /**
     * 泛型方法
     * @author Hmq
     * @date 2019/2/27 15:35
     */
    public static <E> Set<E> union(List<E> set1 ,List<E> set2){
        Set<E> result = new HashSet<E>(set1);
        result.addAll(set2);
        return result;
    }


    public static <E> Set<E> union2(List<? extends E> set1 , List<? extends E> set2){
        Set<E> result = new HashSet<E>(set1);
        result.addAll(set2);
        return result;
    }


    /**
     * 异构容器
     * 每个建都有不同的参数化类型
     *
     */
    private static Map<Class<?>,Object> container = new HashMap<Class<?>, Object>();


    public <T> void putThings(Class<T> key,T val){
        container.put(key,val);
    }

    public <T> T getThings(Class<T> key){
        return key.cast(container.get(key));
    }



    static Annotation getAnnotation(AnnotatedElement element,String annotationTypeName){
        Class<?> annotaionType = null;
        try {
            annotaionType = Class.forName(annotationTypeName);
        }catch (Exception e){
            e.printStackTrace();
        }
        return element.getAnnotation(annotaionType.asSubclass(Annotation.class));
    }









}
