package net.thjang.blog;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CreateDateFolders {
    public static void main(String[] args){
        // 날짜 구하기
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedTime = timeFormat.format(cal.getTime());
        System.out.println(formattedTime);

        // 날짜에 맞는 폴더 생성하기
        String[] dateSplit = formattedTime.split("-");
        File file = new File("/home/jang/Projects/FastCampus_Java/Homeworks/20180911/" + dateSplit[0] + File.separator + dateSplit[1] + File.separator + dateSplit[2]);
        if (!file.exists())
              file.mkdirs();
    }
}
