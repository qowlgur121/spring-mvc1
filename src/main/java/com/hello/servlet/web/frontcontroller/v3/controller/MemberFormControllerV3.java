package com.hello.servlet.web.frontcontroller.v3.controller;

import com.hello.servlet.web.frontcontroller.ModelView;
import com.hello.servlet.web.frontcontroller.MyView;
import com.hello.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {

    @Override
    public ModelView process(Map<String, String> paramMap) { //v2에서는 HttpServletRequest이런 파라미터를 무조건 받아야했는데 이제는 없어도 가능.
        return new ModelView("new-form"); //뷰의 물리적인 주소가 아닌 논리적 이름만 전달할 수 있게 됨
    }
}
