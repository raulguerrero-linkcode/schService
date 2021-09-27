package com.schedules.app.service.impl;

import com.schedules.app.models.Schedule;

import com.schedules.app.models.entity.*;
import com.schedules.app.service.ScheduleService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @PersistenceContext
    EntityManager em;


    @Override
    // public ScheduleResponse getSqueduleData(Schedule Schedules) {
    public ScheduleResponse getSqueduleData(Long schedule_id_req) {
            ScheduleResponse scheduleResponse = new ScheduleResponse();


            List<Object[]> yearSchedule = this.em.createNativeQuery("Select year from vp_temp_data.schedules_year where id_s =" + schedule_id_req).getResultList();

            List<Object[]> results = this.em.createNativeQuery("Select * from vp_temp_data.tmp" + yearSchedule.get(0) + " where id_s = " + schedule_id_req, "scheduleMapping").getResultList();

            Optional<Object[]> result = results.stream().findFirst();

            result.stream().forEach((record) -> {
                Schedule schedule = (Schedule) record[0];
                scheduleResponse.setId(schedule.getId());
                scheduleResponse.setLayout_id(schedule.getLayout_id());
                scheduleResponse.setActive(schedule.getActive());
                scheduleResponse.setArrival(schedule.getArrival());
                scheduleResponse.setBlocked(schedule.getBlocked());
                scheduleResponse.setRelease_protex_date(schedule.getRelease_protex_date());
                scheduleResponse.setSale_sep(schedule.getSale_sep());
                scheduleResponse.setActive(schedule.getActive());
                scheduleResponse.setCreation(schedule.getCreation());
            });

            List<Schedule_Detail> response = new ArrayList<Schedule_Detail>();

            results.stream().forEach((record) -> {
                Schedule_Detail schedule_detail = (Schedule_Detail) record[1];
                schedule_detail_source schedule_source_detail = (schedule_detail_source) record[2];
                OperativeSource operativeSource = (OperativeSource) record[3];

                response.add(new Schedule_Detail(schedule_detail.getUnique_schedule_id(),
                        schedule_detail.getParent_schedule_id(),
                        schedule_detail.getRoute_layover_origin_id(),
                        schedule_detail.getRoute_layover_destination_id(),
                        schedule_detail.getDeparture_detail(),
                        schedule_detail.getArrival_detail(),
                        schedule_detail.getActive_detail(),
                        schedule_detail.getCreation_detail(),
                        schedule_source_detail.getSchedule_detail_id(),
                        schedule_source_detail.getOperative_source_id(),
                        schedule_source_detail.getOpen(),
                        schedule_source_detail.getOpen_time(),
                        schedule_source_detail.getClose_time(),
                        operativeSource.getId_os(),
                        operativeSource.getName_en(),
                        operativeSource.getName_es(),
                        operativeSource.getActive_os(),
                        operativeSource.getCreation_os()));

                scheduleResponse.setUnique_detail(response);
            });

        return scheduleResponse;
    }

    public List<ScheduleResponse> getScheduleByDepartureDate() {

        return null;
    }

    @Override
    public List<ScheduleResponse> getRecentSchedule() {
        List<ScheduleResponse> scheduleResponseList = new ArrayList<ScheduleResponse>();

        List<Schedule_query>Schedules_long_query = LongSchedulesDeparture();

        for (int l = 0; l <Schedules_long_query.size(); l++) {

            ScheduleResponse scheduleResponse = new ScheduleResponse();

            Schedule_query schedule_unique_id = Schedules_long_query.get(l);
            List<Object[]> result = this.em.createNativeQuery("Select * from vp_temp_data.last15schedules where id_s =" + schedule_unique_id.getId(), "scheduleMapping").getResultList();


            Optional<Object[]> results = result.stream().findFirst();

            results.stream().forEach((record) -> {
                Schedule schedule = (Schedule) record[0];
                scheduleResponse.setId(schedule.getId());
                scheduleResponse.setLayout_id(schedule.getLayout_id());
                scheduleResponse.setActive(schedule.getActive());
                scheduleResponse.setArrival(schedule.getArrival());
                scheduleResponse.setBlocked(schedule.getBlocked());
                scheduleResponse.setRelease_protex_date(schedule.getRelease_protex_date());
                scheduleResponse.setSale_sep(schedule.getSale_sep());
                scheduleResponse.setActive(schedule.getActive());
                scheduleResponse.setCreation(schedule.getCreation());
            });

            List<Schedule_Detail> response = new ArrayList<Schedule_Detail>();

            result.stream().forEach((record) -> {
                Schedule_Detail schedule_detail = (Schedule_Detail) record[1];
                schedule_detail_source schedule_source_detail = (schedule_detail_source) record[2];
                OperativeSource operativeSource = (OperativeSource) record[3];

                response.add(new Schedule_Detail(schedule_detail.getUnique_schedule_id(),
                        schedule_detail.getParent_schedule_id(),
                        schedule_detail.getRoute_layover_origin_id(),
                        schedule_detail.getRoute_layover_destination_id(),
                        schedule_detail.getDeparture_detail(),
                        schedule_detail.getArrival_detail(),
                        schedule_detail.getActive_detail(),
                        schedule_detail.getCreation_detail(),
                        schedule_source_detail.getSchedule_detail_id(),
                        schedule_source_detail.getOperative_source_id(),
                        schedule_source_detail.getOpen(),
                        schedule_source_detail.getOpen_time(),
                        schedule_source_detail.getClose_time(),
                        operativeSource.getId_os(),
                        operativeSource.getName_en(),
                        operativeSource.getName_es(),
                        operativeSource.getActive_os(),
                        operativeSource.getCreation_os()));

                scheduleResponse.setUnique_detail(response);
            });
            scheduleResponseList.add(scheduleResponse);
        }
        return scheduleResponseList;
    }

    /*
    public List<ScheduleResponse> getScheduleByDepartureDate() {
        List<ScheduleResponse> scheduleResponse = new ArrayList<ScheduleResponse>();


        for (int i = 0; i <Schedules_long_query.size(); i++) {
            Schedule_query schedule = Schedules_long_query.get(i);
            scheduleResponse.add(getSqueduleData(schedule.getId()));
        }
        return scheduleResponse;
    }




    */
    public List<Schedule_query> LongSchedulesDeparture() {
        return this.em.createNativeQuery("Select distinct id_s from vp_temp_data.last15schedules", "scheduleQueryMapping").getResultList();
    };

}
