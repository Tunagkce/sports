package com.example.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseBundle {
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name="sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name="sequence_name", value = "courseBundle_sequence"),
                    @Parameter(name="initial_value",value = "1"),
                    @Parameter(name="increment_size",value = "1")
            })
    @ManyToMany(targetEntity = UserCourseBundleDistribution.class)
    @JoinColumn(name="courseBundleId")
    @Column(name="id")
    private Set courseBundleIdSet;
}
