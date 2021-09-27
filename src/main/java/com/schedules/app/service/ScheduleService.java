package com.schedules.app.service;

import com.schedules.app.models.Schedule;
import com.schedules.app.models.entity.ScheduleResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ScheduleService {

    /*
       Get data from 1 or more schedules_id
       This will be return all the details of each schedules

       Input:  an array of SchedulesId   ex. [1367,1368,139]

       Response:
               [
                    {
                    "id": 1367,
                    "layout_id": 1,
                    "blocked_user_id": null,
                    "departure": null,
                    "arrival": "2020-12-04",
                    "blocked": 0,
                    "release_protex_date": null,
                    "sale_sep": 1,
                    "active": 1,
                    "creation": "2020-12-04",
                    "unique_detail": [...]
                    }
                ]
     */
    ScheduleResponse getSqueduleData(Long schedule_id_req);


    /*
        Get Schedules_id from departure date of the last month

     */
    List<ScheduleResponse> getScheduleByDepartureDate();


    /*
        Get Schedules_id from last 30 days of creation

     */
    List<ScheduleResponse> getRecentSchedule();



}
