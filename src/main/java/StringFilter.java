import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a list of strings,
 * return a list of the strings, omitting any string length 4 or more.
 */

public class StringFilter {
    private static final int MAX_LENGTH = 4;

    public static List<String> noLongString(List<String> strings) {
        return strings.stream().filter(i -> i.length() < MAX_LENGTH).collect(Collectors.toList());
    }
}
