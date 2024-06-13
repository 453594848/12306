package com.wang.train.member.service;

import com.wang.train.member.req.MemberRegisterReq;

public interface MemberService {

    int count();

    long register(MemberRegisterReq req);
}
