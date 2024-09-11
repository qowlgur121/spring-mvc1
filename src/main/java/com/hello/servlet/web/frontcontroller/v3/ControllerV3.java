package com.hello.servlet.web.frontcontroller.v3;

import com.hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {

    //모델과 뷰의 정보를 담당하는 ModelView를 반환한다.
    ModelView process(Map<String, String> paramMap); //v2에서는 MyView를 반환했었는데 v3에서는 ModelView를 반환한다.

}
