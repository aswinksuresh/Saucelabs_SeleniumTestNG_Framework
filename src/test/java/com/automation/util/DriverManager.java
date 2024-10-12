package com.automation.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
 static WebDriver driver;
 public static void createDriver(){
     driver = new ChromeDriver();
     driver.manage().window().maximize();
 }
 public static  WebDriver getDriver(){
     return driver;
 }
}
