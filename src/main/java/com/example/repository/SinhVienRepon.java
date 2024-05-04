package com.example.repository;

import com.example.config.HibernateConfig;
import com.example.entity.SinhVien;
import org.hibernate.Session;

import java.util.List;

public class SinhVienRepon {

    private Session session;

    public SinhVienRepon(){
        session = HibernateConfig.getFACTORY().openSession();
    }
    public List<SinhVien> getAll(){
        List<SinhVien>  list = session.createQuery("From SinhVien ").list();
        return list;
    }
    public void addSV(SinhVien sinhVien){
        try {
            session.getTransaction().begin();
            session.persist(sinhVien);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    public SinhVien getOne(int id){
        return session.find(SinhVien.class,id);
    }
    public void updateSV(SinhVien sinhVien){
        try {
            session.getTransaction().begin();
            session.merge(sinhVien);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    public void delete(SinhVien sinhVien) {
        try {
            session.getTransaction().begin();
            session.delete(sinhVien);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public static void main(String[] args) {
        System.out.println(new SinhVienRepon().getAll());
    }

}
