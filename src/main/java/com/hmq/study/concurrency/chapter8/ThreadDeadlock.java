package com.hmq.study.concurrency.chapter8;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.SimpleFormatter;

/**
 * Created by  Hmq
 *
 * @date on 2019/3/20.
 */
public class ThreadDeadlock {
    ExecutorService exec = Executors.newSingleThreadExecutor();

    public class LoadFileTask implements Callable<String> {
        private final String fileName;

        public LoadFileTask(String fileName) {
            this.fileName = fileName;
        }

        public String call() throws Exception {
            // Here's where we would actually read the file
            return "";
        }
    }

    public class RenderPageTask implements Callable<String> {
        public String call() throws Exception {
            Future<String> header, footer;
            header = exec.submit(new LoadFileTask("header.html"));
            footer = exec.submit(new LoadFileTask("footer.html"));
            String page = renderBody();
            // Will deadlock -- task waiting for result of subtask
            return header.get() + page + footer.get();
        }

        private String renderBody() {
            // Here's where we would actually render the page
            return "";
        }
    }

    public static void main(String[] args) {
//       dayOfMonth(2019,2);
//        Calendar c = Calendar.getInstance();
//        System.out.println(c.get(Calendar.MONTH));

//        System.out.println(formatNumber(989000 / 10000.0d , "#.#"));
//        asd();

//        NumberFormat format = NumberFormat.getNumberInstance();
//        format.setMaximumIntegerDigits(2);
//        System.out.println(format.format(123.123));

//        Map<String,Object> map = new HashMap<>();
//        map.put("a","aaaaa");
//        map.put("b","bbbbb");
//
//        System.out.println(map.remove("a"));
//        System.out.println(map.get("a"));
//        System.out.println(getByCalender(Calendar.MONTH));
//        dayOfMonth(2019,2-1);
//        System.out.println(addCalenderByField(Calendar.MONTH,0));

        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
        String a = "2019-04-01";
        String b = "2019-04-02";
        try {
            Date da = sim.parse(a);
            Date db = sim.parse(b);
            Date now = new Date();
//            System.out.println(now.before(da));
//            System.out.println(now.before(db));
//            System.out.println(now.getTime() > db.getTime());
            Date aa = new Date(db.getTime());

            System.out.println(aa);

        } catch (ParseException e) {
            e.printStackTrace();
        }


    }


    public static int addCalenderByField(int field,int val){
        Calendar c = Calendar.getInstance();
        c.clear();
        c.setTime(new Date());
        c.add(field, val);
        return c.get(field);
    }

    public static int getByCalender(int field){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH,-1);
        return c.get(field);
    }


    private static String formatNumber(Object number,String reg){
        DecimalFormat format = new DecimalFormat(reg);
        return format.format(number);
    }

    private static List<String> dayOfMonth(Integer year,Integer month,Integer day){
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
//        c.set(Calendar.DAY_OF_MONTH,day);
        int days = c.get(Calendar.DAY_OF_MONTH);
        for (int i = days; i >= 1; i--) {
            c.set(Calendar.DAY_OF_MONTH, i);
            System.out.println(sim.format(c.getTime()));
        }
        return null;
    }

    private static List<String> dayOfMonth(Integer year,Integer month){
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
        List<String> date = new ArrayList<String>(31);
        Calendar c = Calendar.getInstance();
        System.out.println(sim.format(c.getTime()));
        c.clear();
        c.setTime(new Date());
        int days;
        if (c.get(Calendar.YEAR) == year && c.get(Calendar.MONTH) == month){
            days = c.get(Calendar.DAY_OF_MONTH);
        }else{
            c.set(Calendar.YEAR, year);
            c.set(Calendar.MONTH, month);
            c.set(Calendar.DAY_OF_MONTH,1);
            days = c.getActualMaximum(Calendar.DATE);

        }

        for (int i = days; i >= 1; i--) {
            c.set(Calendar.DAY_OF_MONTH,i);
            System.out.println(sim.format(c.getTime()));
            date.add(sim.format(c.getTime()));
        }
        return date;
    }


    public static void asd(){
        List<String> list = new ArrayList<>();
        list.add("AAA");
        list.add("bbbb");
        list.add("c");

        List<String> list2 = new ArrayList<>();
        list2.add("bbbb");
        list2.add("AAA");
//        System.out.println(list.get(list.size()));

//        list.removeAll(list2);
        int x = 0;
        for (String s : list) {
            x += 1;
        }

        System.out.println(x);


    }


}
