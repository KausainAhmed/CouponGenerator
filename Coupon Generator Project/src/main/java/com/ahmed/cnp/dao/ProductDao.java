package com.ahmed.cnp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.ahmed.cnp.model.Product;
import com.ahmed.cnp.util.ConnectionUtil;

public class ProductDao {
	public void save(Product product) {
		Connection connection = ConnectionUtil.getConnection();

		try {
			PreparedStatement statement = connection
					.prepareStatement("insert into product(name,discription,price)values(?,?,?)");
			statement.setString(1, product.getName());
			statement.setString(2, product.getDiscription());
			statement.setBigDecimal(3, product.getPrice());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
