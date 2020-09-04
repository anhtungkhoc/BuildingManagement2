DROP DATABASE IF EXISTS qltoanha;
CREATE DATABASE IF NOT EXISTS qltoanha;
USE qltoanha;

CREATE TABLE NVTN(
    MaNVTN varchar(50) not null,
    Ten varchar(50) ,
    NS date,
    DiaChi varchar(100),
    SDT varchar(10),
    Luong float,
    PRIMARY KEY (MaNVTN)
);

CREATE TABLE CongTy(
    MaCT varchar(50) not null,
    TenCT varchar(50),
    MST varchar(50),
    LinhVuc varchar(50),
    DiaChi varchar(50),
    SDT varchar(10),
    SoNV float,
    DienTich float,
    PRIMARY KEY (MaCT)
);

CREATE TABLE DichVu(
    MaDV varchar(50) not null,
    TenDV varchar(50) not null,
    LoaiDV varchar(50),
    DonGiaCS float,
    PRIMARY KEY (MaDV)
);

CREATE TABLE NVCT(
    MaNVCT varchar(50) not null,
    MaCT VARCHAR(50) NOT NULL,
    Ten varchar(50) not null,
    NS date,
    CMT varchar(100),
    SDT varchar(10),
    PRIMARY KEY (MaNVCT),
    FOREIGN KEY (MaCT) REFERENCES CongTy(MaCT)
);

CREATE TABLE THE(
    MaThe varchar(50) not null,
    MaNVCT varchar(50) not null,
    PRIMARY KEY (MaThe),
    FOREIGN KEY (MaNVCT) REFERENCES NVCT(MaNVCT)
);

CREATE TABLE LamViec(
    MaLV varchar(50) not null,
    MaDV varchar(50) not null,
    MANVTN varchar(50) not null,
    ViTri varchar(50) not null,
    MucLuong varchar(50) not null,
    NgayBD date not null,
    NgayKT date not null,
    PRIMARY KEY (MaLV),
    FOREIGN KEY (MaDV) REFERENCES DichVu(MaDV),
    FOREIGN KEY (MANVTN) REFERENCES NVTN(MaNVTN)
);

CREATE TABLE Sudung(
    MaCT varchar(50) not null,
    MaDV varchar(50) not null,
    NgayBD date,
    NgayKT date,
    DonGiaRieng int,
    PRIMARY KEY (MaCT, MaDV),
    FOREIGN KEY (MaCT) REFERENCES CongTy(MaCT),
    FOREIGN KEY (MaDV) REFERENCES DichVu(MaDV)
);

CREATE TABLE RaVao(
    MaRV varchar(50) not null,
    MaThe varchar(50) not null,
    ViTri varchar(50) not null,
    TrangThai varchar(20) not null,
    CheckTime datetime not null,
    PRIMARY KEY (MaRV, MaThe),
    FOREIGN KEY (MaThe) REFERENCES THE(MaThe)
);

#Trigger tao default dich vu: Bao ve + Ve sinh
DELIMITER //
create trigger DV_DEFAULT after INSERT ON congty FOR EACH ROW
    BEGIN
		
        insert into Sudung values (new.MaCT,'DV01',null,null,null);
        insert into Sudung values (new.MaCT,'DV02',null,null,null);
    END
//
Drop trigger DV_DEFAULT;

#Tu dong update so nhan vien
DELIMITER //
create trigger UPDATE_SLNV after INSERT ON NVCT FOR EACH ROW
    BEGIN
        UPDATE congty SET SoNV = SoNV + 1 WHERE CongTy.MaCT = NEW.MaCT;
    END
//


#------- Tu dong tang gia dich vu cu cua tung cong ty
DELIMITER //
create trigger UPDATE_GIADV after UPDATE ON congty FOR EACH ROW
    BEGIN
        DECLARE SoNVHT int;
        DECLARE PhanTram float;
        DECLARE PhanTram2 float;
        DECLARE DienTich float;
        DECLARE GiaBD float;
        DECLARE newMaCT varchar(50);
        DECLARE newMaDV varchar(50);
        
        DEClARE curMaDV 
		CURSOR FOR 
			SELECT MaDV FROM SuDung,DichVu
            WHERE DichVu.MaDV = Sudung.MaDV;
		
        DECLARE CONTINUE HANDLER 
			FOR NOT FOUND SET finished = 1;
        
        OPEN curMaDV;

		getEmail: LOOP
			FETCH curMaDV INTO emailAddress;
			IF finished = 1 THEN 
				LEAVE getEmail;
			END IF;
			-- build email list
			SET emailList = CONCAT(emailAddress,";",emailList);
		END LOOP getEmail;
		CLOSE curMaDV;
		
--         SELECT SuDung.MaCT,SuDung.MaDV, Services.DonGiaCS INTO newMaCT, newMaDV , GiaBD
--         FROM SuDung, Company, Services
--         WHERE SuDung.MaCT = new.MaCT AND SuDung.MaDV = Services.MaDV;
--         
        SELECT DonGiaCS INTO  GiaBD FROM DichVu,Sudung,CongTy
        WHERE DichVu.MaDV = Sudung.MaDV AND SuDung.MaCT = NEW.MaCT;
        
        SET SoNVHT = NEW.SoNV;
        SET DienTich = NEW.DienTich;
		
        IF SoNVHT > 10
            THEN BEGIN
                SET PhanTram = (((SoNVHT - 10)/5)*0.05);
            END;
        END IF;

        IF DienTich > 100
            THEN BEGIN
                SET PhanTram2 = ((DienTich - 100)/10)*0.05;
            END;
        END IF;
		
        UPDATE sudung 
		SET DonGiaRieng = GiaBD + GiaBD * PhanTram + GiaBD * PhanTram2
        WHERE Sudung.MaCT = new.MaCT
        ORDER BY SuDung.MaDV;# AND Sudung.MaDV = 'DV02';
    END
//
-- select * from sudung;
DROP TRIGGER UPDATE_GIADV;
