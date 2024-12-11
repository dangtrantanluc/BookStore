package database;

import java.lang.constant.DirectMethodHandleDesc.Kind;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

import model.KindOfBook;

public class KindOfBookDao implements DAOInterface<KindOfBook> {
	private ArrayList<KindOfBook> result = new ArrayList<KindOfBook>();

	@Override
	public ArrayList<KindOfBook> selectAll() {
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "seclect* from KindOfBook ";
			PreparedStatement st = con.prepareStatement(sql);

			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String idKindOfBook = rs.getString("idKindOfBook");
				String nameKindOfBook = rs.getString("nameKindOfBook");

				KindOfBook kindOfBook = new KindOfBook(idKindOfBook, nameKindOfBook);
				result.add(kindOfBook);
			}
			JDBCUtil.closeConnection(con);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public KindOfBook selectById(KindOfBook t) {
		KindOfBook result = null;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select* from KindOfBook where idKindOfBook=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getIdKindOfBook());

			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String idKindOfBook = rs.getString("idKindOfBook");
				String nameKindOfBook = rs.getString("nameKindOfBook");

				result = new KindOfBook(idKindOfBook, nameKindOfBook);
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int insert(KindOfBook t) {
		int result = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "INSERT INTO KindOfBook (idKindOfBook, nameKindOfBook) " + " VALUES (?,?)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getIdKindOfBook());
			st.setString(2, t.getNameKindOfBook());

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
	public int insertAll(ArrayList<KindOfBook> arr) {
		int count = 0;
		for (KindOfBook kindOfBook : arr) {
			count += this.insert(kindOfBook);
		}
		return count;
	}

	@Override
	public int delete(KindOfBook t) {
		int result = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "DELETE from KindOfBook " + " WHERE idKindOfBook=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getIdKindOfBook());

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
	public int deleteAll(ArrayList<KindOfBook> arr) {
		int count = 0;
		for (KindOfBook kindOfBook : arr) {
			count += this.delete(kindOfBook);
		}
		return count;
	}

	@Override
	public int update(KindOfBook t) {
		int result = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "UPDATE KindOfBoook "+
					 " SET " +
					 " nameKindOfBook=?"+
					 " WHERE idKindOfBook=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getNameKindOfBook());
			st.setString(2, t.getIdKindOfBook());
			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			result = st.executeUpdate();
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ result+" dòng bị thay đổi!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
