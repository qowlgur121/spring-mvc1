package com.hello.servlet.web.frontcontroller.v2.controller;

import com.hello.servlet.web.frontcontroller.MyView;
import com.hello.servlet.web.frontcontroller.v2.ControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberFormControllerV2 implements ControllerV2 {

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //여기서는 HttpServletRequest, HttpServletResponse 파라미터가 필요없는데도 저렇게 받는 것이 어색하다. 문제가 있다.

        return new MyView("/WEB-INF/views/new-form.jsp");
        //그런데 만약 new-form.jsp의 위치가 변경되면 이 클래스 뿐만 아니라 다른 컨트롤러도 다 저 위치를 변경해줘야 한다. 문제가 있다.

    }
}
