package examples.first;

import java.io.*;

public class IoExam02 {
    public static void main(String[] args){
        InputStream in = null;
        OutputStream out = null;
        try{
            File file = new File("/home/jang/Projects/FastCampus_Java/Course/20180911/FileExam01/src/examples/first/readme.md");
            if (!file.isDirectory() && file.exists()){
                in = new FileInputStream(file);
                out = new FileOutputStream("/home/jang/Projects/FastCampus_Java/Course/20180911/FileExam01/src/examples/first/readme.out");
                byte[] buffer = new byte[1024];
                int readCount = 0;
                while ((readCount = in.read()) != -1){
                    out.write(buffer, 0, readCount);
                }

                int readData = 0;
                while((readData = in.read()) != -1){
                    out.write(readData);
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try{
                in.close();
            }catch (IOException ex){}
            try{
                out.close();
            }catch (IOException ex){}
        }
    } // main
}
