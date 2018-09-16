package Main;

import java.util.Random;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String[] words_set ={
                "word1","word2"
        };
        String puth_2_file="C://Users//IIV//Documents//Temp";//Путь к файлу
        GeneratorWords generatorWords =new GeneratorWords();
        generatorWords.getFiles(puth_2_file, 6, 5, words_set, 4);

    }
    ;





}
