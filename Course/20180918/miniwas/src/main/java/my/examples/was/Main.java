package my.examples.was;

import java.lang.annotation.Annotation;
import java.util.List;

public class Main {


    public static void main(String[] args) throws Exception {
        Connector connector = new Connector(8888);
        connector.start();
        System.out.println("WAS 서버가 시작되었습니다.");

//        ClassPath들을 출력해준다.
//        MiniWasConfig miniWasConfig = new MiniWasConfig();
//        miniWasConfig.setClassPath(".");
//        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
//        URL[] urls = ((URLClassLoader)classLoader).getURLs();
//
//        for (URL url : urls){
//            System.out.println(url.getFile());
//        }


//        Class[] classes = ClassFinder.getClasses("my.examples.was");
//        for (int i = 0; i < classes.length; i++) {
//            System.out.println(classes[i]);
//            Class class1 = Class.forName(classes[i].toString());
//            Annotation[] annotations = class1.getAnnotations();
//            if (annotations != null && annotations.length > 0) {
//                System.out.println(class1);
//                for (Annotation annotation : annotations) {
//                    System.out.println(annotation.toString());
//                }
//            }
            String baseDir = "/home/jang/Projects/FastCampus_Java/Course/20180918/miniwas/target/classes/";
            ClassFinder classFinder = new ClassFinder(baseDir);
            List<String> allClasses = classFinder.findAllClass();

            for (String classname : allClasses) {
                Class clazz = Class.forName(classname);
                Annotation annotation = clazz.getAnnotation(WebServlet.class);
                if (annotation != null) {
                    WebServlet webServlet = (WebServlet)annotation;
                    String value = webServlet.value();
                    System.out.println(classname + ":" + value);
//                    String[] values = webServlet.value();
//                    for (String value : values) {
//                        System.out.println(classname + ":" + value);
//                    }

                }
        }

    }
}
