package com.ruoyi.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.ruoyi.system.domain.SysMeeting;
import com.ruoyi.system.mapper.SysMeetingMapper;
import com.ruoyi.system.service.SysMeetingService;
import com.ruoyi.system.vo.SysMeetingRequestVO;
import com.ruoyi.system.vo.SysMeetingResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: RuoYi-Vue-master
 * @description:
 * @author: yqy
 * @create: 2022-05-11 15:06
 **/
@Service
@Slf4j
public class SysMeetingServiceImpl implements SysMeetingService {
    @Autowired
    private SysMeetingMapper meetingMapper;
    @Override
    public int insert(SysMeetingRequestVO meetingRequestVO) {

        return meetingMapper.insert(meetingRequestVO);
    }

    @Override
    public void update(Long meetingId, SysMeetingRequestVO meeting) {

    }

    @Override
    public List<SysMeetingResponseVO> selectMeetings(SysMeetingRequestVO meetingRequestVO) {
        List<SysMeeting> meetings=meetingMapper.selectMeetings(meetingRequestVO);
        List<SysMeetingResponseVO> meetingResponseVOS=new ArrayList<>();
        for(SysMeeting meeting:meetings){
            log.warn(JSON.toJSONString(meeting));
            SysMeetingResponseVO meetingResponseVO=new SysMeetingResponseVO();
            BeanUtils.copyProperties(meeting,meetingResponseVO);
            meetingResponseVOS.add(meetingResponseVO);
        }
        return meetingResponseVOS;
    }

    @Override
    public SysMeetingResponseVO getDetail(Long meetingId) {
        SysMeeting sysMeeting=meetingMapper.getDetail(meetingId);
        SysMeetingResponseVO meetingResponseVO=new SysMeetingResponseVO();
        BeanUtils.copyProperties(sysMeeting,meetingResponseVO);
        log.warn(JSON.toJSONString(sysMeeting));
        return meetingResponseVO;
    }

    @Override
    public void del(Long meetingId) {
        meetingMapper.delete(meetingId);
    }
}
