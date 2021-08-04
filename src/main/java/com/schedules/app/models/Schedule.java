package com.schedules.app.models;

import com.schedules.app.models.entity.OperativeSource;
import com.schedules.app.models.entity.Schedule_Detail;
import com.schedules.app.models.entity.schedule_detail_source;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@SqlResultSetMapping(
        name = "scheduleMapping",
        entities = {
                @EntityResult(
                        entityClass = Schedule.class,
                        fields = {
                                @FieldResult(name = "id", column = "id_s"),
                                @FieldResult(name = "layout_id", column = "layout_id"),
                                @FieldResult(name = "blocked_user_id", column = "blocked_user_id"),
                                @FieldResult(name = "departure", column = "departure"),
                                @FieldResult(name = "arrival", column = "arrival"),
                                @FieldResult(name = "blocked", column = "blocked"),
                                @FieldResult(name = "release_protex_date", column = "release_protex_date"),
                                @FieldResult(name = "sale_sep", column = "sale_sep"),
                                @FieldResult(name = "active", column = "active"),
                                @FieldResult(name = "creation", column = "creation")
                        }),
                @EntityResult(
                        entityClass = Schedule_Detail.class,
                        fields = {
                                @FieldResult(name = "id", column = "unique_schedule_id"),
                                @FieldResult(name = "parent_schedule_id", column = "parent_schedule_id"),
                                @FieldResult(name = "route_layover_origin_id", column = "route_layover_origin_id"),
                                @FieldResult(name = "route_layover_destination_id", column = "route_layover_destination_id"),
                                @FieldResult(name = "departure_detail", column = "departure_detail"),
                                @FieldResult(name = "arrival_detail", column = "arrival_detail"),
                                @FieldResult(name = "active_detail", column = "active_detail"),
                                @FieldResult(name = "creation_detail", column = "creation_detail"),
                                @FieldResult(name = "schedule_detail_id", column = "schedule_detail_id"),
                                @FieldResult(name = "operative_source_id", column = "operative_source_id"),
                                @FieldResult(name = "open", column = "open"),
                                @FieldResult(name = "open_time", column = "open_time"),
                                @FieldResult(name = "close_time", column = "close_time"),
                                @FieldResult(name = "id_os", column = "id_os"),
                                @FieldResult(name = "name_en", column = "name_en"),
                                @FieldResult(name = "name_es", column = "name_es"),
                                @FieldResult(name = "active_os", column = "active_os"),
                                @FieldResult(name = "creation_os", column = "creation_os")}),
                @EntityResult(
                        entityClass = schedule_detail_source.class,
                        fields = {
                                @FieldResult(name = "schedule_detail_id", column = "schedule_detail_id"),
                                @FieldResult(name = "operative_source_id", column = "operative_source_id"),
                                @FieldResult(name = "open", column = "open"),
                                @FieldResult(name = "open_time", column = "open_time"),
                                @FieldResult(name = "close_time", column = "close_time")}),
                @EntityResult(
                        entityClass = OperativeSource.class,
                        fields = {
                                @FieldResult(name = "id_os", column = "id_os"),
                                @FieldResult(name = "name_en", column = "name_en"),
                                @FieldResult(name = "name_es", column = "name_es"),
                                @FieldResult(name = "active_os", column = "active_os"),
                                @FieldResult(name = "creation_os", column = "creation_os")})})
public class Schedule {

    @Id
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

    // private List<Schedule_Detail> sd;


}
