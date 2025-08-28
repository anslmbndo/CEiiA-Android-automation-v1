package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.net.MalformedURLException;

public class LaunchAppTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium:platformName", "Android");
        caps.setCapability("appium:deviceName", "emulator-5554");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:appPackage", "com.ceiia.ayr");
        caps.setCapability("appium:appActivity", "com.ceiia.ayr.activities.splash.SplashActivity");
        

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

        Thread.sleep(5000);//wait for app to load. to be changed to dynamic wait later
        
        //welcome screen1 header verification
        WebElement welcomeScreen1Header = driver.findElement(By.id("com.ceiia.ayr:id/textView"));
        String actualwelcomeScreen1Header = welcomeScreen1Header.getText();
        String expectedwelcomeScreen1Header = "Value your CO2 savings";
        if(actualwelcomeScreen1Header.equals(expectedwelcomeScreen1Header)) {
        	System.out.println("Text header verification successful on welcome screen 1");
        }
        else {
        	System.out.println("Element not found");
        }
        SwipeActions.swipeLeft(driver);//swipe to next screen
        
        
        //welcome screen2 header verification
        WebElement welcomeScreen2Header = driver.findElement(By.id("com.ceiia.ayr:id/textView"));
        String actualwelcomeScreen2Header = welcomeScreen2Header.getText();
        String expectedwelcomeScreen2Header = "Add your electrical vehicles";
        if(actualwelcomeScreen2Header.equals(expectedwelcomeScreen2Header)) {
        	System.out.println("Text header verification successful on welcome screen 2");
        }
        else {
        	System.out.println("Element not found");
        }
        SwipeActions.swipeLeft(driver);//swipe to next screen
        
        
        //welcome screen3 header verification
        WebElement welcomeScreen3Header = driver.findElement(By.id("com.ceiia.ayr:id/textView"));
        String actualwelcomeScreen3Header = welcomeScreen3Header.getText();
        String expectedwelcomeScreen3Header = "Exchange your AYR credits";
        if(actualwelcomeScreen3Header.equals(expectedwelcomeScreen3Header)) {
        	System.out.println("Text header verification successful on welcome screen 3");
        }
        else {
        	System.out.println("Element not found");
        }
        SwipeActions.swipeLeft(driver);//swipe to next screen
        
        
        //welcome screen4 header verification
        WebElement welcomeScreen4Header = driver.findElement(By.id("com.ceiia.ayr:id/textView"));
        String actualwelcomeScreen4Header = welcomeScreen4Header.getText();
        String expectedwelcomeScreen4Header = "Do you want to know more about AYR?";
        if(actualwelcomeScreen4Header.equals(expectedwelcomeScreen4Header)) {
        	System.out.println("Text header verification successful on welcome screen 4");
        }
        else {
        	System.out.println("Element not found");
        }
        WebElement videoElement = driver.findElement(By.id("com.ceiia.ayr:id/videoView"));
        
        //comeback to view video playback later
        /*if (videoElement != null) {
            System.out.println("Video element is present. Clicking the video...");
            int centerX = videoElement.getLocation().getX() + videoElement.getSize().getWidth() / 2;
            int centerY = videoElement.getLocation().getY() + videoElement.getSize().getHeight() / 2;
            TouchAction actions = new TouchAction(driver);
            actions.tap(PointOption.point(centerX, centerY)).perform();
        }*/
        
        //press skip to go to login and sign up screen
        WebElement skipButton = driver.findElement(By.id("com.ceiia.ayr:id/button"));
        if (skipButton != null) {
            System.out.println("Skip button is displayed.");
            skipButton.click();
        }
        else {
        	System.out.println("Element not found");
        }
        
        //verify the tag line
        Thread.sleep(1000);
        WebElement loginScreentagline = driver.findElement(By.id("com.ceiia.ayr:id/splash_title_tv"));
        String actualloginScreentagline = loginScreentagline.getText();
        String actualTextNormalized = actualloginScreentagline.replace("\n", " ").replaceAll("\\s+", " ").trim();
        String expectedloginScreentagline = "Are you ready to build a carbon zero world?";
        if(actualTextNormalized.equals(expectedloginScreentagline)) {
        	
        	System.out.println("Text header verification successful on login and sign up screen");
        }
        else {
        	System.out.println("Actual text: " + actualloginScreentagline);
        	System.out.println("Normalized text: " + actualTextNormalized);
        	System.out.println("Element tagline not found");
        }
        
        
        //select country --- learn to scroll later on
        WebElement countryElement = driver.findElement(By.id("com.ceiia.ayr:id/selected_country_tv"));
        if (countryElement.isDisplayed()) {
            System.out.println("The country element is visible... Selecting country");
            countryElement.click();
            
            WebElement countryOption = driver.findElement(By.xpath("//android.widget.TextView[@text='Aruba (AW)']"));//FIND A WAY TO SCROLL!!!!!!
            countryOption.click();        
        }
        else {
        	System.out.println("Element not found");
        }
        
        //wait for the dropdown to close
        Thread.sleep(1000);

        //enter phone number
        WebElement phoneNumberField = driver.findElement(By.id("com.ceiia.ayr:id/login_phone_til")).findElement(By.className("android.widget.EditText"));
        if (phoneNumberField.isDisplayed()) {
            System.out.println("Phone number field is visible. Entering phone number...");
            phoneNumberField.click();
            phoneNumberField.sendKeys("55692829");
            driver.hideKeyboard();
        }
        else {
        	System.out.println("Element not found");
        }
        
        //enter password
        WebElement passwordField = driver.findElement(By.id("com.ceiia.ayr:id/login_password_til")).findElement(By.className("android.widget.EditText"));
        if (passwordField.isDisplayed()) {
            System.out.println("password field is visible. Entering phone number...");
            passwordField.click();
            passwordField.sendKeys("$Test123");
            driver.hideKeyboard();
        }
        else {
        	System.out.println("Element not found");
        }
        
        //press the submit button
        WebElement nextButton = driver.findElement(By.id("com.ceiia.ayr:id/login_btn"));
        if (nextButton != null) {
            System.out.println("next button is displayed.");
            nextButton.click();
        }
        else {
        	System.out.println("Element not found");
        }
        

        
        Thread.sleep(6000);
        
        driver.quit();
    }

}










