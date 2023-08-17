import java.sql.*;
import java.util.*;

public class Database {
	private Connection conn = null;

	Database() {
		try {
			String url = "jdbc:mysql://localhost:3306/cs630";
			String user = "root";
			String password = "C1@ssPr0ject";

			// Create the connection
			this.conn = DriverManager.getConnection(url, user, password);
			System.out.println("Database connection created");
			// Statement stmt = this.conn.createStatement();
			// ResultSet rs = stmt.executeQuery("SELECT username, password FROM
			// cs630.usertable");
		} catch (SQLException e) {
			System.err.println("Could not connect to database");
			e.printStackTrace();
		}
	}

	public boolean userValidation(String username, String password) {
		try {
			Statement stmt = conn.createStatement();
			// ResultSet rs = stmt.executeQuery("SELECT username, password FROM
			// cs630.usertable");
			ResultSet rs = stmt.executeQuery(
					"SELECT username, password FROM cs630.usertable WHERE username = " + "\"" + username + "\"");
			if (rs.next()) {
				String returnedPassword = rs.getString("password");
				if (returnedPassword.equals(password)) {
					return true;
				}
			}
		} catch (SQLException e) {
			System.err.println("Could not find user/password in database");
			e.printStackTrace();
		}
		return false;
	}

	public boolean createUser(String username, String password, String fullName, String email, String phoneNumber,
			String dateOfBirth, String question1, String answer1, String question2, String answer2, String question3,
			String answer3, String pickedPicture) {
		try {
			Statement stmt = conn.createStatement();
			System.out.println("INSERT INTO cs630.usertable (username, password, fullname, email, phonenumber,"
					+ " dateofbirth, question1, answer1, question2, answer2, question3, answer3, pickedpicture)"
					+ " VALUES (\'" + username + "\', \'" + password + "\', \'" + fullName + "\', \'" + email + "\', \'"
					+ phoneNumber + "\', \'" + dateOfBirth + "\', \'" + question1 + "\', \'" + answer1 + "\', \'"
					+ question2 + "\', \'" + answer2 + "\', \'" + question3 + "\', \'" + answer3 + "\', \'"
					+ pickedPicture + "\')");
			boolean successFlag = stmt.execute("INSERT INTO cs630.usertable (username, password, fullname, email, phonenumber,"
					+ " dateofbirth, question1, answer1, question2, answer2, question3, answer3, pickedpicture)"
					+ " VALUES (\'" + username + "\', \'" + password + "\', \'" + fullName + "\', \'" + email + "\', \'"
					+ phoneNumber + "\', \'" + dateOfBirth + "\', \'" + question1 + "\', \'" + answer1 + "\', \'"
					+ question2 + "\', \'" + answer2 + "\', \'" + question3 + "\', \'" + answer3 + "\', \'"
					+ pickedPicture + "\')");
			return successFlag;
		} catch (SQLException e) {
			System.err.println("Could not insert user into database");
			e.printStackTrace();
		}
		return false;
	}

	public String getValueUsertable(String username, String columnName) {
		try {
			Statement stmt = conn.createStatement();
			System.out.println("SELECT username," + columnName + " FROM cs630.usertable WHERE username = " + "\'"
					+ username + "\'");
			ResultSet rs = stmt.executeQuery("SELECT username," + columnName + " FROM cs630.usertable WHERE username = "
					+ "\'" + username + "\'");
			if (rs.next()) {
				String columnValue = rs.getString(columnName);
				return columnValue;
			}
		} catch (SQLException e) {
			System.err.println("Could not get user from database");
			e.printStackTrace();
		}
		return "";
	}

	public boolean setValueUsertable(String username, String columnName, String enteredValue) {
		try {
			Statement stmt = conn.createStatement();
			boolean successFlag = stmt.execute(
					"INSERT INTO cs630.usertable (username," + columnName + ") VALUES ( /' " + enteredValue + "/')");
			return successFlag;
		} catch (SQLException e) {
			System.err.println("Could not get user from database");
			e.printStackTrace();
		}
		return false;
	}

	public boolean addUserToUsertable(String username) {
		try {
			Statement stmt = conn.createStatement();
			System.out.println("INSERT INTO cs630.usertable (\'" + username + "\')");
			boolean successFlag = stmt.execute("INSERT INTO cs630.usertable (\'" + username + "\')");
			return successFlag;
		} catch (SQLException e) {
			System.err.println("Could not add user to database");
			e.printStackTrace();
		}
		return false;
	}
	public boolean createDataRow(String username, String date,String timeOfTestAM, String bloodSugarAM, String breakfastMenu, String lunchMenu,
			String dinnerMenu, String timeOfTestPM, String bloodSugarPM) {
		try {
			Statement stmt = conn.createStatement();
			boolean successFlag = stmt.execute("INSERT INTO cs630.diabetesdata (username, date, time_of_test_am, blood_sugar_level_am, breakfast_menu, lunch_menu,"
					+ " dinner_menu, time_of_test_pm, blood_sugar_level_pm)"
					+ " VALUES (\'" + username + "\', \'" + date + "\', \'" + timeOfTestAM + "\', \'" + bloodSugarAM + "\', \'" + breakfastMenu + "\', \'"
					+ lunchMenu + "\', \'" + dinnerMenu + "\', \'" + timeOfTestPM + "\', \'" + bloodSugarPM + "\')");
			return successFlag;
		} catch (SQLException e) {
			System.err.println("Could not insert user into database");
			e.printStackTrace();
		}
		return false;
	}
	public ArrayList<String[]> getDataRows(String username) {
		ArrayList<String[]> rows = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT username,date, time_of_test_am, blood_sugar_level_am, breakfast_menu, lunch_menu,dinner_menu,time_of_test_pm, blood_sugar_level_pm FROM cs630.diabetesdata WHERE username = " + "\"" + username + "\"");
			while(rs.next()) {
				String[] row = {rs.getString("username"), rs.getString("date"), rs.getString("time_of_test_am"),
						rs.getString("blood_sugar_level_am"),
						rs.getString("breakfast_menu"), rs.getString("lunch_menu"), rs.getString("dinner_menu"),rs.getString("time_of_test_pm"),
						rs.getString("blood_sugar_level_pm")};
				System.out.println(row);
				rows.add(row);

			}
		} catch (SQLException e) {
			System.err.println("Could not get user from database");
			e.printStackTrace();
		}
		return rows;
	}
	
	public boolean updateValueUsertable(String username, String columnName, String enteredValue) {
		try {
			Statement stmt = conn.createStatement();
			boolean successFlag = stmt.execute(
					"UPDATE cs630.usertable SET " + columnName + " = " + "\'" + enteredValue + "\'" + " WHERE username = " + "\'" + username + "\'");
			return successFlag;
		} catch (SQLException e) {
			System.err.println("Could not get user from database");
			e.printStackTrace();
		}
		return false;
	}
	public boolean passwordStrengthCheck(String password) {
		char ch;
		boolean capitalFlag = false;
		boolean lowerCaseFlag = false;
		boolean numberFlag = false;
		boolean lengthFlag = (password.length()>7);
		boolean symbolFlag = false;
		String specialCharacters = " !#$%&()*+,-.:;<=>?@[]^_`{|}~";
		for(int i=0;i < password.length();i++) {
			ch = password.charAt(i);
			if( Character.isDigit(ch)) {
				numberFlag = true;
			}
			else if (Character.isUpperCase(ch)) {
				capitalFlag = true;
			} else if (Character.isLowerCase(ch)) {
				lowerCaseFlag = true;
			}
			else if(specialCharacters.contains(String.valueOf(ch))) {
				symbolFlag = true;
			}
			if(numberFlag && capitalFlag && lowerCaseFlag && lengthFlag && symbolFlag)
				return true;
			
		}
		return false;
	}

	public boolean updateUser(String username, String password, String fullName, String email, String phoneNumber,
			String dateOfBirth, String question1, String answer1, String question2, String answer2, String question3,
			String answer3, String pickedPicture) {
		updateValueUsertable(username, "password", password);
		updateValueUsertable(username, "fullname", fullName);
		updateValueUsertable(username, "email", email);
		updateValueUsertable(username, "phonenumber", phoneNumber);
		updateValueUsertable(username, "dateofbirth", dateOfBirth);
		updateValueUsertable(username, "question1", question1);
		updateValueUsertable(username, "answer1", answer1);
		updateValueUsertable(username, "question2", question2);
		updateValueUsertable(username, "answer2", answer2);
		updateValueUsertable(username, "question3", question3);
		updateValueUsertable(username, "answer3", answer3);
		updateValueUsertable(username, "pickedpicture", pickedPicture);
		return true;
	}
}