package com.hello.servlet.web.springmvc.v3;

import com.hello.servlet.domain.member.Member;
import com.hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * v3
 * Model 도입
 * ViewName 직접 반환
 * @RequestParam 사용
 * @RequestMapping -> @GetMapping, @PostMapping
 */
@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @GetMapping("/new-form") //v2에서는 RequestMapping 하나로만 처리했던 것을 v3에서는 세분화하여 가독성을 높혔고 또 요청http메서드를 제한시킴.
    public String newForm() { //v2에서는 ModelAndView를 직접 생성해서 반환했는데 v3에선 뷰의 논리적 이름만 반환 -> 코드 간결화
        return "new-form";
    }

    @PostMapping("/save")
    public String save(
            @RequestParam("username") String username, //요청 파라미터인 "username"을 username 변수에 바인딩(연결)
            @RequestParam("age") int age,
            Model model) { //Model 객체를 통해 뷰에 전달할 데이터 추가

        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member); //뷰에 전달할 모델 값을 설정
        return "save-result";
    }

    @GetMapping
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
        return "members";
    }
}
