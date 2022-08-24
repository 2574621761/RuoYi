package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SysMeeting;
import com.ruoyi.system.vo.SysMeetingRequestVO;
import com.ruoyi.system.vo.SysMeetingResponseVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SysMeetingMapper {
    List<SysMeeting> selectMeetings(SysMeetingRequestVO meetingRequestVO);

    int insert(SysMeetingRequestVO meetingRequestVO);
@Select("select meeting_id as meetingId,meeting_type as meetingType,meeting_title as meetingTitle,meeting_content as meetingContent from sys_meeting where meeting_id =#{meetingId}")
    SysMeeting getDetail(@Param("meetingId") Long meetingId);
@Delete("delete from sys_meeting where meeting_id =#{meetingId}")
void delete(@Param("meetingId")Long meetingId);
}
