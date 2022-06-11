package com.ffproject.springback;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.*;
import java.util.*;
import java.util.regex.Pattern;

@SpringBootApplication
@RestController
@RequestMapping({"/api/ffproject"})
public class FfProjectSpringBackApplication {

	private static final String url = "jdbc:postgresql://localhost:5432/footballstats";
	private static final String user = "postgres";
	private static final String password = "postgres";

	public static void main(String[] args) {
		SpringApplication.run(FfProjectSpringBackApplication.class, args);
	}

	private static Connection connect() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	@GetMapping({"/test/testEndpoint"})
	public String testEndpoint() {
		return "test";
	}

	@SuppressWarnings("deprecation")
	@PostMapping({"/ingest/ingestRushingStatsForYear"})
	public String ingestRushingStatsForYear(final Integer year, final String csvFile) throws IOException {
		String rushingStatSQL = "INSERT INTO rushing_stats(player_name, team, age, position, games_played, games_started, rushing_attempts, " +
				"rushing_yards, rushing_touchdowns, rushing_first_downs, longest_rush, rushing_yards_per_attempt, " +
				"rushing_yards_per_game, fumbles, year) " +
				"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try (Connection conn = connect()) {

			Reader in = new FileReader(csvFile);
			Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader().parse(in);
			for (CSVRecord record : records) {
				String player = record.get("Player");
				player = player.replace("*", "");
				player = player.replace("+", "");
				String[] playerSplit = player.split(Pattern.quote("\\"));
				String team = record.get("Tm").toUpperCase();
				String age = record.get("Age");
				String position = record.get("Pos").toUpperCase();
				position = position.replace("/", "");
				if(position.isEmpty()) { position = "RB"; }
				String games = record.get("G");
				String gamesStarted = record.get("GS");
				String attempts = record.get("Att");
				String yards = record.get("Yds");
				String touchdowns = record.get("TD");
				String firstdowns = record.get("1D");
				String longest = record.get("Lng");
				String yardsPerRush = record.get("Y/A");
				String yardsPerGame = record.get("Y/G");
				String fumbles = record.get("Fmb");
				System.out.println(playerSplit[0] + " " + team + " " + age + " " + position + " " + games + " " + gamesStarted + " " +
						attempts + " " + yards + " " + touchdowns + " " + firstdowns + " " + longest + " " + yardsPerRush
						+ " " + yardsPerGame + " " + fumbles + " " + year);

				PreparedStatement pstmt = conn.prepareStatement(rushingStatSQL);
				pstmt.setString(1, playerSplit[0].trim());
				pstmt.setString(2, team);
				pstmt.setInt(3, Integer.parseInt(age));
				pstmt.setString(4, position);
				pstmt.setInt(5, Integer.parseInt(games));
				pstmt.setInt(6, Integer.parseInt(gamesStarted));
				pstmt.setInt(7, Integer.parseInt(attempts));
				pstmt.setInt(8, Integer.parseInt(yards));
				pstmt.setInt(9, Integer.parseInt(touchdowns));
				pstmt.setInt(10, Integer.parseInt(firstdowns));
				pstmt.setInt(11, Integer.parseInt(longest));
				pstmt.setDouble(12, Double.parseDouble(yardsPerRush));
				pstmt.setDouble(13,Double.parseDouble(yardsPerGame));
				pstmt.setInt(14, Integer.parseInt(fumbles));
				pstmt.setInt(15, year);
				pstmt.executeUpdate();
			}
		} catch (SQLException ex) {
			return ex.getMessage();
		}
		return "ingested";
	}

	@SuppressWarnings("deprecation")
	@PostMapping({"/ingest/ingestPassingStatsForYear"})
	public String ingestPassingStatsForYear(final Integer year, final String csvFile) throws IOException {
		String SQL = "INSERT INTO passing_stats(player_name, team, age, position, games_played, games_started, passes_completed, " +
				"passes_attempted, passing_yards, passing_touchdowns, interceptions, first_downs_passing, longest_pass, " +
				"sacks, year) " +
				"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try (Connection conn = connect()) {

			Reader in = new FileReader(csvFile);
			Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader().parse(in);
			for (CSVRecord record : records) {
				String player = record.get("Player");
				player = player.replace("*", "");
				player = player.replace("+", "");
				String[] playerSplit = player.split(Pattern.quote("\\"));
				String team = record.get("Tm").toUpperCase();
				String age = record.get("Age");
				String position = record.get("Pos").toUpperCase();
				position = position.replace("/", "");
				if(position.isEmpty()) { position = "QB"; }
				String games = record.get("G");
				String gamesStarted = record.get("GS");
				String completions = record.get("Cmp");
				String attempts = record.get("Att");
				String yards = record.get("Yds");
				String touchdowns = record.get("TD");
				String interceptions = record.get("Int");
				String firstdowns = record.get("1D");
				String longest = record.get("Lng");
				String sacks = record.get("Sk");
				System.out.println(playerSplit[0] + " " + team + " " + age + " " + position + " " + games + " " + gamesStarted + " " +
						attempts + " " + yards + " " + touchdowns + " " + firstdowns + " " + longest + " " + completions
						+ " " + interceptions + " " + sacks + " " + year);

				PreparedStatement pstmt = conn.prepareStatement(SQL);
				pstmt.setString(1, playerSplit[0].trim());
				pstmt.setString(2, team);
				pstmt.setInt(3, Integer.parseInt(age));
				pstmt.setString(4, position);
				pstmt.setInt(5, Integer.parseInt(games));
				pstmt.setInt(6, Integer.parseInt(gamesStarted));
				pstmt.setInt(7, Integer.parseInt(completions));
				pstmt.setInt(8, Integer.parseInt(attempts));
				pstmt.setInt(9, Integer.parseInt(yards));
				pstmt.setInt(10, Integer.parseInt(touchdowns));
				pstmt.setInt(11, Integer.parseInt(interceptions));
				pstmt.setInt(12, Integer.parseInt(firstdowns));
				pstmt.setInt(13, Integer.parseInt(longest));
				pstmt.setInt(14, Integer.parseInt(sacks));
				pstmt.setInt(15, year);
				pstmt.executeUpdate();
			}
		} catch (SQLException ex) {
			return ex.getMessage();
		}
		return "ingested";
	}

	@SuppressWarnings("deprecation")
	@PostMapping({"/ingest/ingestReceivingStatsForYear"})
	public String ingestReceivingStatsForYear(final Integer year, final String csvFile) throws IOException {
		String SQL = "INSERT INTO receiving_stats(player_name, team, age, position, games_played, games_started, targets, " +
				"receptions, receiving_yards, receiving_touchdowns, first_downs_receiving, longest_reception, fumbles, year) " +
				"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try (Connection conn = connect()) {

			Reader in = new FileReader(csvFile);
			Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader().parse(in);
			for (CSVRecord record : records) {
				String player = record.get("Player");
				player = player.replace("*", "");
				player = player.replace("+", "");
				String[] playerSplit = player.split(Pattern.quote("\\"));
				String team = record.get("Tm").toUpperCase();
				String age = record.get("Age");
				String position = record.get("Pos").toUpperCase();
				position = position.replace("/", "");
				if(position.isEmpty()) { position = "WR"; }
				String games = record.get("G");
				String gamesStarted = record.get("GS");
				String targets = record.get("Tgt");
				String receptions = record.get("Rec");
				String yards = record.get("Yds");
				String touchdowns = record.get("TD");
				String firstdowns = record.get("1D");
				String longest = record.get("Lng");
				String fumbles = record.get("Fmb");
				System.out.println(playerSplit[0] + " " + team + " " + age + " " + position + " " + games + " " + gamesStarted + " " +
						targets + " " + yards + " " + touchdowns + " " + firstdowns + " " + longest + " " + receptions
						+ " " + fumbles + " " + year);

				PreparedStatement pstmt = conn.prepareStatement(SQL);
				pstmt.setString(1, playerSplit[0].trim());
				pstmt.setString(2, team);
				pstmt.setInt(3, Integer.parseInt(age));
				pstmt.setString(4, position);
				pstmt.setInt(5, Integer.parseInt(games));
				pstmt.setInt(6, Integer.parseInt(gamesStarted));
				pstmt.setInt(7, Integer.parseInt(targets));
				pstmt.setInt(8, Integer.parseInt(receptions));
				pstmt.setInt(9, Integer.parseInt(yards));
				pstmt.setInt(10, Integer.parseInt(touchdowns));
				pstmt.setInt(11, Integer.parseInt(firstdowns));
				pstmt.setInt(12, Integer.parseInt(longest));
				pstmt.setInt(13, Integer.parseInt(fumbles));
				pstmt.setInt(14, year);
				pstmt.executeUpdate();
			}
		} catch (SQLException ex) {
			return ex.getMessage();
		}
		return "ingested";
	}

	@GetMapping({"/get/getAllKnownPlayersForPosition"})
	public Set<String> getAllKnownPlayersForPosition(final String position) {
		Set<String> retval = new TreeSet<>();

		if(position.equalsIgnoreCase("QB")) {
			String SQL = "SELECT player_name, position FROM passing_stats WHERE position LIKE '" + position + "'";

			try (Connection conn = connect();
				 Statement stmt = conn.createStatement();
				 ResultSet rs = stmt.executeQuery(SQL)) {

				while (rs.next()) {
					String playerName = rs.getString("player_name");
					retval.add(playerName);
				}

			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		} else if(position.equalsIgnoreCase("RB")) {
			String SQL = "SELECT player_name, position FROM rushing_stats WHERE position LIKE '" + position + "'";

			try (Connection conn = connect();
				 Statement stmt = conn.createStatement();
				 ResultSet rs = stmt.executeQuery(SQL)) {

				while (rs.next()) {
					String playerName = rs.getString("player_name");
					retval.add(playerName);
				}

			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		} else if(position.equalsIgnoreCase("WR")) {
			String SQL = "SELECT player_name, position FROM receiving_stats WHERE position LIKE '" + position + "'";

			try (Connection conn = connect();
				 Statement stmt = conn.createStatement();
				 ResultSet rs = stmt.executeQuery(SQL)) {

				while (rs.next()) {
					String playerName = rs.getString("player_name");
					retval.add(playerName);
				}

			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		} else if(position.equalsIgnoreCase("TE")) {
			String SQL = "SELECT player_name, position FROM receiving_stats WHERE position LIKE '" + position + "'";

			try (Connection conn = connect();
				 Statement stmt = conn.createStatement();
				 ResultSet rs = stmt.executeQuery(SQL)) {

				while (rs.next()) {
					String playerName = rs.getString("player_name");
					retval.add(playerName);
				}

			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}

		return retval;
	}
}
