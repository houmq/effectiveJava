package com.hmq.study.chapter6;

import java.util.EnumSet;
import java.util.Set;

/**
 * Created by  Hmq
 *
 * @date on 2019/3/6.
 */
public class EnumSetTest {


    public enum Style{
        BOLD,ITALIC;
    }


    public void applyStyle(Set<Style> styles){

    }

    public static void main(String[] args) {
//        EnumSetTest text = new EnumSetTest();
//        text.applyStyle(EnumSet.of(Style.BOLD, Style.ITALIC));

        System.out.println(new Herb("a",Herb.Type.ANNUAL).toString());


    }

}

class Herb{

    public enum Type{ANNUAL,PERENNIAL,BIENNIAL;}

    private String name;
    private Type type;

    public Herb(String name,Type type) {
        this.name = name;
        this.type = type;
    }


    @Override
    public String toString() {
        return " -- " + name;
    }
}
