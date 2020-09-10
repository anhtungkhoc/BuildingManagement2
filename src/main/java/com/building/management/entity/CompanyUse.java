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
@Table(name = "SU_DUNG")
public class CompanyUse {
    @Id
    private int MA_DK;
    private String MA_CT;
    private String MA_DV;
    private String NGAY_BD;
    private String NGAY_KT;
}
