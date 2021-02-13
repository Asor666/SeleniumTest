package com.sorokinartem;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

public class ProfilePage {
    /*конструктор*/
    public WebDriver driver;
    public ProfilePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver =driver;
    }
    /*определение кнопки меню профиля*/
    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div[6]/div")
    private WebElement menuOption;
    /*определение кнопки выхода из аккаунта*/
    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div[6]/div/div/a[4]")
    private WebElement logoutBtn;

    /*метод нажатие на кнопку меню профиля*/
    public void openMenuProfile(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        menuOption.click();

    }
    /*метод нажатия кнопки выхода из аккаунта*/
    public void userLogout(){
        logoutBtn.click();
    }


}

