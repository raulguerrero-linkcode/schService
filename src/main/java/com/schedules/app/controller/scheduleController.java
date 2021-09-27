package com.schedules.app.controller;

import com.schedules.app.models.Schedule;
import com.schedules.app.models.entity.ScheduleResponse;
import com.schedules.app.service.impl.ScheduleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path="/schedule")
public class scheduleController {

    @Autowired
    private ScheduleServiceImpl scheduleService;

    @GetMapping
    public @ResponseBody List<ScheduleResponse> getSchedule(@RequestBody ArrayList<Long> esqReq) {
        List<ScheduleResponse> sqRes = new ArrayList<ScheduleResponse>();

        for (int i = 0 ; i<esqReq.size(); i++) {
            sqRes.add(scheduleService.getSqueduleData(esqReq.get(i)));
        }
        return sqRes;

    }

    @GetMapping("/recentSchedules")
    public @ResponseBody List<ScheduleResponse> getScheduleArrivalLastMonth() {
        //List<ScheduleResponse> sqRes = new ArrayList<ScheduleResponse>();
        //sqRes.add();
        return scheduleService.getRecentSchedule();
    }


}
