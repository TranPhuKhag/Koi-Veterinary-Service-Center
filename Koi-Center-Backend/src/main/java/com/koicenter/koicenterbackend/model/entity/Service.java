package com.koicenter.koicenterbackend.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.koicenter.koicenterbackend.model.enums.ServiceType;
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
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "service_id")
    String serviceId;
    @Column(name = "service_name")
    String serviceName;
    @Lob
    @Column(name = "description", columnDefinition = "TEXT")
    String description;
    @Column(name = "base_price")
    float basePrice;
    @Column(name = "pond_price")
    float pondPrice;
    @Column(name = "koi_price")
    float koiPrice;
    @Enumerated(EnumType.STRING)
            @Column(name = "service_for")
    ServiceType serviceFor;
    String image;
    boolean status;

    @OneToMany(mappedBy = "service")
    List<Appointment> appointments;

    @ManyToMany
    @JoinTable(
            name = "veterinarian_service",
            joinColumns = @JoinColumn(name = "service_id"),
            inverseJoinColumns = @JoinColumn(name = "vet_id")
    )
    List<Veterinarian> veterinarians;
}
