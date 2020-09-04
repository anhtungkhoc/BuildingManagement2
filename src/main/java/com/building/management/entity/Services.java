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
@Table(name = "DICH_VU")
public class Services {
    @Id
    private String MA_DV;
    private String TEN_DV;
    private String LOAI_DV;
    private float DON_GIA_CS;
}
