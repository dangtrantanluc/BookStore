package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Author;
import model.Customer;

public class AuthorDao implements DAOInterface<Author> {

	@Override
	public ArrayList<Author> selectAll() {
		ArrayList<Author> result = new ArrayList<>();

		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "seclect* from  Author";
			PreparedStatement st = con.prepareStatement(sql);

			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String idAuthor = rs.getString("idAuthor");
				String name = rs.getString("name");
				Date dateOfBirth = rs.getDate("dateOfBirth");
				String story = rs.getString("story");

				Author author = new Author(idAuthor, name, dateOfBirth, story);
				result.add(author);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Author selectById(Author t) {
		Author result = null;

		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "seclect* from Author where idAuthor = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getIdAuthor());

			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String idAuthor = rs.getString("idAuthor");
				String name = rs.getString("name");
				Date dateOfBirth = rs.getDate("dateOfBirth");
				String story = rs.getString("story");

				result= new Author(idAuthor, name, dateOfBirth, story);
				break;
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int insert(Author t) {
		int result = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO tacgia (matacgia, hovaten, ngaysinh, tieusu) " + " VALUES (?,?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getIdAuthor());
			st.setString(2, t.getName());
			st.setDate(3, t.getDateOfBirth());
			st.setString(4, t.getStory());

			// Bước 3: thực thi câu lệnh SQL
			result = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + result + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int insertAll(ArrayList<Author> arr) {
		int count = 0;
		for (Author author : arr) {
			count += this.insert(author);
		}
		return count;
	}

	@Override
	public int delete(Author t) {
		int result = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from tacgia " + " WHERE matacgia=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getIdAuthor());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			result = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + result + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int deleteAll(ArrayList<Author> arr) {
		int count = 0;
		for (Author author : arr) {
			count += this.delete(author);
		}
		return count;
	}

	@Override
	public int update(Author t) {
		int result = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE tacgia " + " SET " + " hovaten=?" + ", ngaysinh=?" + ", tieusu=?"
					+ " WHERE matacgia=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getName());
			st.setDate(2, t.getDateOfBirth());
			st.setString(3, t.getStory());
			st.setString(4, t.getIdAuthor());
			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			result = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + result + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

}
