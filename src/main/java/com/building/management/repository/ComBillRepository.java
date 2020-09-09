package com.building.management.repository;

import com.building.management.entity.CompanyBill;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ComBillRepository extends CrudRepository<CompanyBill, String> {
    @Query(value = "SELECT SD.MA_DK, SD.MA_CT, CT.TEN_CT, DV.TEN_DV,IF(? < SD.NGAY_BD,SD.NGAY_BD,SD.NGAY_BD) AS NGAY_BD,IF(? > SD.NGAY_KT,SD.NGAY_KT,SD.NGAY_KT) AS NGAY_KT, DV.DON_GIA_CS,(CT.DIEN_TICH*300000) AS MAT_BANG,\n" +
            "CASE\n" +
            "    WHEN CT.SO_NV > 10 AND CT.DIEN_TICH > 100 THEN (NGAY_KT - NGAY_BD)*DV.DON_GIA_CS*(1 + (FLOOR((CT.SO_NV - 10)/5) + FLOOR((CT.DIEN_TICH - 100)/10))*0.05)\n" +
            "    WHEN CT.SO_NV > 10 THEN (NGAY_KT - NGAY_BD)*DV.DON_GIA_CS*(1 + (FLOOR((CT.SO_NV - 10)/5))*0.05)\n" +
            "    WHEN CT.DIEN_TICH > 100 THEN (NGAY_KT - NGAY_BD)*DV.DON_GIA_CS*(1 + (FLOOR((CT.DIEN_TICH - 100)/10))*0.05)\n" +
            "    ELSE (NGAY_KT - NGAY_BD)*DV.DON_GIA_CS\n" +
            "END AS THUC_TRA\n" +
            "FROM CONG_TY AS CT, dich_vu AS DV, SU_DUNG AS SD\n" +
            "WHERE CT.MA_CT = SD.MA_CT\n" +
            "AND DV.MA_DV = SD.MA_DV\n" +
            "AND SD.MA_CT = ?", nativeQuery = true)
    List<CompanyBill> getCompanyBillByDate(String ngayBD, String ngayKT, String mact);

}
