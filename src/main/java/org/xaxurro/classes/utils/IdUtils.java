package org.xaxurro.classes.utils;

public class IdUtils {
    private static final String REGEX_ID_COMPLETE = "[a-z_]+:[a-z_]+";
    private static final String REGEX_ID_NAME = "[a-z_]+";
    public static boolean isValid (String id) {
        return id.matches(REGEX_ID_COMPLETE) || id.matches(REGEX_ID_NAME);
    }
    public static boolean isValidThrow (String id) {
        if (!id.matches(REGEX_ID_COMPLETE) && !id.matches(REGEX_ID_NAME)) {
            throw new IllegalArgumentException("id: " + id + " does not matches regex");
        }
        return true;
    }
    public static boolean isComplete (String id) {
        return id.matches(REGEX_ID_COMPLETE);
    }

    public static boolean isName (String id) {
        return id.matches(REGEX_ID_NAME);
    }

    public static String parse (String id) {
        if (!isComplete(id)){
            return "minecraft:" + id;
        }
        return id;
    }
}
