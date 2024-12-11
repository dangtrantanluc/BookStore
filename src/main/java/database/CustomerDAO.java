package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import model.Customer;

public class CustomerDAO implements DAOInterface<Customer> {
	private ArrayList<Customer> result = new ArrayList<Customer>();

	@Override
	public ArrayList<Customer> selectAll() {
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from Customer";
			PreparedStatement statement = con.prepareStatement(sql);

			System.out.println(sql);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				String idCustomer = rs.getString("idCustomer");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String fullName = rs.getString("fullName");
				String sex = rs.getString("sex");
				String address = rs.getString("address");
				String deliveryAddress = rs.getString("deliveryAddress");
				String invoiceAddress = rs.getString("invoiceAddress");
				Date dayOfBirth = rs.getDate("dayOfBirth");
				int phoneNumber = rs.getInt("phoneNumber");
				String email = rs.getString("email");
				boolean signUpToReceiveEmail = rs.getBoolean("signUpToReceiveEmail");

				Customer customer = new Customer(idCustomer, username, password, fullName, sex, address,
						deliveryAddress, invoiceAddress, dayOfBirth, phoneNumber, email, signUpToReceiveEmail);
				result.add(customer);

			}
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public Customer selectById(Customer t) {
		Customer result = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM khachhang WHERE makhachhang=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getIdClient());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				String idCustomer = rs.getString("idCustomer");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String fullName = rs.getString("fullName");
				String sex = rs.getString("sex");
				String address = rs.getString("address");
				String deliveryAddress = rs.getString("deliveryAddress");
				String invoiceAddress = rs.getString("invoiceAddress");
				Date dayOfBirth = rs.getDate("dayOfBirth");
				int phoneNumber = rs.getInt("phoneNumber");
				String email = rs.getString("email");
				boolean signUpToReceiveEmail = rs.getBoolean("signUpToReceiveEmail");

				result = new Customer(idCustomer, username, password, fullName, sex, address, deliveryAddress,
						invoiceAddress, dayOfBirth, phoneNumber, email, signUpToReceiveEmail);
				break;
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int insert(Customer t) {
		int result = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO khachhang (makhachhang, tendangnhap, matkhau, hoten, gioitinh, diachi, diachinhanhang, diachimuahang, ngaysinh, sodienthoai, email, dangkinhanbangtin) "
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getIdClient());
			st.setString(2, t.getUsername());
			st.setString(3, t.getPassword());
			st.setString(4, t.getFullName());
			st.setString(5, t.getSex());
			st.setString(6, t.getAddress());
			st.setString(7, t.getDeliveryAddress());
			st.setString(8, t.getInvoiceAddress());
			st.setDate(9, t.getDayOfBirth());
			st.setInt(10, t.getNumber());
			st.setString(11, t.getEmail());
			st.setBoolean(12, t.getSignUpToReceiveEmail());

			// Bước 3: thực thi câu lệnh SQL
			result = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + result + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;

	}

	@Override
	public int insertAll(ArrayList<Customer> arr) {
		int count = 0;
		for (Customer customer : arr) {
			count += this.insert(customer);
		}
		return count;
	}

	@Override
	public int delete(Customer t) {
		int result = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from Customer " + " WHERE idCustomer=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getIdClient());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			result = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + result + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int deleteAll(ArrayList<Customer> arr) {
		int count = 0;
		for (Customer customer : arr) {
			count += this.delete(customer);
		}
		return count;
	}

	@Override
	public int update(Customer t) {
		int result = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "UPDATE Customer " + " SET " + " username=?" + ", password=?" + ", fullName=?" + ", sex=?"
					+ ", address=?" + ", deliveryAddress=?" + ", invoiceAddress=?" + ", dayOfBirth=?"
					+ ", phoneNumber=?" + ", email=?" + ", signUpToReceiveEmail=?" + " WHERE idCustomer=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getIdClient());
			st.setString(2, t.getUsername());
			st.setString(3, t.getPassword());
			st.setString(4, t.getFullName());
			st.setString(5, t.getSex());
			st.setString(6, t.getAddress());
			st.setString(7, t.getDeliveryAddress());
			st.setString(8, t.getInvoiceAddress());
			st.setDate(9, t.getDayOfBirth());
			st.setInt(10, t.getNumber());
			st.setString(11, t.getEmail());
			st.setBoolean(12, t.getSignUpToReceiveEmail());

			System.out.println(sql);
			result = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + result + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public boolean checkUsername(String username) {

		boolean checkusername = false;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "select* from Customer where username";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, username);
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				checkusername = true;
			}
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return checkusername;
	}
}
