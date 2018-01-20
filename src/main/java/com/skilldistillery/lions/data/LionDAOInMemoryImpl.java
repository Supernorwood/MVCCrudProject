package com.skilldistillery.lions.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;


@Repository
@Primary
public class LionDAOInMemoryImpl implements LionDAO {
	private static String url = "jdbc:mysql://localhost:3306/lionsdb";
	private String user = "lions";
	private String pass = "lions";

	Map<Integer, Lion> lions;

	private int id = 1;

	public LionDAOInMemoryImpl() {
		lions = new HashMap<>();
		loadSampleLions();
		try {
		    Class.forName("com.mysql.jdbc.Driver");
		  } catch (ClassNotFoundException e) {
		    e.printStackTrace();
		    System.err.println("Error loading MySQL Driver!!!");
		  }
	}

	private void loadSampleLions() {
		lions.put(id, new Lion(id++, "Gregory", "male", "https://i.ytimg.com/vi/BgwSMJ-Tbf8/maxresdefault.jpg"));
		lions.put(id, new Lion(id++, "Amy", "female",
				"http://www.thirteenmonths.com/images/tanzania/tz_inpop/tz_nser_lionkill2_in.jpg"));
		lions.put(id, new Lion(id++, "Charis", "female", "https://i.ytimg.com/vi/1Fna-rhmVlw/maxresdefault.jpg"));
	}

	@Override
	public Lion addLion(Lion l) {
//		l.setId(id++);
//		return lions.put(l.getId(), l);
//	}
		Lion lionAdded = null;
		try {
		    Connection conn = DriverManager.getConnection(url, user, pass);
		    conn.setAutoCommit(false);
		    String sql = "INSERT INTO lions (name, gender_id, image_id) VALUES (?,?,?)";
		    PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		    stmt.setString(1, l.getName());
			stmt.setString(2, l.getGender());
			stmt.setString(3, l.getImageUrl());
		    stmt.executeUpdate();
		    lionAdded = l;
		    
		    ResultSet keys = stmt.getGeneratedKeys();
		    keys.next();
		    int i = keys.getInt(1);
		    lionAdded.setId(i);
		    
		    conn.commit();
		    stmt.close();
		    conn.close();
		  } catch (SQLException e) {
		    e.printStackTrace();
		  }
		return lionAdded;
	}
		
		
		
	@Override
	public List<Lion> getAllLions() {
//		return new ArrayList<Lion>(lions.values());
//	}
		List<Lion> lionList = new ArrayList<>();
		Lion lion = null;
		  try {
		    Connection conn = DriverManager.getConnection(url, user, pass);
		    String sql = "SELECT id , name FROM lions ";
		    PreparedStatement stmt = conn.prepareStatement(sql);
		    
		    ResultSet rs = stmt.executeQuery();
		    while (rs.next()) {
		      int id = rs.getInt(1);
		      String name = rs.getString(2);
		      lion = new Lion(id, name, "Male");
		     lionList.add(lion); 
		     System.out.println(lion);
		    }
		    rs.close();
		    stmt.close();
		    conn.close();
		  } catch (SQLException e) {
		    e.printStackTrace();
		  }
		  return lionList;
	}
		

	@Override
	public Lion getLionById(int id) { 
		// return lions.get(id);
		// }
		Lion lion = null;
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT id , name, gender_id, image_id FROM lions WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);
				String name = rs.getString(2);
				String gender = rs.getString(3);
				String imageUrl = rs.getString(4);
				lion = new Lion(id, name, gender, imageUrl);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lion;
	}

	@Override
	public Lion updateLion(Lion l) {
		// return lions.put(l.getId(), l);
		// }
		Lion lionUpdate = null;
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			conn.setAutoCommit(false);
			String sql = "update lions set id=?, name=?, gender_id =?, image_id=? where id=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, l.getId());
			st.setString(2, l.getName());
			st.setString(3, l.getGender());
			st.setString(4, l.getImageUrl());
			st.executeUpdate();
			lionUpdate = getLionById(l.getId());

			conn.commit();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lionUpdate;
	}

	@Override
	public Lion deleteLion(Lion l) {
		// return lions.remove(l.getId());
		// }
//		Lion lionDelete = null;
		try {
			 Connection conn = DriverManager.getConnection(url, user, pass);
			    conn.setAutoCommit(false);
			    String sql = "delete from lions where id=?";
			    PreparedStatement st = conn.prepareStatement(sql);
			    st.setInt(1, l.getId());
			    st.executeUpdate();
			    
			    conn.commit();
			    st.close();
			    conn.close();
		}catch(SQLException e) {
		    e.printStackTrace();
		    return null; 
		  }
		return l;
	}
	
}
