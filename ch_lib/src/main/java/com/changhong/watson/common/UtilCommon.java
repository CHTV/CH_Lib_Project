package com.changhong.watson.common;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Common Util
 * Created by Watson on 2017/7/16.
 *
 * @author Watson
 */
public class UtilCommon {

    private static UtilCommon utilCommon;
    private String logTag = "ch-log--";

    private UtilCommon() {
    }

    public static UtilCommon getInstance() {
        if (utilCommon == null) {
            utilCommon = new UtilCommon();
        }
        return utilCommon;
    }

    /**
     * check the phone number is correct
     *
     * @param number the phone number
     * @return <b>true</b> is correct number <br/>
     * <b>false</b> is error number
     */
    public boolean phoneNumberMatch(String number) {
        Pattern p = Pattern.compile("^((13[0-9])|(15[0-9])|(18[0-9]))\\d{8}$");
        Matcher m = p.matcher(number);
        return m.matches();
    }


    /**
     * Read file by line
     *
     * @param filePath The absolute abstract path of file.
     * @return the content of file stored in a list interface.
     */
    public List<String> readFileByLine(String filePath) {
        List<String> arrayList = new ArrayList<String>();
        try {
            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                if (!"\n".equals(line)) {
                    arrayList.add(line);
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    /**
     * Read file by line
     *
     * @param filePath The absolute abstract path of file.
     * @return the content of file stored in a string object.
     */
    public String readFileByLineReturnString(String filePath) {
        StringBuilder sb = new StringBuilder();
        try {
            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                if (!"\n".equals(line)) {
                    sb.append(line);
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * Write content to file
     *
     * @param fileName the system-dependent file name
     * @param content  the content you want to write
     * @param isAppend if <code>true</code>, then bytes will be written to the end of the file rather than the beginning
     */
    public void writeFileData(String fileName, String content, boolean isAppend) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(fileName, isAppend);
            byte[] bytes = content.getBytes("UTF-8");
            fileOutputStream.write(bytes);

        } catch (Exception e) {
            Logger.e(logTag, e);
        } finally {
            if (null != fileOutputStream) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void showToastLong(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    public void showToastShort(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public void showToastByHandler(final Context context, Handler handler, final String content) {
        Runnable mRun = new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, content, Toast.LENGTH_LONG).show();
            }
        };
        handler.post(mRun);
    }
}
