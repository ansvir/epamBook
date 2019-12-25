package part.two.chapter.one;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChapterOne {
    public static String task4(String str) {
        List<String> allMatches = new ArrayList<String>();
        Matcher m = Pattern.compile("([a-z])\\1+").matcher(str);
        while (m.find()) {
            allMatches.add(m.group());
        }

        for(String match: allMatches) {
            str=str.replaceFirst(match, match.substring(0,1)+match.length());
        }

        return str;
    }
}
