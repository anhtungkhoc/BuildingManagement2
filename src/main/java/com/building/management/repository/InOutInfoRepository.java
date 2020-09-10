package com.building.management.repository;

import com.building.management.entity.InOutInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InOutInfoRepository extends CrudRepository<InOutInfo, Integer> {
    @Query(value = "SELECT RV.MA_RV,RV.MA_THE, NV.MA_NV, NV.TEN, RV.VI_TRI, RV.TRANG_THAI, RV.CHECK_TIME, COUNT(RV.MA_RV) AS TONG\n" +
            "    FROM RA_VAO AS RV, THE_RA_VAO AS TR, NHAN_VIEN_CT AS NV\n" +
            "    WHERE RV.MA_THE = TR.MA_THE AND TR.MA_NV = NV.MA_NV AND DATE(RV.CHECK_TIME) = DATE(:checkTime) AND NV.MA_NV = :maNV\n" +
            "    GROUP BY RV.MA_THE,RV.VI_TRI,RV.TRANG_THAI", nativeQuery = true)
    List<InOutInfo> getInOutInfoByCHECK_TIMEAndMA_NV(@Param("checkTime") String checkTime,@Param("maNV") String maNV);

}
