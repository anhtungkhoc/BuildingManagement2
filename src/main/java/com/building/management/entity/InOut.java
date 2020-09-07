package com.building.management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RA_VAO")
public class InOut {
    @Id
    private String MA_RV;
    private String MA_THE;
    private String VI_TRI;
    private String TRANG_THAI;
    private String CHECK_TIME;
}
