package com.schedules.app.models.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleResponse {

    private Long id;

    private int layout_id;

    private String blocked_user_id=null;

    @Temporal(TemporalType.DATE)
    private Date departure;

    @Temporal(TemporalType.DATE)
    private Date arrival;

    private byte blocked;

    private String release_protex_date=null;

    private byte sale_sep;

    private byte active;

    @Temporal(TemporalType.DATE)
    private Date creation;

    private List<Schedule_Detail> unique_detail;

}
