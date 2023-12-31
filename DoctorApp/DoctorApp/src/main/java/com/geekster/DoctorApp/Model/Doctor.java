package com.geekster.DoctorApp.Model;

import com.geekster.DoctorApp.Model.enums.Qualification;
import com.geekster.DoctorApp.Model.enums.Specialization;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity   // For database

public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;
    private String doctorName;


    private Specialization specialization;

    @Pattern(regexp = "^[0-9]{10}$")
    private String doctorContactNumber;
    @Enumerated(EnumType.STRING)

    private Qualification qualification;

    @Min(value = 200)
    @Max(value = 2000)
    private Double doctorConsultationFee;

    @OneToMany(mappedBy = "doctor")
    List<Appointment> appointmentList;
}
