package com.hello.servlet.web.frontcontroller.v4;

import com.hello.servlet.web.frontcontroller.MyView;
import com.hello.servlet.web.frontcontroller.v4.controller.MemberFormControllerV4;
import com.hello.servlet.web.frontcontroller.v4.controller.MemberListControllerV4;
import com.hello.servlet.web.frontcontroller.v4.controller.MemberSaveControllerV4;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV4", urlPatterns = "/front-controller/v4/*")
public class FrontControllerServletV4 extends HttpServlet {
    //수문장

    private Map<String, ControllerV4> controllerMap = new HashMap<>(); //URI 패턴과 컨트롤러 매핑 정보를 저장하는 맵

    public FrontControllerServletV4() {
        controllerMap.put("/front-controller/v4/members/new-form", new MemberFormControllerV4());
        controllerMap.put("/front-controller/v4/members/save", new MemberSaveControllerV4());
        controllerMap.put("/front-controller/v4/members", new MemberListControllerV4());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI(); //요청 URI를 가져오고

        ControllerV4 controller = controllerMap.get(requestURI); //요청 URI에 맞는 컨트롤러를 찾는다.
        if (controller == null) { //컨트롤러가 없는 경우
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String, String> paramMap = createParamMap(request); //요청 파라미터를 맵으로 변환
        Map<String, Object> model = new HashMap<>(); //v4에서 추가된 코드
        String viewName = controller.process(paramMap, model);

        MyView view = viewResolver(viewName); //뷰 리졸버로 뷰를 담당하는 객체 생성

        view.render(model, request, response); //뷰 렌더링. 흐름을 뷰로 넘어가게 함
    }

    //논리 뷰 이름을 실제 뷰 경로로 변환하는 뷰 리졸버
    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    //요청 파라미터를 맵으로 변환하는 메서드
    private static Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        //forEachRemaining()가 호출될때마다 Iterator의 다음 요소가 paramName에 담긴다. 이렇게 파라미터의 값들을 맵에 넣는다.

        //람다를 쓰지 않고 하는 법(위와 같은 로직)
/*
        Map<String, String> paramMap1 = new HashMap<>();
        Iterator<String> paramNameIterator = request.getParameterNames().asIterator();

        while (paramNameIterator.hasNext()) {
            String paramName = paramNameIterator.next();
            paramMap1.put(paramName, request.getParameter(paramName));
        }
*/

        return paramMap;
    }
}