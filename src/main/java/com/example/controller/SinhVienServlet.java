package com.example.controller;

import com.example.entity.SinhVien;
import com.example.repository.SinhVienRepon;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SinhVienServlet", value = {
        "/sinh-vien/hien-thi",
        "/sinh-vien/add",
        "/sinh-vien/detail",
        "/sinh-vien/delete",
        "/sinh-vien/update",
        "/sinh-vien/view-update",
        "/sinh-vien/search",
        "/sinh-vien/top3"
        })
public class SinhVienServlet extends HttpServlet {
    private List<SinhVien> list = new ArrayList<>();
    private SinhVienRepon sinhVienRepon = new SinhVienRepon();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
            if(uri.contains("hien-thi")){
                this.hienThi(request,response);
            }else if(uri.contains("detail")){
                this.detail(request,response);
            }else if(uri.contains("delete")){
                this.delete(request,response);
            }else if(uri.contains("view-update")){
                this.viewUpdate(request,response);
            }else if(uri.contains("search")){
                this.search(request,response);
            }else if(uri.contains("top3")){
                this.top3(request,response);
            }
    }

    private void top3(HttpServletRequest request, HttpServletResponse response) {
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SinhVien sinhVien = sinhVienRepon.getOne(Integer.valueOf(id));
        //ko nên để cùng tên truyền giống nhau
        request.setAttribute("detail", sinhVien);
        request.getRequestDispatcher("/views/update.jsp").forward(request,response);

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String index = request.getParameter("viTri");
        SinhVien sinhVien = sinhVienRepon.getOne(Integer.parseInt(index));
        sinhVienRepon.delete(sinhVien);
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String index = request.getParameter("viTri");
        //gọi ra id
        SinhVien sinhVien = sinhVienRepon.getOne(Integer.parseInt(index));
        request.setAttribute("detail",sinhVien);
        //load lại table
        list = sinhVienRepon.getAll();
        request.setAttribute("key",list);
        request.getRequestDispatcher("/views/index.jsp").forward(request,response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        list = sinhVienRepon.getAll();
        request.setAttribute("key",list);
        request.getRequestDispatcher("/views/index.jsp").forward(request,response);
    }
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        if(uri.contains("add")){
            this.add(request,response);
        }else if(uri.contains("update")){
            this.update(request,response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        SinhVien sinhVien = new SinhVien();
        BeanUtils.populate(sinhVien,request.getParameterMap());
        sinhVienRepon.updateSV(sinhVien);
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        SinhVien sinhVien = new SinhVien();
        BeanUtils.populate(sinhVien,request.getParameterMap());
        sinhVienRepon.addSV(sinhVien);
        response.sendRedirect("/sinh-vien/hien-thi");
    }
}
