package net.thjang.blog;

import java.io.*;
import java.net.Socket;

/**
 * v1.0
 * InputStream과 OutputStream을 생성하고, DefaultServlet을 통해 Request과 Response를 전달한다.
 */
public class WASHandler extends Thread{
    Connector connector = null;
    Socket socket = null;

    public WASHandler(Connector connector, Socket socket) {
        this.connector = connector;
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;
        OutputStream outputStream = null;
        PrintWriter printWriter = null;

        WASRequest wasRequest = null;
        WASResponse wasResponse = null;
        DefaultServlet defaultServlet = null;

        try {
            inputStream = socket.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            outputStream = socket.getOutputStream();
            printWriter = new PrintWriter(new OutputStreamWriter(outputStream));

            wasRequest = new WASRequest(inputStream, bufferedReader);
            wasResponse = new WASResponse(outputStream, printWriter);

            defaultServlet = new DefaultServlet();
            defaultServlet.service(wasRequest, wasResponse);

        } catch (IOException ioe) {
            System.out.println("reading error : " + ioe.getCause());
            ioe.getStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException ioe) {
                ioe.getStackTrace();
            }

            try {
                outputStream.close();
            } catch (IOException ioe) {
                ioe.getStackTrace();
            }

            try {
                bufferedReader.close();
            } catch (IOException ioe) {
                ioe.getStackTrace();
            }
            printWriter.close();
        }
    }
}
