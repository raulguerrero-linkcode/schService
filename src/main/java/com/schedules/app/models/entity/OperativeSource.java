package com.schedules.app.models.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Setter
@Getter
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OperativeSource {

    @Id
    private int id_os;

    private String name_en;

    private String name_es;

    private int active_os;

    @Temporal(TemporalType.DATE)
    private Date creation_os;



}
