package my.examples.was;

import javafx.scene.chart.BubbleChart;

import java.io.BufferedReader;
import java.io.InputStream;
import java.util.HashMap;

public class WasRequest {
    private InputStream inputStream;
    private BufferedReader bufferedReader;
    private String line = null;
    private String method;
    private String path;
    private HashMap<String, String> headerInfo = new HashMap<>();

    public WasRequest(InputStream inputStream, BufferedReader bufferedReader) {
        this.inputStream = inputStream;
        this.bufferedReader = bufferedReader;

        headerInfo =new HashMap<>();
        try {
            // 요청 라인에서 GET & path 얻어오기
            line = bufferedReader.readLine();
            String[] reqInfo = line.split(" ");
            method = reqInfo[0];
            path = reqInfo[1];

            // 헤더 얻어오기
            while((line = bufferedReader.readLine())!=null){
                if (line.isEmpty())
                    break;

                // colon 찾기 (split 지양)
                int colonIndex = line.indexOf(":");
                String headerName = null;
                String headerValue = null;

                // 잘라서 Key Value 넣어주기
                if (colonIndex != -1){
                    headerName = line.substring(0, colonIndex);
                    headerValue = line.substring(colonIndex + 1);
                }
                headerInfo.put(headerName, headerValue);
//                for (int putCount = 0; putCount < lines.length; putCount += 2) {
//                    this.headerInfo.put(lines[putCount], lines[putCount + 1]);
//                }
            }
        }catch (Exception e) {
            e.getMessage();
        }finally {}
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    public String getLine() {
        return line;
    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public HashMap<String, String> getHeaderInfo() {
        return headerInfo;
    }
}
