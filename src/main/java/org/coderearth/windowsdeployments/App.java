package org.coderearth.windowsdeployments;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * App
 */
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        new SpringApplicationBuilder(AppConfig.class).bannerMode(Banner.Mode.OFF).logStartupInfo(false)
                .registerShutdownHook(true).run(args);
    }

}