package my.examples.was;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class WasConfigManager {
//    public static void main(String[] args) {
//        // 두 객체가 같은 참조인지 확인
////        WasConfigManager wcm1 = WasConfigManager.getInstance();
////        WasConfigManager wcm2 = WasConfigManager.getInstance();
////
////        System.out.println(wcm1 + " | " + wcm2);
//
//    }

    private ObjectMapper objectMapper;

    // 2. 자기 자신을 참조하는 private static변수를 선언한다.
    //    static한 변수는 딱한번 초기화되고, 메모리에 딱 한번만 올라간다.
    private static WasConfigManager instance = new WasConfigManager();

    // 1. private 생성자를 만든다.
    private WasConfigManager(){
        objectMapper = new ObjectMapper();
    }

    // 3. public static 한 메소드를 만든다. instance를 리턴하는...
    public static WasConfigManager getInstance(){
        return instance;
    }

    //파일 읽기
    public MiniWasConfig getMiniWasConfig(String fileName) {
        try {
            MiniWasConfig readObj =
                    objectMapper.readValue(new File(fileName), MiniWasConfig.class);

            return readObj;
        }catch (Exception ex){
            return null;
        }
    }

    public void saveMiniWasConfig(MiniWasConfig miniWasConfig, String fileName)
            throws RuntimeException{
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(fileName), miniWasConfig);
        }catch (Exception ex){
            throw new RuntimeException("파일 저장에 실패");
        }
    }
}



