package cat.tecnocampus.spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by roure on 19/07/2016.
 */
@Controller
@RequestMapping({"/", "homepage"})
public class HomeController {
    @RequestMapping(method=GET)
    public String home() {
        return "home";
    }
}
