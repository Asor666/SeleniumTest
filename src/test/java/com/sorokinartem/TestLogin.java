package com.sorokinartem;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class TestLogin {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;

    /*настройка перед тестом*/
    @BeforeClass
    public static void setup() {
        /*определяем путь к драйверу из файла настроек*/
        System.setProperty("webdriver.chrome.driver",ConfProperties.getProperty("chromedriver"));
        /*создаем экземпляр драйвера*/
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        /*фулскрин */
        driver.manage().window().maximize();
        /*задержка что бы страница прогрузилась 5 сек*/
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        /*получаем ссылку главной страницы из файла настроек*/
        driver.get(ConfProperties.getProperty("mainpage"));

    }
    /*тест*/
    @Test
    public void loginTest(){
        /*нажимаем кнопку открытия окна SignIn*/
        loginPage.clickSingInOpenBtn();
        /*вводим логин из файла настроек*/
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        /*вводим пароль из файла настроек*/
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        /*нажимаем кнопку входа*/
        loginPage.clickSignInBtn();

    }

    @AfterClass
    public static void tearDown(){
        /*нажимаем иконку меню профиля*/
        profilePage.openMenuProfile();
        /*нажимаем кнопку SignOut*/
        profilePage.userLogout();
        /*закрываем браузер*/
        driver.quit();
    }

}
