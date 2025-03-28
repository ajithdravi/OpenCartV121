package testBase;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BaseClass {

    public static WebDriver driver;
    public Logger logger;
    public Properties p;

    @Parameters({"os","browser"})
    @BeforeClass(groups = {"sanity","regression"})
    public void setup(String os,String br) throws IOException {
        FileReader fileReader=new FileReader("./src//test//resources//config.properties");
        p=new Properties();
        p.load(fileReader);

        logger= LogManager.getLogger(this.getClass());

        switch (br.toLowerCase())
        {
            case "chrome":
                driver=new ChromeDriver();
            break;

            case "firefox":
                driver=new FirefoxDriver();
                break;

            case "edge":
                driver=new EdgeDriver();
                break;

            default:
                logger.info("Invalid Browser");
                return;

        }

        driver.get(p.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterClass(groups = {"sanity","regression"})
    public void teardown()
    {
        driver.quit();
    }

    public String randomString()
    {
        String randomString=RandomStringUtils.randomAlphabetic(4);
        return randomString;
    }
    public String randomAlphaNumeric()
    {
        String randomString=RandomStringUtils.randomAlphabetic(4);
        String randomNumber=RandomStringUtils.randomNumeric(3);
        return (randomString+randomNumber);
    }

    public void scrollDown()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

    }

    public String captureScreen(String tname)
    {
        String timeStamp=new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
        TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
        File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
        String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_" +timeStamp +".png";
        File targetFile=new File(targetFilePath);
        sourceFile.renameTo(targetFile);
        return targetFilePath;
    }
}
