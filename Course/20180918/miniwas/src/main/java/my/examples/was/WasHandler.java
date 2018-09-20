package my.examples.was;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;

public class WasHandler extends Thread {
    // Connector를 이용하여 WasEngine, DefaultServlet, Context 꺼내기
    private Connector connector;
    private Socket socket;
    private String line = null;
    private String[] reqInfo = new String[3];
    private HashMap<String, String> headerInfo = null;

    public WasHandler(Connector connector, Socket socket){
        this.connector = connector;
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("WAS Handler Start");
        BufferedReader bufferedReader = null;
        PrintWriter printWriter = null;
        try{
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            headerInfo = new HashMap<String, String>();
            line = bufferedReader.readLine();
            for (int i = 0; i < 3; i++){
                reqInfo[i] = line.split(" ")[i];
//                System.out.print("reqInfo[" + i + "] = " + reqInfo[i] + " \n");
            }
            while ((line = bufferedReader.readLine()) != null){
                if (line.isEmpty())
                    break;

                String lines[] = line.split(": ");

                for (int putCount = 0; putCount < lines.length; putCount += 2){
                    this.headerInfo.put(lines[putCount], lines[putCount + 1]);
                }
            }

            // header 데이터를 request 인스턴스에 전달
            WasRequest wasRequest = new WasRequest(headerInfo);
            WasResponse wasResponse = new WasResponse();

        }catch (Exception ex) {
            System.out.println("reading error : " + ex.getCause());
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
