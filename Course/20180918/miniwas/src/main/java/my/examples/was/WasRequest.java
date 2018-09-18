package my.examples.was;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;

public class WasRequest extends Thread {
    private WasServer wasServer;
    private Socket socket;
    private String line = null;
    private String[] reqInfo = new String[3];
    private HashMap<String, String> headerInfo = null;

    public WasRequest(WasServer wasServer, Socket socket){
        this.wasServer = wasServer;
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("WAS Handler Start");
        // 첫 줄 request를 readline으로 받기 위한 BufferedReader 생성
        BufferedReader bufferedReader = null;
        BufferedInputStream in = null;
        try{
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            line = bufferedReader.readLine();
            for (int i = 0; i < 3; i++){
                reqInfo[i] = line.split(" ")[i];
//                System.out.print("reqInfo[" + i + "] = " + reqInfo[i] + " \n");
            }
            while ((line = bufferedReader.readLine()) != null){
                int readCount = 0;
                String lines[] = line.split(": ");
//                headerInfo.put(lines[0], lines[1]);
//                System.out.println("Key : " + lines[0] + "/ Values : " + headerInfo.get(lines[0]));
                headerInfo.put(lines[readCount], lines[readCount + 1]);
                System.out.println(lines[readCount] + " " + lines[readCount + 1]);
                readCount += 2;
            }

        }catch (Exception ex) {
            System.out.println("reading error : " + ex.getMessage());
        }finally {
            try{
                socket.close();
            }catch (Exception ioe) {
                System.out.println(ioe.getStackTrace());
            }
            try{
                bufferedReader.close();
            }catch (Exception ioe) {
                System.out.println(ioe.getStackTrace());
            }

        }

    }
}
