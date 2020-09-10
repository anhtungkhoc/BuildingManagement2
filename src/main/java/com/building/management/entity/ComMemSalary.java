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
@Table(name = "LUONG_NV_TOA")
public class ComMemSalary {
    @Id
    private String MA_LV;
    private String MA_NV;
    private String MA_DV;
    private String NGAY_BD;
    private String NGAY_KT;
    private String SO_NGAY;
    private float LUONG;
    private float PT;
    private float LUONG_THUC_TRA;
}
