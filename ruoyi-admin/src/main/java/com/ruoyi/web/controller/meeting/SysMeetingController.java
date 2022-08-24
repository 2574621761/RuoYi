package com.ruoyi.web.controller.meeting;

import com.alibaba.fastjson.JSON;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.service.SysMeetingService;
import com.ruoyi.system.vo.SysMeetingRequestVO;
import com.ruoyi.system.vo.SysMeetingResponseVO;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: RuoYi-Vue-master
 * @description:
 * @author: yqy
 * @create: 2022-05-11 15:53
 **/
@RequestMapping(value = "/system/meeting")
@ApiOperation(value = "会议管理接口")
@RestController
@Slf4j
public class SysMeetingController extends BaseController {
    @Autowired
    private SysMeetingService meetingService;
    @PreAuthorize("@ss.hasPermi('system:meeting:list')")
    @ApiOperation(value = "会议列表")
    @GetMapping(value = "get/list")
    public TableDataInfo list(SysMeetingRequestVO meetingRequestVO){
        startPage();
        List<SysMeetingResponseVO> list = meetingService.selectMeetings(meetingRequestVO);
        logger.warn(JSON.toJSONString(list));
        return getDataTable(list);
    }
    /**
     * 新增会议
     */
    @PreAuthorize("@ss.hasPermi('system:meeting:add')")
    @Log(title = "会议管理", businessType = BusinessType.INSERT)
    @PostMapping(value="add")
    public AjaxResult add(@Validated @RequestBody SysMeetingRequestVO meeting) {
        meeting.setCreateBy(getUsername());
        return AjaxResult.success(meetingService.insert(meeting));
    }
    /**
     * 新增会议
     */
    @PreAuthorize("@ss.hasPermi('system:meeting:update')")
    @Log(title = "会议管理", businessType = BusinessType.UPDATE)
    @PostMapping(value="update")
    public AjaxResult update(@RequestParam("meetingId")Long meetingId,@Validated @RequestBody SysMeetingRequestVO meeting) {
        meetingService.update(meetingId,meeting);
        return AjaxResult.success();
    }
    @ApiOperation(value = "会议详情")
    @GetMapping(value="/getDetail")
    public AjaxResult getDetail(@RequestParam("meetingId")Long meetingId){
        return AjaxResult.success(meetingService.getDetail(meetingId));
    }
    @PreAuthorize("@ss.hasPermi('system:meeting:delete')")
    @Log(title = "会议管理", businessType = BusinessType.DELETE)
    @PostMapping(value="del")
    public AjaxResult del(@RequestParam("meetingId")Long meetingId) {
        meetingService.del(meetingId);
        return AjaxResult.success();
    }
}
