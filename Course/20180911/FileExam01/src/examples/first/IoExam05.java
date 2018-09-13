package examples.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class IoExam05 {
    public static void main(String[] args){
        BufferedReader br = null;
        PrintWriter pw = null;
        try{

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try{
                br.close();
            }catch (IOException ex){}

            pw.close();
        }
    }
}
