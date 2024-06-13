package com.wang.train.member.service.impl;

import com.wang.train.member.mapper.MemberMapper;
import com.wang.train.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
