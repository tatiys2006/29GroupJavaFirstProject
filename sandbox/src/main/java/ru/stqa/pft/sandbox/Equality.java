package ru.stqa.pft.sandbox;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by tetyana.kostyrkina on 4/25/2016.
 */
public class Equality {

    public static void main(String[] args) {
        /* String s1 = "firefox";
       // String s2 = s1;
        String s2 = new String(s1);
        */

        /*
        String s1 = "firefox";
        String s2 = "fire" + "fox"; //rabotaet kompilyator, 4to ob'ect odinakovuj
        */

        String s1 = "firefox 2.0";
        String s2 = "firefox " + Math.sqrt(4.0); //kompilyator ne vi4islyaet zna4eniya, poetomy oni raznue dlya nego

        System.out.println(s1 == s2); // proverka ssulok, identi4nost' ob'ectov, fizi4eskoe sravnenie, dlya 4isel
        System.out.println(s1.equals(s2)); //sravnenie sodergimogo ob'ectov, logi4eskoe sravnenie, dlya ob'ectov
    }
}
