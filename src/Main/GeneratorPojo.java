package Main;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import sun.awt.SunHints;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GeneratorPojo {
    public GeneratorPojo(int number, String nameGenerator) {
        fileClassGenerator(number);
    }

    /**
     * Method generate files for
     * @param number
     */
    private void fileClassGenerator(int number){
        String path2file = "C://Users//IIV//Documents//Temp//";
        String nameClass = nameclassgenerator();

        //for (int numberClass = 0; numberClass < number; numberClass++) {
            try (FileWriter fileWriter = new FileWriter(path2file + nameClass + ".java")) {
                fileWriter.write(classGenerator(nameClass));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        //}

    }
    /**
     *
     *
     *
     *
     * **/
    private String classGenerator(String nameClass){
        String classout;
        StringBuffer classbuffer = new StringBuffer();
        classbuffer.append("package Flow0.Pojo;");
        classbuffer.append(System.getProperty("line.separator"));
        classbuffer.append("import java.util.List;");
        classbuffer.append(System.getProperty("line.separator"));
        classbuffer.append("import java.util.Map;");
        classbuffer.append(System.getProperty("line.separator"));
        classbuffer.append("import java.util.Set;");
        classbuffer.append(System.getProperty("line.separator"));

        //genaration name class
        classbuffer.append(" class " + nameClass);
        //classbuffer.append();
        classbuffer.append("{");
        classbuffer.append(System.getProperty("line.separator"));
        //generation int id
        Random intIdVal = new Random();
        int Id = intIdVal.nextInt(100) + 1;//
        classbuffer.append("private int id = " + Integer.toString(Id)+";");
        classbuffer.append(System.getProperty("line.separator"));
        //generation random methods
        Random numberOfMethods = new Random();
        int iNumber = numberOfMethods.nextInt(100) + 1;//
        for(int ind = 0; ind < iNumber; ind++){
            classbuffer.append(typeGenerator()+" ");
            classbuffer.append(nameGenerator());
            classbuffer.append(";");
            classbuffer.append(System.getProperty("line.separator"));
        }
        //classbuffer.append(System.getProperty("line.separator"));
        classbuffer.append("}");

        classout = classbuffer.toString();
        return classout;
    }

    /**
     *
     * @return name for methods and Class
     */
    private String nameGenerator(){
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

    private String typeGenerator(){
        String type;
        StringBuilder typebuff=new StringBuilder();
        Random typeAcces = new Random();
        int iAcces = typeAcces.nextInt(3) + 1;
        switch (iAcces) {
            case 1:
                typebuff.append("private ");
                break;
            case 2:
                typebuff.append("public ");
                break;
            case 3:
                typebuff.append("protected ");
                break;
            default:
                typebuff.append("");
                break;
        }

            Random numberCharsn2 = new Random();
        int iNumber = numberCharsn2.nextInt(12) + 1;

        switch (iNumber) {
            case 1:
                typebuff.append("byte");
                break;
            case 2:
                typebuff.append("short");
                break;
            case 3:
                typebuff.append("int");
                break;
            case 4:
                typebuff.append("long");
                break;
            case 5:
                typebuff.append("float");
                break;
            case 6:
                typebuff.append("double");
                break;
            case 7:
                typebuff.append("boolean");
                break;
            case 8:
                typebuff.append("char");
                break;
            case 9:
                typebuff.append("String");
                break;
            case 10:
                typebuff.append("List");
                break;
            case 11:
                typebuff.append("Map");
                break;
            case 12:
                typebuff.append("Set");
                break;
            default:
                typebuff.append("null");
                break;
        }
        type = typebuff.toString();
        return type;
    }


    private String nameclassgenerator(){
        String s;
        StringBuffer word=new StringBuffer();//

        Random numberchars_n2 = new Random();
        int iNumber = numberchars_n2.nextInt(15) + 1;

        for(int elements=0; elements<iNumber; elements++) {
            Random randoms = new Random();
            char c = (char) (randoms.nextInt('Z' - 'A') + 'A');
            word.append(c);
        }
        s = word.toString();
        return s;
    }
}
