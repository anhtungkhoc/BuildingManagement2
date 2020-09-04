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
@Table(name = "NHAN_VIEN_TOA")
public class BuildingMember {
    @Id
    private String MA_NV;
    private String TEN;
    private String NS;
    private String DIA_CHI;
    private String SDT;
}
