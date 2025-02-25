package ufjf.dcc061.payroll_pro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({ "/", "/home" })
    public String home() {
        return "home";
    }
}
