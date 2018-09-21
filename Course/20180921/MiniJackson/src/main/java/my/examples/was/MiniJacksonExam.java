package my.examples.was;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;

public class MiniJacksonExam {
    public static void main(String[] args) throws Exception {
        MiniWasConfig miniWasConfig = new MiniWasConfig();
        miniWasConfig.setStaticDir("/home/jang/Projects/FastCampus_Java/Course/20180921/MiniJackson/src/main/java/my/examples/was");
        miniWasConfig.setClassPath(".");

        //객체를 json 메시지로 변환한다. (직렬화한다.)
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonConfig = objectMapper.writeValueAsString(miniWasConfig);
        System.out.println(jsonConfig);

        // 파일로 저장하기
        File file = new File(miniWasConfig.getStaticDir() + "/test.json");
        System.out.println("Write to : " + file.getAbsolutePath());
        objectMapper.writeValue(file, miniWasConfig);


        //역 직렬화
        String jsonData = "{\"staticDir\":\"/home/jang/Projects/FastCampus_Java/Course/20180921/MiniJackson/src/main/java/my/examples/was\",\"classPath\":\".\"}";
        MiniWasConfig readObj = objectMapper.readValue(jsonData, MiniWasConfig.class);
        System.out.println(readObj.getClassPath());
        System.out.println(readObj.getStaticDir());

        // 파일로부터 읽어오기
        MiniWasConfig readObj2 = objectMapper.readValue(file, MiniWasConfig.class);
        System.out.println("readObj2 reads file");
        System.out.println(readObj2.getStaticDir() + readObj2.getClassPath());
    }
}
