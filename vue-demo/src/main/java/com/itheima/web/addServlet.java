package com.itheima.web; /**
 * @author Mendy
 * @create 2023-05-28 14:45
 */

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addServlet")
public class addServlet extends HttpServlet {

    private BrandService brandService = new BrandService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. accept data
        // 1.1 acquire the data of request body (post)
        BufferedReader br = request.getReader();
        String params = br.readLine();

        //1.2. transfer JSON string into Java object
        Brand brand = JSON.parseObject(params, Brand.class);
        System.out.println(brand);

        //2. call add method from BrandService
        brandService.add(brand);

        //3. prompt the flag of succeed addition
        response.getWriter().write("success");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
