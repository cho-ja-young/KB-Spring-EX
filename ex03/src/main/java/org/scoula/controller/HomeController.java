package org.scoula.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("name", "홍길동");
        return "index"; // view 이름
    }

/*   컨트롤러 메서드에 필요한 객체를 매개 변수로 작성해두면
    Spring Container 가 Argument Resolver 를 이용해서
    1)

 */
}
