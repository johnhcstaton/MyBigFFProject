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

	/**
	 *
	 * @return
	 */
	@GetMapping({"/test/testEndpoint"})
	public String testEndpoint() {
		return "test";
	}

	/**
	 *
	 * @param year
	 * @param csvFile
	 * @return
	 * @throws IOException
	 */
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
				player = player.replace("'", "");
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

	/**
	 *
	 * @param year
	 * @param csvFile
	 * @return
	 * @throws IOException
	 */
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
				player = player.replace("'", "");
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

	/**
	 *
	 * @param year
	 * @param csvFile
	 * @return
	 * @throws IOException
	 */
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
				player = player.replace("'", "");
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

	/**
	 *
	 * @param position
	 * @return
	 */
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

	/**
	 *
	 * @param playerName
	 * @param position
	 * @return
	 */
	@GetMapping({"/get/getCompsForPlayerAndPosition"})
	public Map<String, Double> getCompsForPlayerAndPosition(final String playerName, final String position) {
		HashMap<String, Double> playerComps = new HashMap<>();

		Set<String> allPlayersForPosition = getAllKnownPlayersForPosition(position);

		for(String possiblePlayerComp : allPlayersForPosition) {
			//ensure we're not comparing a player to themselves
			if(!playerName.equalsIgnoreCase(possiblePlayerComp)) {
				//compare playerName and possiblePlayerComp and get "Comparison Score"
				Double comparisonScore = compareTwoPlayers(playerName, possiblePlayerComp, position);
				if(comparisonScore != 0.0) {
					playerComps.put(possiblePlayerComp, comparisonScore);
				}
			}
		}

		//Sort playerComps by Comparison Score
		
		return playerComps;
	}

	/**
	 *
	 * @param player1Name
	 * @param player2Name
	 * @param position
	 * @return
	 */
	private Double compareTwoPlayers(final String player1Name, final String player2Name, final String position) {
		Double retval = 0.0;

		Player player1 = getPlayerFromDB(player1Name, position);
		Player player2 = getPlayerFromDB(player2Name, position);

		//First check is that we want to make sure that Player 2 has MORE seasons than Player 1, this is because
		//we want to be able to use the comparison to project the next seasons for Player 1
		int player1SeasonCount = 0; int player2SeasonCount = 0;
		if(position.equalsIgnoreCase("QB")) {
			player1SeasonCount = player1.getPassingStats().keySet().size();
			player2SeasonCount = player2.getPassingStats().keySet().size();
		} else if(position.equalsIgnoreCase("RB")) {
			player1SeasonCount = player1.getRushingStats().keySet().size();
			player2SeasonCount = player2.getRushingStats().keySet().size();
		} else {
			player1SeasonCount = player1.getReceivingStats().keySet().size();
			player2SeasonCount = player2.getReceivingStats().keySet().size();
		}

		if(player2SeasonCount > player1SeasonCount) {
//			System.out.println("Can compare " + player1Name + " to " + player2Name);
			if(position.equalsIgnoreCase("QB")) {
				// compare passing and rushing
				Double totalPassingSimilarity = 0.0;
				final Map<Integer, Map<String, Object>> p1PassingStats = player1.getPassingStats();
				final Map<Integer, Map<String, Object>> p2PassingStats = player2.getPassingStats();
				Integer firstP2Year = p2PassingStats.keySet().iterator().next();
				int count = 0;
				for(Integer player1Year : p1PassingStats.keySet()) {
					final Map<String, Object> p1PassingForYear = p1PassingStats.get(player1Year);
					final Map<String, Object> p2PassingForYear = p2PassingStats.get(firstP2Year + count);
					//now we can compare two seasons of passing stats against each other and get a score of 0-100 similarity
					if(p1PassingForYear != null && p2PassingForYear != null) {
						Double seasonPassingSimilarity = compareTwoPassingSeasons(p1PassingForYear, p2PassingForYear);
						totalPassingSimilarity += seasonPassingSimilarity;
					}
					count++;
				}
				totalPassingSimilarity = totalPassingSimilarity / player1SeasonCount;
				System.out.println("Total passing similarity for " + player1Name + " & " + player2Name + ": " + totalPassingSimilarity);
				retval = totalPassingSimilarity;
			} else {
				// comparing rushing and receiving
			}
		}

		return retval;
	}

	/**
	 *
	 * @param playerName
	 * @param position
	 * @return
	 */
	private Player getPlayerFromDB(final String playerName, final String position) {
		Player retval = new Player();
		retval.setName(playerName);
		retval.setPosition(position);

		if(position.equalsIgnoreCase("QB")) {
			// Get from passing
			String passingSQL = "SELECT player_name, team, age, \"position\", games_played, games_started, " +
				"passes_completed, passes_attempted, passing_yards, passing_touchdowns, interceptions, " +
				"first_downs_passing, longest_pass, sacks, year\n" +
				"FROM passing_stats\n" +
				"WHERE player_name LIKE '" + playerName + "';";

			try(Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(passingSQL)) {

				while(rs.next()) {
					//get the whatnots from the resultset and add them to the player stats
					HashMap<String, Object> statsMap = new HashMap<>();
					statsMap.put("team", rs.getString("team"));
					statsMap.put("age", rs.getInt("age"));
					statsMap.put("games_played", rs.getInt("games_played"));
					statsMap.put("games_started", rs.getInt("games_started"));
					statsMap.put("passes_completed", rs.getInt("passes_completed"));
					statsMap.put("passes_attempted", rs.getInt("passes_attempted"));
					statsMap.put("passing_yards", rs.getInt("passing_yards"));
					statsMap.put("passing_touchdowns", rs.getInt("passing_touchdowns"));
					statsMap.put("interceptions", rs.getInt("interceptions"));
					statsMap.put("first_downs_passing", rs.getInt("first_downs_passing"));
					statsMap.put("longest_pass", rs.getInt("longest_pass"));
					statsMap.put("sacks", rs.getInt("sacks"));
					retval.setPassingStat(statsMap, rs.getInt("year"));
				}

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		// then get from rushing
		String rushingSQL = "SELECT player_name, team, age, \"position\", games_played, games_started, " +
				"rushing_attempts, rushing_yards, rushing_touchdowns, rushing_first_downs, longest_rush, " + "" +
				"rushing_yards_per_attempt, rushing_yards_per_game, fumbles, year\n" +
				"FROM rushing_stats\n" +
				"WHERE player_name LIKE '" + playerName + "';";

		try(Connection conn = connect();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(rushingSQL)) {

			while(rs.next()) {
				//get the whatnots from the resultset and add them to the player stats
				HashMap<String, Object> statsMap = new HashMap<>();
				statsMap.put("team", rs.getString("team"));
				statsMap.put("age", rs.getInt("age"));
				statsMap.put("games_played", rs.getInt("games_played"));
				statsMap.put("games_started", rs.getInt("games_started"));
				statsMap.put("rushing_attempts", rs.getInt("rushing_attempts"));
				statsMap.put("rushing_yards", rs.getInt("rushing_yards"));
				statsMap.put("rushing_touchdowns", rs.getInt("rushing_touchdowns"));
				statsMap.put("rushing_first_downs", rs.getInt("rushing_first_downs"));
				statsMap.put("longest_rush", rs.getInt("longest_rush"));
				statsMap.put("fumbles", rs.getInt("fumbles"));
				retval.setRushingStat(statsMap, rs.getInt("year"));
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		// then get from receiving
		String receivingSQL = "SELECT player_name, team, age, \"position\", games_played, games_started, targets, " +
				"receptions, receiving_yards, receiving_touchdowns, first_downs_receiving, longest_reception, fumbles, year\n" +
				"FROM receiving_stats\n" +
				"WHERE player_name LIKE '" + playerName + "';";

		try(Connection conn = connect();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(receivingSQL)) {

			while(rs.next()) {
				//get the whatnots from the resultset and add them to the player stats
				HashMap<String, Object> statsMap = new HashMap<>();
				statsMap.put("team", rs.getString("team"));
				statsMap.put("age", rs.getInt("age"));
				statsMap.put("games_played", rs.getInt("games_played"));
				statsMap.put("games_started", rs.getInt("games_started"));
				statsMap.put("targets", rs.getInt("targets"));
				statsMap.put("receptions", rs.getInt("receptions"));
				statsMap.put("receiving_yards", rs.getInt("receiving_yards"));
				statsMap.put("receiving_touchdowns", rs.getInt("receiving_touchdowns"));
				statsMap.put("first_downs_receiving", rs.getInt("first_downs_receiving"));
				statsMap.put("longest_reception", rs.getInt("longest_reception"));
				statsMap.put("fumbles", rs.getInt("fumbles"));
				retval.setReceivingStat(statsMap, rs.getInt("year"));
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return retval;
	}

	/**
	 *
	 * @param p1PassingForYear
	 * @param p2PassingForYear
	 * @return
	 */
	private Double compareTwoPassingSeasons(final Map<String, Object> p1PassingForYear,
											final Map<String, Object> p2PassingForYear) {
		Double retval = 0.0;

//		passes_completed
		Double passesCompletedSimilarity = compareTwoNumbers((Integer) p2PassingForYear.get("passes_completed"),
				(Integer) p1PassingForYear.get("passes_completed")) * 100;  // 0 will mean completely dissimilar, 100 will mean exactly the same
//		passes_attempted
		Double passesAttemptedSimilarity = compareTwoNumbers((Integer) p2PassingForYear.get("passes_attempted"),
				(Integer) p1PassingForYear.get("passes_attempted")) * 100;
//		passing_yards
		Double passingYardsSimilarity = compareTwoNumbers((Integer) p2PassingForYear.get("passing_yards"),
				(Integer) p1PassingForYear.get("passing_yards")) * 100;
//		passing_touchdowns
		Double passingTdsSimilarity = compareTwoNumbers((Integer) p2PassingForYear.get("passing_touchdowns"),
				(Integer) p1PassingForYear.get("passing_touchdowns")) * 100;
//		interceptions
		Double intsSimilarity = compareTwoNumbers((Integer) p2PassingForYear.get("interceptions"),
				(Integer) p1PassingForYear.get("interceptions")) * 100;
//		first_downs_passing
		Double firstDownsSimilarity = compareTwoNumbers((Integer) p2PassingForYear.get("first_downs_passing"),
				(Integer) p1PassingForYear.get("first_downs_passing")) * 100;
//		longest_pass
		Double longestPassSimilarity = compareTwoNumbers((Integer) p2PassingForYear.get("longest_pass"),
				(Integer) p1PassingForYear.get("longest_pass")) * 100;
//		sacks
		Double sacksSimilarity = compareTwoNumbers((Integer) p2PassingForYear.get("sacks"),
				(Integer) p1PassingForYear.get("sacks")) * 100;

		retval = (passesCompletedSimilarity + passesAttemptedSimilarity + passingYardsSimilarity + passingTdsSimilarity +
				intsSimilarity + firstDownsSimilarity + longestPassSimilarity + sacksSimilarity)/8;

		return retval;
	}

	/**
	 * 
	 * @param number1
	 * @param number2
	 * @return
	 */
	private Double compareTwoNumbers(Integer number1, Integer number2) {
		if(number1 > number2 && number1 != 0) {
			return ((double) number2 / (double) number1);
		} else {
			if(number2 != 0) {
				return ((double) number1 / (double) number2);
			} else {
				return 0.0;
			}
		}
	}
}
