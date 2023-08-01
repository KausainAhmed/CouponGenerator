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
import com.ahmed.cnp.model.Coupon;
@WebServlet("/coupons")
public class CouponController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CouponDao dao = new CouponDao();

	public CouponController() {
		super();
	}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
       ServletException, IOException{
	String action=request.getParameter("action");
	if(action.equals("create")) {
		createCoupon(request,response);
	}else if (action.equals("find")) {
		
		String coupon1= request.getParameter("couponCode");
		Coupon findByCode = dao.findByCode(coupon1);
		System.out.println(findByCode);
		response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	out.println(findByCode.getId()+" "+findByCode.getCode()+" "+findByCode.getExpDate());
		
		
	}
}

protected void createCoupon(HttpServletRequest request,HttpServletResponse response)
throws IOException {
	String couponCode = request.getParameter("couponCode");
	String discount = request.getParameter("discount");
	String expiryDate = request.getParameter("expiryDate");
	Coupon coupon=new Coupon();
	coupon.setCode(couponCode);
	coupon.setDiscount(new BigDecimal(discount));
	coupon.setExpDate(expiryDate);
	dao.save(coupon);
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	out.println("<b>Coupon Created </b><br>");
	out.println("<a href='index.html'> Home </a>");
}}
