package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Home {
	
	public static final String URL = "https://www.youtube.com/";
	public static final String URL_SEARCH = "https://www.youtube.com/results?search_query=rick+astley+never+gonna+give+you+up"; 
	public static final String URL_SONG = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";
	public static final String NEW_SONG = "https://www.youtube.com/watch?v=izGwDsrQ1eQ";
	
	public static void searchSong (WebDriver driver) {
		
		driver.get(URL);
		driver.findElement(By.xpath("//*[@id=\"search\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys("Rick Astley Never gonna give you up");
		driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys(Keys.ENTER);
	}
	
	public static void playSong (WebDriver driver) {
		driver.findElement(By.xpath("//*[@id=\"video-title\"]/yt-formatted-string")).click();
	}
	
	public static void seconSong (WebDriver driver) {
		driver.findElement(By.xpath("/html/body/ytd-app/div/ytd-page-manager/ytd-watch-flexy/div[5]/div[2]/div/div[3]/ytd-watch-next-secondary-results-renderer/div[2]/ytd-compact-video-renderer[1]/div[1]/div/div[1]/a/h3/span")).click();
}
}
