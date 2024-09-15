package com.hello.servlet.web.springmvc.old;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * @Component("/springmvc/old-controller")은
 * 스프링 컨테이너에 등록.
 * 이 컨트롤러가 처리할 URL("/springmvc/old-controller")을 스프링에게 알려준다.
 */
@Component("/springmvc/old-controller")
public class OldController implements Controller { //Controller를 상속해서 OldController을 Spring MVC의 컨트롤러로 설정함
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");

        return new ModelAndView("new-form");
    }
}
