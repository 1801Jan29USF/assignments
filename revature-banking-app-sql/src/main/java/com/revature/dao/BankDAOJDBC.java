package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

public class BankDAOJDBC implements BankDAO {

	private Logger log = Logger.getRootLogger();
	private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();

	@Override
	public int save(User u) {
		log.trace("method called to insert new user");
		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()) {
			log.trace("connection established with db, creating prepared statement to save user");
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO user_account (username, pass, checking, savings) VALUES (?,?,?,?)",
					new String[] { "user_id" });
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setInt(3, u.checking);
			ps.setInt(4, u.savings);

			int rowsInserted = ps.executeUpdate();
			log.debug("query inserted " + rowsInserted + " rows into the database");
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				u.setId(rs.getInt(1));
				return rs.getInt(1);
			}

		} catch (SQLException e) {
			log.warn("failed to insert new user");
		}
		return 0;
	}

	@Override
	public User login(String u, String p) {
		log.trace("method called to check for uniqueness of login credentials");
		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()) {
			log.trace("connection established with db, creating prepared statement to save user");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM user_account WHERE username = ? AND pass = ?");
			ps.setString(1, u);
			ps.setString(2, p);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				User user = new User(rs.getInt("user_id"), rs.getString("username"), rs.getString("pass"),
						rs.getInt("checking"), rs.getInt("savings"));
				return user;
			} else {
				log.trace("No user found with username: " + u + " and password: " + p);
				System.out.println(
						"No user found with username: " + u + " and password: " + p + ". Please check you input.\n");

			}

		} catch (SQLException e) {
			log.warn("failed to retrieve user");
		}
		return null;
	}

	@Override
	public User register(String u, String p) {
		log.trace("method called to check for uniqueness of registration credentials");
		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()) {
			log.trace("connection established with db, creating prepared statement to save user");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM user_account WHERE username = ?");
			ps.setString(1, u);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				log.trace("User credentials are not uniqe.");

			} else {
				User user = new User(0, u, p, 0, 0);
				save(user);
				return user;
			}

		} catch (SQLException e) {
			log.warn("failed to retrieve user");
		}
		return null;
	}

	@Override
	public void deposit(int id, int amt, String type) {
		log.trace("method called to deposit money into account");
		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()) {
			log.trace("connection established with db, creating prepared statement to save user");
			PreparedStatement ps = conn
					.prepareStatement("UPDATE user_account SET " + type + "= " + type + " + " + amt + " WHERE user_id = " + id + ";");
			ps.executeUpdate(); 

		} catch (SQLException e) {
			log.warn("failed to retrieve user");
		}
	}
	
	@Override
	public void withdraw(int id, int amt) {
		log.trace("method called to withdraw money from account");
		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()) {
			log.trace("connection established with db, creating prepared statement to save user");
			PreparedStatement ps = conn
					.prepareStatement("UPDATE user_account SET checking = checking - " + amt + " WHERE user_id = " + id + ";");
			ps.setInt(1, id);
			ps.executeUpdate(); 

		} catch (SQLException e) {
			log.warn("failed to retrieve user");
		}
	}

	// @Override
	// public int save(User u) {
	// log.trace("method called to insert new user");
	// log.trace("Attempting to get connection to db");
	// try (Connection conn = connUtil.getConnection()) {
	// log.trace("connection established with db, creating prepared statement");
	// PreparedStatement ps = conn.prepareStatement("INSERT INTO User (username,
	// password, checking, savings) VALUES (?,?,?,?)",
	// new String[] { "flashcard_id" });
	// ps.setString(1, u.getUsername());
	// ps.setString(2, u.getPassword());
	// ps.setInt(3, 0);
	// ps.setInt(4, 0);
	//
	// int rowsInserted = ps.executeUpdate();
	// log.debug("query inserted " + rowsInserted + " rows into the db");
	// ResultSet rs = ps.getGeneratedKeys();
	// if (rs.next()) {
	// u.setId(rs.getInt(1));
	// return rs.getInt(1);
	// }
	//
	// } catch (SQLException e) {
	// log.warn("failed to insert new user");
	// }
	//
	// return 0;
	// }

	// @Override
	// public void save(Flashcard fc, int setId) {
	// log.trace("method called to insert new flashcard into set with id" + setId);
	// log.trace("Attempting to get connection to db");
	// try (Connection conn =
	// DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
	// "flashcard",
	// "p4ssw0rd")) {
	// CallableStatement cs = conn.prepareCall("call
	// create_flashcard_for_set(?,?,?,?)");
	// cs.setString(1, fc.getQuestion());
	// cs.setString(2, fc.getAnswer());
	// cs.setInt(3, setId);
	// cs.registerOutParameter(4, Types.INTEGER);
	// cs.execute();
	//
	// log.trace("flashcard created with id" + cs.getInt(4));
	// fc.setId(cs.getInt(4));
	//
	// } catch (SQLException e) {
	// log.warn("failed to insert new flashcard");
	// }
	// }
	//
	// /**
	// * Do not use regular statements this is a dangerous method
	// */
	// @Override
	// public void update(Flashcard fc) {
	// log.trace("method called to update new flashcard");
	// log.trace("Attempting to get connection to db");
	// try (Connection conn =
	// DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
	// "flashcard",
	// "p4ssw0rd")) {
	// Statement s = conn.createStatement();
	// int numRowsUpdated = s.executeUpdate("UPDATE flashcard SET question = '" +
	// fc.getQuestion() + "', answer='"
	// + fc.getAnswer() + "' WHERE flashcard_id=" + fc.getId());
	// log.trace("updated " + numRowsUpdated + " row s");
	// } catch (SQLException e) {
	// e.printStackTrace();
	// log.warn("failed to update flashcard");
	// }
	// }
	//
	// @Override
	// public void delete(Flashcard fc) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public Flashcard get(int id) {
	// log.trace("method called to select flashcard with id " + id);
	// log.trace("Attempting to get connection to db");
	// try (Connection conn =
	// DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
	// "flashcard",
	// "p4ssw0rd")) {
	// PreparedStatement ps = conn.prepareStatement("SELECT * FROM flashcard WHERE
	// flashcard_id = ?");
	// ps.setInt(1, id);
	// ResultSet rs = ps.executeQuery();
	// if (rs.next()) {
	// Flashcard fc = new Flashcard(rs.getInt("flashcard_id"),
	// rs.getString("question"),
	// rs.getString("answer"));
	// return fc;
	// } else {
	// log.trace("No flashcard found with id " + id);
	// }
	//
	// } catch (SQLException e) {
	// e.printStackTrace();
	// log.warn("failed to retreive flashcard");
	// }
	// return null;
	// }
	//
	// @Override
	// public List<Flashcard> findBySetId(int id) {
	// log.trace("method called to select flashcard with set id " + id);
	// log.trace("Attempting to get connection to db");
	// try (Connection conn = connUtil.getConnection()) {
	// List<Flashcard> cardsInSet = new ArrayList<>();
	// PreparedStatement ps = conn.prepareStatement(
	// "SELECT * FROM flashcard INNER JOIN flashcard_cardset USING(flashcard_id)
	// WHERE set_id = ?");
	// ps.setInt(1, id);
	// ResultSet rs = ps.executeQuery();
	// while (rs.next()) {
	// Flashcard fc = new Flashcard(rs.getInt("flashcard_id"),
	// rs.getString("question"),
	// rs.getString("answer"));
	// cardsInSet.add(fc);
	// }
	// log.trace("retreived all flashcards in set and returning the list");
	// return cardsInSet;
	// } catch (SQLException e) {
	// e.printStackTrace();
	// log.warn("failed to retreive flashcard");
	// }
	// return null;
	// }

}
