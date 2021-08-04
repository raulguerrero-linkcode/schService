package com.schedules.app.models.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Setter
@Getter
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class schedule_detail_source {

    @Id
    private Long schedule_detail_id;

    private int operative_source_id;

    private byte open;

    private Date open_time;

    private Date close_time;

    public schedule_detail_source(Long schedule_detail_id, int operative_source_id, byte open, Date open_time, Date close_time, com.schedules.app.models.entity.OperativeSource operativeSource) {
    }

}
