package com.sorokinartem;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
    /*конструктор класса, инициализирует поля*/
    public WebDriver driver;
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    /*определяем локатор кнопки открытия окна Sing In*/
    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div[7]/a[1]")
    private WebElement singInOpenBtn;

    /*определяем локатор поля ввода логина*/
    @FindBy(xpath="//*[@id='signInEmail']")
    private WebElement loginField;

    /*определяем локатор поля ввода пароля*/
    @FindBy(xpath = "//*[@id='signInPassword']")
    private WebElement passField;

    /*определяем локатор кнопки SignIn*/
    @FindBy(xpath = "//*[@id='signInModalForm']/div[3]/input")
    private WebElement signInBtn;

    /*Метод нажатия кнопки открытия окна SignIn*/
    public void clickSingInOpenBtn() {
        singInOpenBtn.click();
    }

    /*Метод ввода логина*/
    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    /*Метод ввода пароля*/
    public void inputPasswd(String passwd) {
        passField.sendKeys(passwd);
    }
    /*Метод нажатия кнопки SignIn*/
    public void clickSignInBtn() {
        signInBtn.click();
    }
}
