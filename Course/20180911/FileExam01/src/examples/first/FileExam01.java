package examples.first;

import java.io.File;

public class FileExam01 {
    public static void main(String[] args){
//        String fileName = "/home/jang/Projects/FastCampus_Java/Course/20180911/FileExam01/src/examples/first/readme.md";
//        String fileName = File.separator + "home" + File.separator + "jang" + File.separator + "Projects" + File.separator + "FastCampus_Java" + File.separator + "Course" + File.separator + "20180911" + File.separator + "FileExam01" + File.separator + "src" + File.separator + "examples" + File.separator + "first" + File.separator + "readme.md";
//        File file = new File(fileName);
        File file = new File("./first/examles/readme.md");

        if (file.exists()){
//            System.out.println(fileName + "이 있어요.");
            System.out.println("있어요.");
        }
    }
}
