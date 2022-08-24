package com.ruoyi.system.service;

import com.ruoyi.system.vo.SysMeetingRequestVO;
import com.ruoyi.system.vo.SysMeetingResponseVO;

import java.util.List;

public interface SysMeetingService {
    public int insert(SysMeetingRequestVO meetingRequestVO);

    void update(Long meetingId, SysMeetingRequestVO meeting);

    List<SysMeetingResponseVO> selectMeetings(SysMeetingRequestVO meetingRequestVO);

    SysMeetingResponseVO getDetail(Long meetingId);

    void del(Long meetingId);
}
