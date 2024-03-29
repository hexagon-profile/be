package com.example.hexagon.member.service;

import com.example.hexagon.member.dto.Member;
import com.example.hexagon.member.repository.MemberMapper;
import com.example.hexagon.member.repository.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberMapper memberMapper;
    private final MemberJpaRepository memberRepository;

    public List<Member> getAllMember() {
//        return memberRepository.findAll();
        return memberMapper.getAllMember();
    }

    public Optional<Member> getMember(String id) {
//        return memberRepository.findMemberByMemberId(Long.parseLong(id));
        return memberMapper.getMemberById(id);
    }

    public Integer createMember(Member member) {
//        memberRepository.save(member);
//        return 1;
        return memberMapper.insertMember(member);
    }
}
