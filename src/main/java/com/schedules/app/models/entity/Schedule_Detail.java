package com.schedules.app.models.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public
class Schedule_Detail{




    public Schedule_Detail(
            Long unique_schedule_id,
            Long parent_schedule_id1, int route_layover_origin_id, int route_layover_destination_id, Date departure_detail, Date arrival_detail, byte active_detail, Date creation_detail, schedule_detail_source schedule_detail_source) {
    }

    /*
        This Long is for schedule_id for schedule_detail_source
        will rename as Unique_id
     */
    @Id
    @Column(name="unique_schedule_id")
    private Long unique_schedule_id;

    @Column(name = "parent_schedule_id")
    private Long parent_schedule_id;

    private int route_layover_origin_id;

    private int route_layover_destination_id;

    @Column(name="departure_detail")
    private Date departure_detail;

    @Column(name="arrival_detail")
    private Date arrival_detail;

    @Column(name="active_detail")
    private byte active_detail;



    @Column(name = "creation_detail")
    private Date creation_detail;

    /*
        Schedule detail source

     */

    private Long schedule_detail_id;

    private int operative_source_id;

    private byte open;

    private Date open_time;

    private Date close_time;

/*
    Operative source

 */

    private int id_os;

    private String name_en;

    private String name_es;

    private int active_os;

    @Temporal(TemporalType.DATE)
    private Date creation_os;


}
