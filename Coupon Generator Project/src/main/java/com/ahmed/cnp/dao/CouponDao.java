package com.ahmed.cnp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.ahmed.cnp.model.Coupon;
import com.ahmed.cnp.util.ConnectionUtil;

public class CouponDao {
	public void save(Coupon coupon) {
		Connection connection = ConnectionUtil.getConnection();
		try {
			PreparedStatement statement = connection
					.prepareStatement("insert into coupon (couponCode,discount,expDate) values(?,?,?)");
			statement.setString(1, coupon.getCode());
			statement.setBigDecimal(2, coupon.getDiscount());
			statement.setString(3, coupon.getExpDate());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Coupon findByCode(String code) {
		Coupon coupon = new Coupon();
		Connection connection = ConnectionUtil.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement("select * from coupon where couponCode=?");
			statement.setString(1, code);
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				coupon.setId(resultset.getInt(1));
				coupon.setCode(resultset.getString(2));
				coupon.setDiscount(resultset.getBigDecimal(3));
				coupon.setExpDate(resultset.getString(4));

			}
			System.out.println(coupon);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return coupon;
	}
}
