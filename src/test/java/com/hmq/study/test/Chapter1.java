package com.hmq.study.test;

import java.io.InputStream;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by  Hmq
 *
 * @date on 2019/2/21.
 */
public class Chapter1 {


    public static void main(String[] args) {
//        int size = 2;
//        Object[] element = new Object[size];
//        element[0] = 1;
//        int i = --size;
//        Object o = element[--size];
//        System.out.println(o);

//        int i = 2;
//        int j = 3;
//
//        int m = i++ + --j;
//        System.out.println(m);
//        System.out.println(i + "---" + j);

//        Map<String,Object> map = new WeakHashMap<String, Object>();
//        Map<String,Object> map2 = new HashMap<String, Object>();


//        BigInteger in = new BigInteger("20");
//        in.nextProbablePrime();
//
//        AtomicInteger a = new AtomicInteger();

//        StringBuilder sql = new StringBuilder("SELECT b.id,b.cms_book_id,b.title,b.authors,b.category_id,c.`name`,b.is_serial," +
//                "b.num_of_chars,b.original_num_of_chars,b.auditing_type,b.`status`,b.audit_time,b.update_date" +
//                "FROM original_books b" +
//                "LEFT JOIN original_book_category c" +
//                "ON b.category_id = c.id");
//
//        String lowerCase = sql.toString().toLowerCase();
//        int fromIndex = lowerCase.indexOf("from");
//        String substring = sql.substring(fromIndex, sql.length());
//
//        System.out.println(substring);
//        StringBuffer

        study();


    }


    private final Object finalizeChapter = new Object(){
        @Override
        protected void finalize() throws Throwable {
            super.finalize();
        }
    };



    static void study(){
//        List<String> list = new ArrayList<>();
//        list.add()


        int[] a = new int[10];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        a[3] = 3;
        /* hmq
         * arraycopy(a, 2, a, 3, 1);
         * a 数据源
         * 2 数据源中要拷贝的起始下标
         * a 目标
         * 3 目标中放置拷贝数据的下标
         * 1 拷贝长度
         */
        System.arraycopy(a, 2, a, 3, 1);// 实现数组自己copy自己
//        a[2]=99;
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }


        Set set = new HashSet();


    }




}
