package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Table(name = "sinh_vien")
public class SinhVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //các trường có tên giống nhau ko cần để column
    private int id;

    private String ma;

    private String ten;

    private int tuoi;

    @Column(name="dia_chi")
    private String diaChi;

    @Column(name="gioi_tinh")
    private Boolean gioiTinh;

    @Column(name="lop_id")
    private int lopId;

}
