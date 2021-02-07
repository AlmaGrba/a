package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objects.Home;

public class TestYT {
	
private static WebDriver driver;
	
	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver_win32\\ChromeDriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@Test (priority = 0)
	public void testPesma () {
		driver.navigate().to("https://www.youtube.com/");
		Home.searchSong(driver);
		
		String current = driver.getCurrentUrl();
		String expected = "https://www.youtube.com/results?search_query=rick+astley+never+gonna+give+you+up"; 
		
		Assert.assertEquals(current, expected);
	}
	
	@Test (priority = 3)
	public void pustiPesmu () {
		driver.navigate().to("https://www.youtube.com/results?search_query=rick+astley+never+gonna+give+you+up");
		Home.playSong(driver);
		
		String current = driver.getCurrentUrl();
		String expected = "https://www.youtube.com/watch?v=dQw4w9WgXcQ"; 
		
		Assert.assertEquals(current, expected); 
		
	}
	@Test (priority = 2)
	public void drugaPesma () {
		driver.navigate().to("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
		Home.playSong(driver);
		
		String current = driver.getCurrentUrl();
		String expected = "https://www.youtube.com/watch?v=izGwDsrQ1eQ"; 
		
		Assert.assertEquals(current, expected);
}
	
	@Test (priority = 1) 
	public void unosExcel () {
		driver.navigate().to(Home.URL);
		File f = new File("SUM");
		
		try {
			InputStream inp = new FileInputStream(f);
			HSSFWorkbook wb = new HSSFWorkbook(inp);
			Sheet sheet = wb.getSheetAt(0);
			Row row = sheet.getRow(0);
			Cell cell = row.getCell(0);
			String name = cell.toString();
			System.out.println(name);
			driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys(name);;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//driver.findElement(By.name(Home.URL));
	}
}
