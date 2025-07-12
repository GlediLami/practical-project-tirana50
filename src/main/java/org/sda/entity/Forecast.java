package org.sda.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Entity
@Table(name = "forecast")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Forecast {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private OffsetDateTime date;

    private double minTemp;

    private double maxTemp;

    private String cityId;
}