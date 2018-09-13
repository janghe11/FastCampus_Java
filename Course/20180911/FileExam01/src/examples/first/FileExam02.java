package examples.first;

import java.io.File;

public class FileExam02 {
    public static void main(String[] args){
        File file = new File(".");
        System.out.println(file.getAbsolutePath());
    }
}
