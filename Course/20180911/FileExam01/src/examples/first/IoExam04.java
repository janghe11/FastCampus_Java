package examples.first;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class IoExam04 {
    public static void main(String[] args) throws Exception{
        URL url = new URL("https://www.naver.com");
        InputStream in = url.openStream();

        OutputStream out = new FileOutputStream("/home/jang/Projects/FastCampus_Java/Course/20180911/FileExam01/src/examples/first/naver.html");

        CopyUtil.copy(in, out);

    }
}
