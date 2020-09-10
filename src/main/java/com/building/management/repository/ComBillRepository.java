package com.building.management.repository;

import com.building.management.entity.CompanyBill;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComBillRepository extends CrudRepository<CompanyBill, String> {
    @Query(value = "SELECT SD.MA_DK,SD.MA_CT,CT.TEN_CT,DV.TEN_DV,IF (:ngayBD < SD.NGAY_BD, SD.NGAY_BD, :ngayBD) AS NGAY_BD, IF (:ngayKT > SD.NGAY_KT, SD.NGAY_KT, :ngayKT) AS NGAY_KT, DV.DON_GIA_CS, (CT.DIEN_TICH*300000) AS MAT_BANG, DATEDIFF(IF (:ngayKT > SD.NGAY_KT, SD.NGAY_KT, :ngayKT), IF (:ngayBD < SD.NGAY_BD, SD.NGAY_BD, :ngayBD)) AS SO_NGAY,\n" +
            "    CASE\n" +
            "    WHEN CT.SO_NV > 10 AND CT.DIEN_TICH > 100 THEN DV.DON_GIA_CS*(1 + (FLOOR((CT.SO_NV - 10)/5) + FLOOR((CT.DIEN_TICH - 100)/10))*0.05)\n" +
            "    WHEN CT.SO_NV > 10 THEN DV.DON_GIA_CS*(1 + (FLOOR((CT.SO_NV - 10)/5))*0.05)\n" +
            "    WHEN CT.DIEN_TICH > 100 THEN DV.DON_GIA_CS*(1 + (FLOOR((CT.DIEN_TICH - 100)/10))*0.05)\n" +
            "    ELSE DV.DON_GIA_CS\n" +
            "    END AS THUC_TRA\n" +
            "FROM CONG_TY AS CT, dich_vu AS DV, SU_DUNG AS SD\n" +
            "WHERE CT.MA_CT = SD.MA_CT\n" +
            "  AND DV.MA_DV = SD.MA_DV\n" +
            "  AND SD.NGAY_BD < :ngayKT\n" +
            "  AND :ngayBD < SD.NGAY_KT\n" +
            "  AND SD.MA_CT = :maCT\n" +
            "ORDER BY THUC_TRA", nativeQuery = true)
    List<CompanyBill> getCompanyBillByDate(@Param("ngayBD") String ngayBD,@Param("ngayKT") String ngayKT,@Param("maCT") String maCT);

}
