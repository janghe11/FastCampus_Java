package my.examples.was;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebServletMapperManager {
    public Map<String, Class> findServlet(String baseDir) {
        Map<String, Class> map = new HashMap<>();

        ClassFinder classFinder = new ClassFinder(baseDir);
        List<String> classList = classFinder.findAllClass();

        for (String className : classList) {
            try {
                Class clazz = Class.forName(className);
                Annotation annotation = clazz.getAnnotation(WebServlet.class);
            }catch (ClassNotFoundException ex) {

            }
        }

        return map;
    }
}
