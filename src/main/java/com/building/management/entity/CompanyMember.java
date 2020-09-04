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
@Table(name = "NHAN_VIEN_CT")
public class CompanyMember {
    @Id
    private String MA_NV;
    private String MA_CT;
    private String TEN;
    private String NGAY_SINH;
    private String CMT;
    private String SDT;
}
