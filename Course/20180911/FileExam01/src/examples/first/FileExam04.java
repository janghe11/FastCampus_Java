package examples.first;

import java.io.File;

public class FileExam04 {
    public static void main(String[] args){
        File file = new File("/home/jang/Projects/FastCampus_Java/Course/20180911/FileExam01/src/examples/first/tmp/a/b/c/d/e");
        if (!file.exists()) {
            file.mkdirs();
        }
    }
}
