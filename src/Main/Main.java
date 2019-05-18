package Main;

import java.lang.reflect.Field;
import java.util.Random;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        String[] words_set ={
                "word1","word2"
        };
        String puth_2_file="C://Users//IIV//Documents//Temp";//Путь к файлу
        GeneratorWords generatorWords = new GeneratorWords();
        generatorWords.getFiles(puth_2_file, 6, 5, words_set, 4);
        for (int numberClass = 0; numberClass < 100; numberClass++){
            GeneratorPojo generatorPojo = new GeneratorPojo(1000,"C://Users//IIV//Documents//Temp//");
        }

        //**
        //
        // Вывод загруженных в память классов
        //
        Field f;
        try {
            f = ClassLoader.class.getDeclaredField("classes");
            f.setAccessible(true);
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            Vector<Class> classes = (Vector<Class>) f.get(classLoader);

            for(Class cls : classes){
                java.net.URL location = cls.getResource('/' + cls.getName().replace('.',
                        '/') + ".class");
                out.println("<p>"+location +"<p/>");
            }
        } catch (Exception e) {

            e.printStackTrace();
        }

    }
}
