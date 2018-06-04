package com.s14014.tau.jbhsl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
@Ignore
public class SiteTest {

    private static WebDriver driver;
    WebElement element;

    @Before
            public void driverSetup(){

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true);
        caps.setCapability("takeScreenshot", true);
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                "C:\\phantom js\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
        caps.setCapability("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");




    }



	@Test
	public void clickAndSelectTab() throws IOException {
		driver.get("https://github.com/Sinnlos");
		// tab
		WebElement e;

        driver.findElement(By.linkText("pierchem-app")).click();
        driver.findElement(By.linkText("src")).click();
        driver.findElement(By.linkText("main")).click();
        driver.findElement(By.linkText("java")).click();
        driver.findElement(By.linkText("com/s14014/tau")).click();
        driver.findElement(By.linkText("domain")).click();
        driver.findElement(By.linkText("Pierwiastek.java")).click();

        e = driver.findElement(By.cssSelector("#LC14"));

		assertTrue(!e.getAttribute("class").contains("public class Pierwiastek"));
		File screenshot =
				((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("pier.1.png"));
		e.click();
		assertTrue(e.getAttribute("class").contains("public class Pierwiastek"));
		screenshot =
				((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("pier.2.png"));
		assertNotNull(e);
	}



	@After
	public void cleanp() {
		driver.quit();
	}
}
