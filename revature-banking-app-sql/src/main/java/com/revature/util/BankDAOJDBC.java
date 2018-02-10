package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.Flashcard;
import com.revature.util.ConnectionUtil;

public class FlashcardDAOJDBC implements FlashcardDAO {
	private Logger log = Logger.getRootLogger();
	private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();

	public static void main(String[] args) {
		FlashcardDAO flashDao = new FlashcardDAOJDBC();

		// Flashcard fc = new Flashcard(0, "new flashcard for set 1", "new answer for
		// flashcard in set 1");
		// flashDao.save(fc, 1);

		// Flashcard fc = new Flashcard(6, "hacked", "hacked' --");
		// flashDao.update(fc);

		// System.out.println(flashDao.get(2));

		flashDao.findBySetId(1).stream().forEach(ele -> {
			System.out.println(ele);
		});
	}

	@Override
	public int save(Flashcard fc) {
		log.trace("method called to insert new flashcard");
		log.trace("Attempting to get connection to db");
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "flashcard",
				"p4ssw0rd")) {
			log.trace("connection established with db, creating prepared statement");
			PreparedStatement ps = conn.prepareStatement("INSERT INTO flashcard (question, answer) VALUES (?,?)",
					new String[] { "flashcard_id" });
			ps.setString(1, fc.getQuestion());
			ps.setString(2, fc.getAnswer());

			int rowsInserted = ps.executeUpdate();
			log.debug("query inserted " + rowsInserted + " rows into the db");
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				fc.setId(rs.getInt(1));
				return rs.getInt(1);
			}

		} catch (SQLException e) {
			log.warn("failed to insert new flashcard");
		}

		return 0;
	}

	@Override
	public void save(Flashcard fc, int setId) {
		log.trace("method called to insert new flashcard into set with id" + setId);
		log.trace("Attempting to get connection to db");
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "flashcard",
				"p4ssw0rd")) {
			CallableStatement cs = conn.prepareCall("call create_flashcard_for_set(?,?,?,?)");
			cs.setString(1, fc.getQuestion());
			cs.setString(2, fc.getAnswer());
			cs.setInt(3, setId);
			cs.registerOutParameter(4, Types.INTEGER);
			cs.execute();

			log.trace("flashcard created with id" + cs.getInt(4));
			fc.setId(cs.getInt(4));

		} catch (SQLException e) {
			log.warn("failed to insert new flashcard");
		}
	}

	/**
	 * Do not use regular statements this is a dangerous method
	 */
	@Override
	public void update(Flashcard fc) {
		log.trace("method called to update new flashcard");
		log.trace("Attempting to get connection to db");
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "flashcard",
				"p4ssw0rd")) {
			Statement s = conn.createStatement();
			int numRowsUpdated = s.executeUpdate("UPDATE flashcard SET question = '" + fc.getQuestion() + "', answer='"
					+ fc.getAnswer() + "' WHERE flashcard_id=" + fc.getId());
			log.trace("updated " + numRowsUpdated + " row s");
		} catch (SQLException e) {
			e.printStackTrace();
			log.warn("failed to update flashcard");
		}
	}

	@Override
	public void delete(Flashcard fc) {
		// TODO Auto-generated method stub

	}

	@Override
	public Flashcard get(int id) {
		log.trace("method called to select flashcard with id " + id);
		log.trace("Attempting to get connection to db");
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "flashcard",
				"p4ssw0rd")) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM flashcard WHERE flashcard_id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Flashcard fc = new Flashcard(rs.getInt("flashcard_id"), rs.getString("question"),
						rs.getString("answer"));
				return fc;
			} else {
				log.trace("No flashcard found with id " + id);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			log.warn("failed to retreive flashcard");
		}
		return null;
	}

	@Override
	public List<Flashcard> findBySetId(int id) {
		log.trace("method called to select flashcard with set id " + id);
		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()) {
			List<Flashcard> cardsInSet = new ArrayList<>();
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM flashcard INNER JOIN flashcard_cardset USING(flashcard_id) WHERE set_id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Flashcard fc = new Flashcard(rs.getInt("flashcard_id"), rs.getString("question"),
						rs.getString("answer"));
				cardsInSet.add(fc);
			}
			log.trace("retreived all flashcards in set and returning the list");
			return cardsInSet;
		} catch (SQLException e) {
			e.printStackTrace();
			log.warn("failed to retreive flashcard");
		}
		return null;
	}

}
