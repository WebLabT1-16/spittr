package cat.tecnocampus.spittr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by roure on 19/07/2016.
 */
@Configuration
@ComponentScan (basePackages = {"cat.tecnocampus.spittr"},
    excludeFilters = @Filter(type= FilterType.ANNOTATION, value= EnableWebMvc.class))
public class RootConfig {
}
