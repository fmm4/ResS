import org.openqa.selenium.chrome.ChromeDriver

driver = {
    File file = new File("C:/UFPE/2015.1/ESS/ResidueManager/ResS/chromedrivers/chromedriver.exe");
    System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
    new ChromeDriver();
}

baseUrl = "http://localhost:8070/"