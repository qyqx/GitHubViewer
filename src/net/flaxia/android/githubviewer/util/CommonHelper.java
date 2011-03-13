package net.flaxia.android.githubviewer.util;

public class CommonHelper {
    /**
     * stringが空か調べる
     * 
     * @param string
     * @return
     */
    public static boolean isEmpty(String string) {
        if (null == string || !string.matches(".*\\S+.*")) {
            return true;
        }
        return false;
    }

    public static String multiply(String str, int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
    
    public static int continuousCount(String str, char c){
        int level = 0;
        while (str.charAt(level) == '*') {
            level++;
        }
        return level;
    }
}