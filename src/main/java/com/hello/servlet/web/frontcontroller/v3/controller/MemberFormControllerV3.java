package com.hello.servlet.web.frontcontroller.v3.controller;

import com.hello.servlet.web.frontcontroller.ModelView;
import com.hello.servlet.web.frontcontroller.MyView;
import com.hello.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {

    @Override
    public ModelView process(Map<String, String> paramMap) {
        return new ModelView("new-form"); //뷰의 물리적인 주소가 아닌 논리적 이름만 전달할 수 있게 됨
    }
}
