package com.building.management.repository;


import com.building.management.entity.ComMemSalary;
import com.building.management.entity.CompanyMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface ComMemSalRepository extends JpaRepository<ComMemSalary, String> {
    @Query(value = "SELECT DISTINCT LV.MA_LV,LV.MA_NV , LV.MA_DV,IF (:ngay_BD < LV.NGAY_BD, LV.NGAY_BD, :ngay_BD) AS NGAY_BD, IF (:ngay_KT > LV.NGAY_KT, LV.NGAY_KT, :ngay_KT) AS NGAY_KT,\n" +
            "    DATEDIFF(IF (:ngay_KT > LV.NGAY_KT, LV.NGAY_KT, :ngay_KT),IF (:ngay_BD < LV.NGAY_BD, LV.NGAY_BD, :ngay_BD)) AS SO_NGAY,\n" +
            "    (DATEDIFF(IF (:ngay_KT > LV.NGAY_KT, LV.NGAY_KT, :ngay_KT), IF (:ngay_BD < LV.NGAY_BD, LV.NGAY_BD, :ngay_BD))*LV.RATE_LUONG) AS LUONG,\n" +
            "    (HD.THUC_TRA/HD.DON_GIA_CS) AS PT,\n" +
            "    (DATEDIFF(IF (:ngay_KT > LV.NGAY_KT, LV.NGAY_KT, :ngay_KT), IF (:ngay_BD < LV.NGAY_BD, LV.NGAY_BD, :ngay_BD))*LV.RATE_LUONG)*(HD.THUC_TRA/HD.DON_GIA_CS) AS LUONG_THUC_TRA\n" +
            "FROM LAM_VIEC AS LV, HOA_DON_CTY AS HD, NHAN_VIEN_TOA AS NV, DICH_VU AS DV\n" +
            "WHERE LV.MA_NV = NV.MA_NV\n" +
            "  AND DV.MA_DV = LV.MA_DV\n" +
            "  AND LV.MA_DV = HD.MA_DV\n" +
            "  AND LV.NGAY_BD < :ngay_KT\n" +
            "  AND :ngay_BD < LV.NGAY_KT\n" +
            "  AND LV.MA_NV = :maNV", nativeQuery = true)
    List<ComMemSalary> getCompanyMemberByDate(@Param("ngay_BD") String ngayBD, @Param("ngay_KT") String ngayBKT, @Param("maNV") String maNV);



}