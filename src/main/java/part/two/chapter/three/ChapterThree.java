package part.two.chapter.three;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChapterThree {

    public static String task10(File file) throws InvalidSentenceException{
        StringBuilder input = new StringBuilder("");
        StringBuilder result=new StringBuilder("");
        int symbol = 0;
        try (FileReader fr = new FileReader(file)) {
            while ((symbol = fr.read()) != -1) {
                input.append((char) symbol);
            }
        } catch (IOException exc) {
            System.err.println("IO exception " + exc.toString());
        }

        String[] lexemes = input.toString().split("\n");

        for(String s: lexemes) {
            if(!s.matches("(^((\\w+\\s)|(\\w))+$)|(^$)")) throw new InvalidSentenceException("Input string doesn't match pattern specified in task");
        }
        Pattern firstWordPattern = Pattern.compile("^\\w+");
        Pattern lastWordPattern = Pattern.compile("\\w+$");
        Matcher firstWordMatch;
        Matcher lastWordMatch;
        String firstWord="";
        String lastWord="";
        String[] results=new String[lexemes.length];
        for(int i=0;i<lexemes.length;i++) {
            firstWordMatch = firstWordPattern.matcher(lexemes[i]);
            lastWordMatch = lastWordPattern.matcher(lexemes[i]);
            if(firstWordMatch.find()) {
                firstWord=firstWordMatch.group();
            }
            if(lastWordMatch.find()) {
                lastWord=lastWordMatch.group();
            }

            results[i]=lexemes[i].replaceAll(firstWordPattern.toString(),lastWord);
            results[i]=results[i].replaceAll(lastWordPattern.toString(),firstWord);
            firstWord="";
            lastWord="";
        }
        for(String s: results) {
            result.append(s).append("\n");
        }

        return result.substring(0,result.length()-1).toString();
    }

    public static void main(String[] args) {
        try {
            File file=new File("./src/main/java/part/two/chapter/three/task10.txt");
            System.out.println(task10(file));
        } catch (InvalidSentenceException exc) {
            System.err.println("invalid sentence: "+exc.toString());
        }
    }
}
