package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import model.Author;
import model.Book;
import model.KindOfBook;

public class BookDao implements DAOInterface<Book> {
	private ArrayList<Book> result = new ArrayList<Book>();

	@Override
	public ArrayList<Book> selectAll() {
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select*from Book ";
			PreparedStatement st = con.prepareStatement(sql);

			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String idBook = rs.getString("idBook");
				String nameOfBook = rs.getString("nameOfBook");
				String idAuthor = rs.getString("idAuthor");
				int yearOfManufacture = rs.getInt("yearOfManufacture");
				double importPrice = rs.getDouble("importPrice");
				double price = rs.getDouble("price");
				double cost = rs.getDouble("cost");
				int quantity = rs.getInt("quantity");
				String language = rs.getString("language");
				String description = rs.getString("description");

				Author author = (new AuthorDao().selectById(new Author(idAuthor, "", null, "")));
//				KindOfBook kindOfBook = (new KindOfBookDao().selectById(new KindOfBook(idKindOfBook, "")));

				Book book = new Book(idBook, nameOfBook, author, yearOfManufacture, importPrice, price, cost, quantity,
						language, description);
				result.add(book);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public Book selectById(Book t) {
		Book book = null;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "SELECT * FROM sanpham WHERE masanpham=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getIdBook());

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String idBook = rs.getString("idBook");
				String nameOfBook = rs.getString("nameOfBook");
				String idAuthor = rs.getString("idAuthor");
				int yearOfManufacture = rs.getInt("yearOfManufacture");
				double importPrice = rs.getDouble("importPrice");
				double price = rs.getDouble("price");
				double cost = rs.getDouble("cost");
				int quantity = rs.getInt("quantity");
				String language = rs.getString("language");
				String description = rs.getString("description");

				Author author = (new AuthorDao().selectById(new Author(idAuthor, "", null, "")));
//				KindOfBook kindOfBook = (new KindOfBookDao().selectById(new KindOfBook(idKindOfBook, "")));

				book = new Book(idBook, nameOfBook, author, yearOfManufacture, importPrice, price, cost, quantity,
						language, description);

				break;
			}

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return book;
	}

	@Override
	public int insert(Book t) {
		int count = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "INSERT INTO Book (idBook,nameOfBook, idAuthor, yearOfManufacture,"
					+ " importPrice, price, cost, quantity, language, description) "
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getIdBook());
			st.setString(2, t.getNameOfBook());
			st.setString(3, t.getNameOfAuthor().getIdAuthor());
			st.setInt(4, t.getYearOfManufacture());
			st.setDouble(5, t.getImportPrice());
			st.setDouble(6, t.getPrice());
			st.setDouble(7, t.getCost());
			st.setInt(8, t.getQuatity());
			st.setString(10, t.getLanguage());
			st.setString(11, t.getDescription());

			// Bước 3: thực thi câu lệnh SQL
			count = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + result + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return count;
	}

	@Override
	public int insertAll(ArrayList<Book> arr) {
		int count = 0;
		for (Book book : arr) {
			count += this.insert(book);
		}
		return count;
	}

	@Override
	public int delete(Book t) {
		int result = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from Book  " + " WHERE idBook=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getIdBook());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			result = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + result + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int deleteAll(ArrayList<Book> arr) {
		// TODO Auto-generated method stub
		int count = 0;
		for (Book book : arr) {
			count += this.delete(book);
		}
		return count;
	}

	@Override
	public int update(Book t) {
		int result = 0;
		try {
			Connection con= JDBCUtil.getConnection();
			String sql =  "UPDATE book " + " SET " + "nameOfBook=?, idAuthor=?, yearOfManufacture=?, importPrice=?, price=?, "
					+ "coist=?, quatity=?, language=?, description=?" + " WHERE masanpham=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getIdBook());
			st.setString(2, t.getNameOfAuthor().getIdAuthor());
			st.setInt(3, t.getYearOfManufacture());
			st.setDouble(4, t.getImportPrice());
			st.setDouble(5, t.getPrice());
			st.setDouble(6, t.getCost());
			st.setInt(7, t.getQuatity());
			st.setString(9, t.getLanguage());
			st.setString(10, t.getDescription());

			System.out.println(sql);
			result = st.executeUpdate();

			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + result + " dòng bị thay đổi!");

			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return result;
	}

}
