package com.koicenter.koicenterbackend.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Koi {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "koi_id")
    String koiId;
    String breed;
    int age;
    float length;
    float weight;
    @Column(columnDefinition = "BIT")
    boolean status;
    @Lob
    @Column(name = "notes", columnDefinition = "TEXT")
    String notes;
    String image;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    Customer customer;


    @OneToMany(mappedBy = "koi")
    List<KoiTreatment> koiTreatments;

}
