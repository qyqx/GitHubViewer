
package net.flaxia.android.githubviewer.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;

public class CommonHelper {
    /**
     * stringが空か調べる
     * 
     * @param string
     * @return
     */
    public static boolean isEmpty(final String string) {
        if (null == string || !string.matches(".*\\S+.*")) {
            return true;
        }
        return false;
    }

    /**
     * 拡張子を返す
     * 
     * @param fileName
     * @return
     */
    public static String getSuffix(final String fileName) {
        if (null == fileName || 0 == fileName.length())
            return null;

        final int point = fileName.lastIndexOf(".");
        if (point != -1) {
            return fileName.substring(point + 1);
        }
        return fileName;
    }

    public static String escapeSign(final String source) {
        return source.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
    }

    public static String getNow() {
        final Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR) + "/" + calendar.get(Calendar.MONTH) + 1 + "/"
                + calendar.get(Calendar.DAY_OF_MONTH) + "/" + " "
                + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":"
                + calendar.get(Calendar.SECOND);
    }

    public static void download(final URL url, final File uri) throws IOException {
        final URLConnection conn = url.openConnection();
        final InputStream in = conn.getInputStream();
        final FileOutputStream out = new FileOutputStream(uri, false);
        final byte buf[] = new byte[1024];
        int len;
        while ((len = in.read(buf)) != -1) {
            out.write(buf, 0, len);
        }

        out.close();
        in.close();
    }

    public static String removeExtension(final String path) {
        final int dot = path.lastIndexOf(".");
        if (-1 == dot || 0 == dot || dot <= path.lastIndexOf("/") + 1) {
            return path;
        } else {
            return path.substring(0, dot);
        }
    }
}
