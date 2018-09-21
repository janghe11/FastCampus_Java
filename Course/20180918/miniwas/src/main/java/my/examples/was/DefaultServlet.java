package my.examples.was;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class DefaultServlet {
    public void service(WasRequest wasRequest, WasResponse wasResponse){
        OutputStream outputStream = wasResponse.getOutputStream();
        PrintWriter printWriter = wasResponse.getPrintWriter();

        // Web으로부터 Path 얻어오기
        String webPath = wasRequest.getPath();
        if ("/".equals(webPath))
            webPath = webPath + "index.html";

        // 실제 경로 얻기
        // WasConfig maven 추가
        WasConfigManager wcm = WasConfigManager.getInstance();
        MiniWasConfig miniWasConfig
                = wcm.getMiniWasConfig("/home/jang/Projects/FastCampus_Java/Course/20180918/miniwas/src/main/java/my/examples/was/list.json");
        String path = miniWasConfig.getStaticDir() + webPath;

        File file = new File(path);

        if (file.exists()){
            // 파일이 정상적일 경우 OK Response 보내기
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type: text/html; charset=UTF-8");
            printWriter.println("Content-Length: " + file.length());
            printWriter.println("");
            printWriter.flush();

            // 파일 보내기
            FileInputStream fileInputStream = null;
            try{
                // 파일 읽어오기
                fileInputStream = new FileInputStream(file);
                byte[] buffer = new byte[1024];
                int readCount = 0;

                // 파일 쓰기
                while ((readCount = fileInputStream.read(buffer)) != -1){
                    outputStream.write(buffer, 0, readCount);
                    outputStream.flush();
                }
            }catch (Exception e){
                e.getMessage();
            }finally {
                try {
                    fileInputStream.close();
                }catch (Exception ex) {
                    ex.getStackTrace();
                }
            }
        } else{
            printWriter.println("HTTP/1.1 404 NOT FOUND");
            printWriter.println("Content-Type: text/html; charset=UTF-8");
            printWriter.println("");
            printWriter.flush();
        }
    }
}
