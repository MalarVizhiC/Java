package Ecommerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlDBcode {
	Connection con;

	public SqlDBcode() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
	}

	public void listproducts() {

		System.out.println("LISTING PRODUCTS\n");

		try {
			String q = "Select * from products";
			PreparedStatement pst = con.prepareStatement(q);
			ResultSet rs = pst.executeQuery();
			System.out.println("ID | NAME | PRICE | OFFER");
			while (rs.next()) {
				int a = rs.getInt("id");
				String b = rs.getString("name");
				int c = rs.getInt("Price");
				int d = rs.getInt("Offer");
				System.out.println(a + " | " + b + " | " + c + " | " + d);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public void listproductsSortByPrice() {

		System.out.println("LISTING PRODUCTS BY PRICE\n");

		try {
			String q = "select * from products order by Price desc";
			PreparedStatement pst = con.prepareStatement(q);
			ResultSet rs = pst.executeQuery();
			System.out.println("ID | NAME | PRICE | OFFER");
			while (rs.next()) {
				int a = rs.getInt("id");
				String b = rs.getString("name");
				int c = rs.getInt("Price");
				int d = rs.getInt("Offer");
				System.out.println(a + " | " + b + " | " + c + " | " + d);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public void updateProducts(int id, String name, int price, int offer) {
		try {

			String q = "insert into Products values(?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(q);
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setInt(3, price);
			pst.setInt(4, offer);
			int n = pst.executeUpdate();
			if (n == 0) {
				System.out.println("Not saved");
			} else {
				System.out.println("Saved");
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public void getProductinfo(int pid) {
		System.out.println("Getting Product info of ID: " + pid);

		queryProductById(pid);
	}

	public void queryProductById(int id) {

		try {

			String q = "Select * from products where id = ?";
			PreparedStatement pst = con.prepareStatement(q);
			pst.setInt(1, id);

			System.out.println("ID | NAME | PRICE | OFFER");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int a = rs.getInt("id");
				String b = rs.getString("name");
				int c = rs.getInt("Price");
				int d = rs.getInt("Offer");
				System.out.println(a + " | " + b + " | " + c + " | " + d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void viewprofile() {

		System.out.println("LISTING PROFILE\n");

		try {
			String q = "Select * from viewProfile";
			PreparedStatement pst = con.prepareStatement(q);
			System.out.println("NAME | MAIL | CITY | MOBILE");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				String a = rs.getString("name");
				String b = rs.getString("mail");
				String c = rs.getString("city");
				int d = rs.getInt("mobile");
				System.out.println(a + " | " + b + " | " + c + " | " + d);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public void listorders() {
		System.out.println("LISTING ORDERS\n");

		try {
			String q = "Select * from orders";
			PreparedStatement pst = con.prepareStatement(q);
			System.out.println("ORDER ID | PID | BILL | STATUS");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int a = rs.getInt("orderid");
				int b = rs.getInt("Pid");
				int c = rs.getInt("bill");
				String d = rs.getString("status");
				System.out.println(a + " | " + b + " | " + c + " | " + d);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public void queryordersById(int id) {

		try {
			String q = "Select * from orders where orderid = ?";
			PreparedStatement pst = con.prepareStatement(q);
			pst.setInt(1, id);
			System.out.println("ORDER ID | PID | BILL | STATUS");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int a = rs.getInt("orderid");
				int b = rs.getInt("Pid");
				int c = rs.getInt("bill");
				String d = rs.getString("status");
				System.out.println(a + " | " + b + " | " + c + " | " + d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void viewcart() {

		try {
			String q = "Select * from cart";
			PreparedStatement pst = con.prepareStatement(q);
			System.out.println("NAME | ID | PID");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String a = rs.getString("name");
				int b = rs.getInt("id");
				int c = rs.getInt("Pid");
				System.out.println(a + " | " + b + " | " + c);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public void deletecart(int id) {

		try {
			String q = "delete from cart where id = ?";
			PreparedStatement pst = con.prepareStatement(q);
			pst.setInt(1, id);
			int n = pst.executeUpdate();
			if (n == 0) {
				System.out.println("NOT DELETED");
			} else {
				System.out.println("DELETED");
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

}
