package com.ahmed.cnp.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ahmed.cnp.dao.CouponDao;
import com.ahmed.cnp.dao.ProductDao;
import com.ahmed.cnp.model.Coupon;
import com.ahmed.cnp.model.Product;

@WebServlet("/products")
public class ProductController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	CouponDao couponDao = new CouponDao();
	ProductDao productDao = new ProductDao();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String discription = request.getParameter("discription");
		String price = request.getParameter("price");
		String couponCode = request.getParameter("couponCode");
		Coupon coupon = couponDao.findByCode(couponCode);
		Product product = new Product();
		product.setName(name);
		product.setDiscription(discription);
		product.setPrice(new BigDecimal(price).subtract(coupon.getDiscount()));
		productDao.save(product);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<b>Product Created </b>");
		out.println("<br> <a href='index.html'>Home</a>");
	}
}
