package examples.boot.springboard.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
//public class WebConfig extends WebMvcConfigurerAdapter {
public class WebConfig implements WebMvcConfigurer {
//    @Autowired
//    Environment environment;

    @Bean
    public ServerInfo serverInfo() {
        ServerInfo serverInfo = new ServerInfo();
//        serverInfo.setIp(environment.getProperty("serverinfo.ip"));
//        serverInfo.setPort(Integer.parseInt(environment.getProperty("serverinfo.port")));
        return serverInfo;
    }
}
