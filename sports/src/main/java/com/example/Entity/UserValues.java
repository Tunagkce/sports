package com.example.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserValues {
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name="sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name="sequence_name", value = "userValues_sequence"),
                    @Parameter(name="initial_value",value = "1"),
                    @Parameter(name="increment_size",value = "1")
            })
    private int userValueId;

    @OneToMany(targetEntity = User.class)
    @JoinColumn(name="userId")
    @Column(name = "userId")
    private List userList;
    private String shortCode;
    private String value;
}
