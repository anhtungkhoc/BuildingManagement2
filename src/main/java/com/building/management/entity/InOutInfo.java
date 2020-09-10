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
@Table(name = "THONG_TIN_RA_VAO")
public class InOutInfo {
    @Id
    private int MA_RV;
    private String MA_THE;
    private String MA_NV;
    private String TEN;
    private String VI_TRI;
    private String TRANG_THAI;
    private String CHECK_TIME;
    private double TONG;
}
