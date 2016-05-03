package ru.stqa.pft.sandbox;

import java.util.Arrays;
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

        for (String l : langs) {
            System.out.println("Я хочу выучить " + l);
        }

        List languages = Arrays.asList("Java 8", "C#", "Python");
       /*
       List<String> languages = Arrays.asList("Java 8", "C#", "Python");
    ili
       List<String> languages = new ArrayList<String>(); //spisok
       
       languages.add("Java");
        languages.add("C#");
        languages.add("Python");


        for (int i = 0; i < languages.size(); i++){
            System.out.println("Я хочу выучить " + languages.get(i));
        }

        for (String l : languages) {
            System.out.println("Я хочу выучить " + l);
        }
        */

        for (Object l : languages) { //spisok obectov proizvolnogo tipa
            System.out.println("Я хочу выучить " + l);
        }
    }
}
