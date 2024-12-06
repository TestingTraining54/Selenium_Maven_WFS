package testcases;

import java.sql.SQLException;

import org.testng.annotations.Test;

import utility.DbManager;

public class DBQuery {

	@Test
	public void makeDBConnection() throws SQLException, ClassNotFoundException {
		DbManager.setMysqlDbConnection();
		System.out.println(DbManager.getMysqlQuery("select tutorial_author from selenium where tutorial_id=3;"));
		

	}

}
