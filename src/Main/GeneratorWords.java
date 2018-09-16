package Main;
/**
 *Создать генератор текстовых файлов, работающий по следующим правилам:
 *
 * 1. Предложение состоит из 1<=n1<=15 слов. В предложении после произвольных слов могут находиться запятые.
 *
 * 2. Слово состоит из 1<=n2<=15 латинских букв
 *
 * 3. Слова разделены одним пробелом
 *
 * 4. Предложение начинается с заглавной буквы
 *
 * 5. Предложение заканчивается (.|!|?)+" "
 *
 * 6. Текст состоит из абзацев. в одном абзаце 1<=n3<=20 предложений.
 * В конце абзаца стоит разрыв строки и перенос каретки.
 *
 * 7. Есть массив слов 1<=n4<=1000.
 * Есть вероятность probability вхождения одного из слов этого массива в следующее предложение (1/probability).
 *
 * Задача: написать метод void getFiles(String path, int n, int size, String[] words, int probability),
 * который создаст n файлов размером size в каталоге path.
 * Words - массив слов из п. 7, probability - вероятность из п. 7.
 *
 *
 *
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GeneratorWords {

    public GeneratorWords() {
    }

    /**
     *  create metod void getFiles(String path, int n, int size, String[] words, int probability),
     *  * который создаст n файлов размером size в каталоге path.
     *  * Words - массив слов из п. 7, probability - вероятность из п. 7.
     */
    public String getFiles(String path, int n, int size, String[] words, int probability){
        for(int ind_file = 0; ind_file < n; ind_file++){
            try (FileWriter fileWriter = new FileWriter(path + "file" + ind_file + ".txt")) {
                fileWriter.write(text_generator(size, probability, words));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //System.out.println(gen_words());
    return text_generator(size, probability, words);
    }





    private String text_generator(int size, int probability, String[] words) {
        int paragr_int = 20;
        //number_of_files= 10;
        StringBuffer text = new StringBuffer("");


        Random numbers_paragraph = new Random();
        int iparagrapf = numbers_paragraph.nextInt(paragr_int) + 1;

        for (int number_paragraph = 0; number_paragraph < paragr_int; number_paragraph++) {
            text.append(getParagraph(probability, words));
        }
        return text.toString();
    }




    /**
     * 6. Текст состоит из абзацев. в одном абзаце 1<=n3<=20 предложений.
     * В конце абзаца стоит разрыв строки и перенос каретки.
     *
     * @param prprobability
     * @param words
     * @return
     */

    private String getParagraph(int prprobability, String[] words) {
        int paragraph_length =20;
        StringBuffer paragraph= new StringBuffer();

        Random pr_paragraph = new Random();
        int iparagrapf = pr_paragraph.nextInt(paragraph_length) + 1;


        for (int number_of_sentence=0;number_of_sentence<iparagrapf;number_of_sentence++){
            paragraph.append(gen_Sentence(prprobability,words));
        }
        return paragraph.toString()+"   \n";
    }
    ;

    /**
     *  Есть массив слов 1<=n4<=1000.
     *  Есть вероятность probability вхождения одного из слов этого массива
     *  в следующее предложение (1/probability).
     *
     * 1. Предложение состоит из 1<=n1<=15 слов.
     * В предложении после произвольных слов могут находиться запятые.
     *
     * 4. Предложение начинается с заглавной буквы
     *
     * 3. Слова разделены одним пробелом
     *
     *
     *
     * 5. Предложение заканчивается (.|!|?)+" "
     * @param prprobability
     * @param words
     * @return
     */

    private String gen_Sentence(int prprobability,String[] words){
        StringBuffer sentence=new StringBuffer("");//


        Random numberchars_n1 = new Random();
        int n1 = numberchars_n1.nextInt(15) + 1;

        for(int number_n1=0;number_n1<(n1-1);number_n1++){

            int input_word = 1;
            if ((number_n1 == 0) && (input_word ==1)){

                Random number_word_n1 = new Random();
                int number_word_from_massive = number_word_n1.nextInt(words.length);//number word from massive


                Random pr_ver = new Random();
                int random_ver = numberchars_n1.nextInt(prprobability) + 1;

                if (random_ver==1 ) {
                    sentence.append(words[number_word_from_massive].substring(0, 1).toUpperCase());
                }
                else sentence.append(gen_words().substring(0,1).toUpperCase());

            } else {
                sentence.append(gen_words());
            }
            Random comma_ver = new Random();
            int comma_ver_ = numberchars_n1.nextInt(prprobability) + 1;
            if (number_n1 ==comma_ver_) {
                sentence.append(",");
            }
            sentence.append(" ");
        }


        //gen final sentence
        if (numberchars_n1 != null) {
            char[] final_char_symbol = {'.', '!', '?'};

            Random final_index = new Random();
            int final_i = numberchars_n1.nextInt(3);

            sentence.append(final_char_symbol[final_i]+" ");
        }


            return (sentence.toString());

    }
    ;

    /**
     * 2. Слово состоит из 1<=n2<=15 латинских букв
     * @return
     */
     private String gen_words(){
         String s;
         StringBuffer word=new StringBuffer();//

         Random numberchars_n2 = new Random();
         int iNumber = numberchars_n2.nextInt(15) + 1;

         for(int elements=0; elements<iNumber; elements++) {
             Random randoms = new Random();
             char c = (char) (randoms.nextInt('z' - 'a') + 'a');
             word.append(c);
         }
         s = word.toString();
         return s;
     }





    public static void writeFile(String fileName,
                                 String content) {
        try (FileOutputStream fileOutputStream =
                     new FileOutputStream(fileName)) {
            byte[] buffer = content.getBytes();
            fileOutputStream.write(buffer, 0,
                    buffer.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
