package com.hello.servlet.web.frontcontroller.v2;

import com.hello.servlet.web.frontcontroller.MyView;
import com.hello.servlet.web.frontcontroller.v2.controller.MemberFormControllerV2;
import com.hello.servlet.web.frontcontroller.v2.controller.MemberListControllerV2;
import com.hello.servlet.web.frontcontroller.v2.controller.MemberSaveControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {

    private Map<String, ControllerV2> controllerMap = new HashMap<>();

    public FrontControllerServletV2() {
        controllerMap.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
        controllerMap.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
        controllerMap.put("/front-controller/v2/members", new MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI(); //요청 URI를 찾고

        ControllerV2 controller = controllerMap.get(requestURI); //요청 URI에 맞는 컨트롤러 찾는다.
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyView view = controller.process(request, response);  //컨트롤러에게 파라미터 넘겨줘서 뷰에 대한 정보를 얻는다.
        view.render(request, response); //화면을 그린다.
    }
}
