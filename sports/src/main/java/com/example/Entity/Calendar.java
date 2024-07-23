package com.example.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.sql.Time;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Calendar {

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name="sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name="sequence_name", value = "calendar_sequence"),
                    @Parameter(name="initial_value",value = "1"),
                    @Parameter(name="increment_size",value = "1")
            })
    private int calendarId;
    @ManyToMany(targetEntity = User.class)
    @JoinColumn(name = "userId")
    @Column(name="memberId")
    private Set memberIdSet;
    @ManyToMany(targetEntity = Course.class)
    @JoinColumn(name = "id")
    @Column(name="courseId")
    private Set courseIdSet;
    private Time scheduleDate;
}
