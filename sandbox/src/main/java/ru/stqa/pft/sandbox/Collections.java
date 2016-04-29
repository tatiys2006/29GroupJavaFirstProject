package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tetyana.kostyrkina on 4/29/2016.
 */
public class Collections {

    public static void main(String[] args) {
        String[] langs = {"Java", "C#", "Python", "PHP"}; //massiv

        /* String[] langs = new String[4];
        langs[0] = "Java";
        langs[1] = "C#";
        langs[2] = "Python";
        langs[3] = "PHP";
        */

        List<String> languages = new ArrayList<String>(); //spisok
        languages.add("Java");
        languages.add("C#");
        languages.add("Python");



        for (String l : languages) {
            System.out.println("Я хочу выучить " + l);
        }
    }
}
