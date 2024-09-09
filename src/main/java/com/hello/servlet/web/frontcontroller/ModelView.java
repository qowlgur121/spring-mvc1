package com.hello.servlet.web.frontcontroller;

import java.util.HashMap;
import java.util.Map;

public class ModelView {
    //모델과 뷰에 대한 정보를 담당

    private String viewName; //논리적 이름
    private Map<String, Object> model = new HashMap<>(); //뷰에서 사용할 데이터를 저장

    public ModelView(String viewName) {
        this.viewName = viewName;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }
}
