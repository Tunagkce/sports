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
@Table(name="course_bundle_distribution")
public class CourseBundleDistribution {
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name="sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name="sequence_name", value = "distributionId_sequence"),
                    @Parameter(name="initial_value",value = "1"),
                    @Parameter(name="increment_size",value = "1")
            })
    private int distributionId;
    @ManyToMany(targetEntity = CourseBundle.class)
    @JoinColumn(name = "id")
    @Column(name = "courseBundleId")
    private Set courseBundleIdSet;
    @ManyToMany(targetEntity = Course.class)
    @JoinColumn(name = "id")
    @Column(name ="courseId")
    private Set courseIdSet;
}
