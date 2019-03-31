import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public String replaceSpace(StringBuffer str) {
        Pattern pattern = Pattern.compile("\\s");
        Matcher matcher = pattern.matcher(str);
        return matcher.replaceAll("%20");
    }
}