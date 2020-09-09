package com.building.management.repository;//package testJDBC;
//
//import java.sql.*;
//
//public class JDBCConnect {
//    public static void connect (){
//        String sql = "SELECT SD.MA_DK, SD.MA_CT, CT.TEN_CT, DV.TEN_DV,IF(? < SD.NGAY_BD,0,SD.NGAY_BD) AS NGAY_BD,IF(? > SD.NGAY_KT,0,SD.NGAY_KT) AS NGAY_KT, DV.DON_GIA_CS,\n" +
//                "CASE\n" +
//                "    WHEN CT.SO_NV > 10 AND CT.DIEN_TICH > 100 THEN DV.DON_GIA_CS*(1 + (FLOOR((CT.SO_NV - 10)/5) + FLOOR((CT.DIEN_TICH - 100)/10))*0.05)\n" +
//                "    WHEN CT.SO_NV > 10 THEN DV.DON_GIA_CS*(1 + (FLOOR((CT.SO_NV - 10)/5))*0.05)\n" +
//                "    WHEN CT.DIEN_TICH > 100 THEN DV.DON_GIA_CS*(1 + (FLOOR((CT.DIEN_TICH - 100)/10))*0.05)\n" +
//                "    ELSE DV.DON_GIA_CS\n" +
//                "END AS THUC_TRA\n" +
//                "FROM CONG_TY AS CT, dich_vu AS DV, SU_DUNG AS SD\n" +
//                "WHERE CT.MA_CT = SD.MA_CT\n" +
//                "AND DV.MA_DV = SD.MA_DV;";
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            String url = "jdbc:mysql://localhost/qltoanha?autoReconnect=true&useSSL=false&characterEncoding=utf8&useUnicode=true&serverTimezone=UTC";
//            String user = "root";
//            String pass = "123456";
//            Connection con = DriverManager.getConnection(url,user,pass);
//            Statement stmt=con.createStatement();
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1,"2020-09-15");
//            ps.setString(2,"2021-09-0");
//            ResultSet rs=ps.executeQuery();
//            while(rs.next())
//                System.out.println(rs.getString(1)+" - "+rs.getString(2)+" - "+rs.getString(3)+" - "+rs.getString(4)
//                        +" - "+rs.getString(5)+" - "+rs.getString(6)+" - "+rs.getString(7)+" - "+rs.getString(8));
//            con.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//
//    public static void main(String[] args) {
//        connect();
//    }
//
//}
