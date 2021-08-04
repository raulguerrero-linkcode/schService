package com.schedules.app.models.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@SqlResultSetMapping(
        name = "scheduleQueryMapping",
        entities = {
                @EntityResult(
                        entityClass = com.schedules.app.models.entity.Schedule_query.class,
                        fields = {
                                @FieldResult(name = "id", column = "id_s")})})
public class Schedule_query {

    @Id
    private Long id;
}
