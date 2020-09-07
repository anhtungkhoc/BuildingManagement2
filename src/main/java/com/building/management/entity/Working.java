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
@Table(name = "LAM_VIEC")
public class Working {
    @Id
    private int MA_LV;
    private String MA_DV;
    private String MA_NV;
    private String VI_TRI;
    private float RATE_LUONG;
    private String NGAY_BD;
    private String NGAY_KT;
}
