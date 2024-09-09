package com.hello.servlet.web.frontcontroller.v2.controller;

import com.hello.servlet.domain.member.Member;
import com.hello.servlet.domain.member.MemberRepository;
import com.hello.servlet.web.frontcontroller.MyView;
import com.hello.servlet.web.frontcontroller.v2.ControllerV2;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberSaveControllerV2 implements ControllerV2 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username"); //폼에서 요청 받은 request파라미터 객체에서 데이터를 꺼낸다.
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member); //이렇게 MemberRepository에 member를 넣으면 나중에 리스트를 쭉 보고 싶을때 members로 다 뽑을 수 있다.

        //Model에 데이터를 보관한다.
        request.setAttribute("member", member); //save-result.jsp에서 member객체를 사용할 수 있게 request 파라미터에 저장

        return new MyView("/WEB-INF/views/save-result.jsp"); //화면을 담당하는 객체를 프론트 컨트롤러에게 전달한다.
    }
}
