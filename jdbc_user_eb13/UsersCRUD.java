package jdbc_user_eb13;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import com.mysql.cj.jdbc.Driver;

public class UsersCRUD {

	public Connection getConnection() throws Exception {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);

		FileInputStream fileInputStream = new FileInputStream("dbconfig.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);

		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("username"), properties.getProperty("password"));
		return connection;
	}

	public void signupUser(Users users) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("insert into users (id,name,email,password,address)values(?,?,?,?,?)");
		preparedStatement.setInt(1, users.getId());
		preparedStatement.setString(2, users.getName());
		preparedStatement.setString(3, users.getEmail());
		preparedStatement.setString(4, users.getPassword());
		preparedStatement.setString(5, users.getAddress());
		int saved = preparedStatement.executeUpdate();
		if (saved == 1) {
			System.out.println("Saved successfully");
		} else {
			System.out.println("Not saved");
		}

		connection.close();
		System.out.println("Inserted");
	}

	public boolean loginUser(Users users) throws Exception {

		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from users where email=?");
		preparedStatement.setString(1, users.getEmail());
		ResultSet resultSet = preparedStatement.executeQuery();
		String password = null;
		while (resultSet.next()) {
			password = resultSet.getString("password");
		}
		if (password.equals(users.getPassword())) {
			return true;
		}
		return false;
	}

	public void resetFacebookPassword(String facebookPassword, String email) throws Exception {
		String query = "update users set facebookPassword=? where email=?";
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, facebookPassword);
		preparedStatement.setString(2, email);
		preparedStatement.execute();
		connection.close();
	}

	public void resetInstagramPassword(String instaPassword, String email) throws Exception {
		String query = "update users set instagramPassword=? where email=?";
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, instaPassword);
		preparedStatement.setString(2, email);
		preparedStatement.execute();
		connection.close();
	}

	public void resetSnapchatPassword(String snapchatPassword, String email) throws Exception {
		String query = "update users set snapchatPassword=? where email=?";
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, snapchatPassword);
		preparedStatement.setString(2, email);
		preparedStatement.execute();
		connection.close();
	}

	public void resetWhatsappPassword(String whatsappPassword, String email) throws Exception {
		String query = "update users set whatsappPassword=? where email=?";
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, whatsappPassword);
		preparedStatement.setString(2, email);
		preparedStatement.execute();
		connection.close();
	}

	public void resetTwitterPassword(String twitterPassword, String email) throws Exception {
		String query = "update users set twitterPassword=? where email=?";
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, twitterPassword);
		preparedStatement.setString(2, email);
		preparedStatement.execute();
		connection.close();
	}

	public Users getUsers(String email) throws Exception {
		String query = "select*from users where email=?";
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, email);
		ResultSet resultSet = preparedStatement.executeQuery();
		Users users = new Users();
		while (resultSet.next()) {
			users.setId(resultSet.getInt(1));
			users.setName(resultSet.getString(2));
			users.setEmail(resultSet.getString(3));
			users.setPassword(resultSet.getString(4));
			users.setAddress(resultSet.getString(5));
			users.setFacebook_password(resultSet.getString(6));
			users.setInstagram__password(resultSet.getString(7));
			users.setSnapchat_password(resultSet.getString(8));
			users.setWhatsapp_password(resultSet.getString(9));
			users.setTwitter_password(resultSet.getString(10));

		}
		return users;
	}
}
