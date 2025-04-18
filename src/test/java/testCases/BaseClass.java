package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;


public class BaseClass { // ✅ Class name added

    public WebDriver driver;
    public Logger logger;
    public Properties p;

    @BeforeClass(groups={"Sanity","Regression","Master",})
    @Parameters({"os","browser"})
    public void setup(String os,String br) throws IOException {
    	//LOADING CONFIG.PROPERTIES FILE
    	FileReader  file=new FileReader("./src//test//resources//config.properties"); 
    	p=new Properties();
    	p.load(file);
        logger = LogManager.getLogger(this.getClass());
        if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
        {
        	DesiredCapabilities capabilities=new DesiredCapabilities();
        	//os
        	if(os.equalsIgnoreCase("windows"))
        	{
        		capabilities.setPlatform(Platform.WIN10);
        	}
        	else if (os.equalsIgnoreCase("mac"))
        	{
        		capabilities.setPlatform(Platform.WIN10);
        	}
        	else
        	{
        		 System.out.println("No matching os");
        		 return;
        	}
        	//browser
        	switch(br.toLowerCase())
        	{
        	case "chrome": capabilities.setBrowserName("chrome");break;
        	case "edge":capabilities.setBrowserName("MicrosoftEdge");break;
        	
        	}
        	
        	//capabilities.setBrowserName("chrome")
        }
        switch(br.toLowerCase())
        {
        case "chrome" : driver=new ChromeDriver(); break;
        case "edge" : driver=new EdgeDriver(); break;
        case "firefox" : driver=new FirefoxDriver();  break;
        default:System.out.println("no matching browser");return;
        driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub")),capabilities;
      //  driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub")),capabilities;
        }
        
        
        
        
     
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("appURL2"));//reading url from properties file.     
    }

    @AfterClass(groups={"Sanity","Regression","Master"})
    public void tearDown() {
        driver.quit();
    }

    // ✅ Utility methods for random data
    public String randomString() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String randomNumber() {
        return RandomStringUtils.randomNumeric(10);
    }

    public String randomAlphaNumeric() {
        String str = RandomStringUtils.randomAlphabetic(3);
        String num = RandomStringUtils.randomNumeric(3);
        return str + "@" + num;
    }
}





















































































/*package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
	public WebDriver driver;
	public Logger logger;
	@BeforeClass
	public void setup()
	{
		logger=LogManager.getLogger(this.getClass());
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();

	    // Set implicit wait
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	    // Open URL
	    driver.get("https://tutorialsninja.com/demo/");
	    driver.manage().window().maximize();
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	 //How we can generate random data.
    
	  public String randomString()
	  {
		 String generatedString=RandomStringUtils.randomAlphabetic(5);//predifine class conmmons.lang3 libraray
	     return generatedString;
	  }
	    
	  public String randomeNumber()
	  {
		 String generatednumber=RandomStringUtils.randomNumeric(10);//predifine class conmmons.lang3 libraray
	     return generatednumber;
	  }
	     
	  public String randomeAlphaNumeric()
	  {
		 String generatedString=RandomStringUtils.randomAlphabetic(3);
		 String generatednumber=RandomStringUtils.randomNumeric(3);//predifine class conmmons.lang3 libraray
	     return (generatedString+"@"+generatednumber);
	  }
}
*/