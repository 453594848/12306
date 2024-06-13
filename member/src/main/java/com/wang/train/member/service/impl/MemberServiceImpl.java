package com.wang.train.member.service.impl;

import com.wang.train.member.domain.Member;
import com.wang.train.member.domain.MemberExample;
import com.wang.train.member.mapper.MemberMapper;
import com.wang.train.member.req.MemberRegisterReq;
import com.wang.train.member.service.MemberService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;

    public MemberServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }
    @Override
    public int count() {
        return Math.toIntExact(memberMapper.countByExample(null));
    }

    @Override
    public long register(MemberRegisterReq req) {
        String mobile = req.getMobile();
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andIdEqualTo(Long.valueOf(mobile));
        List<Member> members = memberMapper.selectByExample(memberExample);
        if (!members.isEmpty()){
            throw new RuntimeException("手机号已注册");
        }

        Member member = new Member();
        member.setId(System.currentTimeMillis());
        member.setMobile(mobile);
        return memberMapper.insert(member);

    }

}
