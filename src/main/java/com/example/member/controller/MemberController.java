package com.example.member.controller;

import com.example.member.domain.Member;
import com.example.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    @Autowired
    private final MemberService memberService;

    public MemberController(MemberService memberService) {

        this.memberService = memberService;
    }

    @GetMapping("/")
    public String home() {

        return "home";
    }

    @GetMapping("/members/create")
    public String create() {

        return "create";
    }

    @PostMapping("/members/create")
    public String createPro(Member member) {
        memberService.create(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);

        return "members";
    }
}
