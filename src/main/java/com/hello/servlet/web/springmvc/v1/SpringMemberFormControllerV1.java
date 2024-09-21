package com.hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //컨포넌트 스캔 대상으로써 스프링 컨테이너에 올라가고, 스프링이 해당 클래스를 컨트롤러로 인식하게 한다. 즉 웹 요청을 처리하는 컨트롤러임을 나타내는 표시
public class SpringMemberFormControllerV1 {
    @RequestMapping("/springmvc/v1/members/new-form") // 지정된 URL 패턴에 대한 요청을 처리. 즉 컨트롤러가 처리할 주소를 알려주는 표지판
    public ModelAndView process() {
        return new ModelAndView("new-form");
    }
}
