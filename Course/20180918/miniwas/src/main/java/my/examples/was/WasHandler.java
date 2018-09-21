package my.examples.was;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;

public class WasHandler extends Thread {
    // Connector를 이용하여 WasEngine, DefaultServlet, Context 꺼내기
    private Connector connector;
    private Socket socket;

    public WasHandler(Connector connector, Socket socket){
        this.connector = connector;
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("WAS Handler Start");
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;
        OutputStream outputStream = null;
        PrintWriter printWriter = null;
        // header 데이터를 request 인스턴스에 전달
        WasRequest wasRequest = null;
        WasResponse wasResponse = null;
        DefaultServlet defaultServlet = null;

        try{
            // InputStream 생성
            inputStream = socket.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            // OutputStream 생성
            outputStream = socket.getOutputStream();
            printWriter = new PrintWriter(new OutputStreamWriter(outputStream));

            // wasRequest에 InputStream 넣어주기
            wasRequest = new WasRequest(inputStream, bufferedReader);
            wasResponse = new WasResponse(outputStream, printWriter);
            defaultServlet = new DefaultServlet();

            // 정적 데이터 찾아서 전송
            defaultServlet.service(wasRequest, wasResponse);

        }catch (Exception ex) {
            System.out.println("reading error : " + ex.getCause());
        }finally {
            try {
                inputStream.close();
            }catch (Exception ioe) {
                ioe.getMessage();
            }
            try{
                outputStream.close();
            }catch (Exception poe){
                poe.getMessage();
            }
            try{
                socket.close();
            }catch (Exception soe) {
                System.out.println(soe.getStackTrace());
            }
        }

    }
}
