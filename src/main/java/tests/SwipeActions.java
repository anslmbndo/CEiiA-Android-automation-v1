package tests;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.time.Duration;
public class SwipeActions {
	
	// Method to swipe right
    public static void swipeRight(AndroidDriver driver) {
        // Get the screen size (for swipe coordinates)
    	// Get the screen size (for swipe coordinates)
        Dimension size = driver.manage().window().getSize();
        int screenWidth = size.width;
        int screenHeight = size.height;

        // Define start and end points for the swipe (from left to right)
        int startX = (int) (screenWidth * 0.1); // Start at 10% of the screen width
        int endX = (int) (screenWidth * 0.9);  // End at 90% of the screen width
        int startY = screenHeight / 2; // Vertically centered

        // Create a pointer input for touch actions
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        // Create the actions sequence
        Sequence swipe = new Sequence(finger, 0);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, startY)); // Swipe to the right
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Execute the action
        driver.perform(Arrays.asList(swipe));
    }
    
 // Method to swipe left
    public static void swipeLeft(AndroidDriver driver) {
        // Get the screen size (for swipe coordinates)
        Dimension size = driver.manage().window().getSize();
        int screenWidth = size.width;
        int screenHeight = size.height;

        // Define start and end points for the swipe (from right to left)
        int startX = (int) (screenWidth * 0.9); // Start at 90% of the screen width
        int endX = (int) (screenWidth * 0.1);  // End at 10% of the screen width
        int startY = screenHeight / 2; // Vertically centered

        // Create a pointer input for touch actions
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        // Create the actions sequence for swipe left
        Sequence swipe = new Sequence(finger, 0);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, startY)); // Swipe to the left
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Execute the swipe action
        driver.perform(Arrays.asList(swipe));
    }

}
