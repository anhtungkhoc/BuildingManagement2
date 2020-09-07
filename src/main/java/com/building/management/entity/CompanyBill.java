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
@Table(name = "HOA_DON_CTY")
public class CompanyBill {
    @Id
    private String MA_DK;
    private String MA_CT;
    private String TEN_CT;
    private String TEN_DV;
    private String NGAY_BD;
    private String NGAY_KT;
    private float DON_GIA_CS;
    private double MAT_BANG;
    private double THUC_TRA;
}
