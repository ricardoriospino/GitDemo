package dataBase.DatabaseTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class jdbcconection {

	public static void main(String[] args) throws SQLException {

		Connection con = DriverManager.getConnection
						("jdbc:mysql://localhost:3306/Qadbt?useSSL=false","root","mysql");
		
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select * from credentials where scenario = 'rewardscard'");
		
		while(rs.next()) {
			
		ChromeOptions options = new ChromeOptions(); 
		options.addArguments("--remote-allow-origins=*");	
		WebDriver driver = (WebDriver) new ChromeDriver(options);
		
		driver.get("https://login.salesforce.com");

		driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(rs.getString("username"));
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(rs.getString("password"));
		System.out.println("MALl");
		}		
	}		
}
