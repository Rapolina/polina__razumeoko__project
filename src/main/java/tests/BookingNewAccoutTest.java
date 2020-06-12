package tests;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import settings.Config;
import web_driver.Driver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BookingNewAccoutTest {
    static String PWD = "abc12345";
    static String yandexEmail = "polina.razumeiko@yandex.ru";
    static String yandexPassword = "Nobody12345";
static String confirmButton = "//*[@id=\"4f3bf1e55c27ef3bemail_body\"]/tbody/tr/td/table[2]/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[5]/td/table/tbody/tr/td/a";
    @Before
    public void beforeMethod() {
        Driver.initDriver(Config.CHROME);
        //   TrashMailNewUser.trashMailGetNewMail();
    }

    @Test
    public void createNewUserTest() throws IOException, InterruptedException {
        Driver.getDriver().get("https://trashmail.com/");
        setTrashmailParameters();
        if (Driver.getDriver().findElements(By.xpath("//*[contains(text(), \"address is not registered\")]")).size() > 0) {
            createNewUser();
            confirmOnEmail("//*[contains(text(), 'trashmail.com')]", "//*[contains(@href, \"trashmail.com\")]",false);
            createNewUserTest();
        }
        bookingNewUser();
        confirmOnEmail("//*[contains(text(), 'booking.com')]", confirmButton,true);
       // bookingLogIn();
        Driver.getDriver().get("https://www.booking.com/");
        Thread.sleep(500);
        Driver.getDriver().findElement(By.xpath("//*[@id=\"profile-menu-trigger--content\"]")).click();
        Driver.getDriver().findElement(By.xpath("//*[contains(@class, \"mydashboard\")]")).click();
        Assert.assertEquals(Driver.getDriver().findElements(By.xpath("//*[@class=\"email-confirm-banner\"]")).size(), 0);

    }

    private void createNewUser() throws InterruptedException {
        Driver.getDriver().findElement(By.xpath("//*[contains(@href, \"mob-register\")]")).click();
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.xpath("//*[@id=\"tab-mob-register\"]/form/div[1]/input")).sendKeys(Keys.chord(Keys.COMMAND, "a"),"UserCucuser");
        Driver.getDriver().findElement(By.xpath("//*[@id=\"tab-mob-register\"]/form/div[2]/input")).sendKeys(PWD);
        Driver.getDriver().findElement(By.xpath("//*[@id=\"tab-mob-register\"]/form/div[3]/input")).sendKeys(PWD);
        Driver.getDriver().findElement(By.xpath("//*[@id=\"tab-mob-register\"]/form/div[6]/button")).click();
        Thread.sleep(3000);
    }

    public static void confirmOnEmail(String siteXpath, String confirmButtonXpath, boolean spam) throws InterruptedException, IOException {
        Driver.getDriver().get("https://mail.yandex.ru/");
        Thread.sleep(2000);
        Driver.getDriver().findElement(By.xpath("//*[contains(@class, \"HeadBanner-Button-Enter\")]")).click();
        Driver.getDriver().findElement(By.xpath("//*[@id= \"passp-field-login\"]")).sendKeys(yandexEmail);
        Driver.getDriver().findElement(By.xpath("//*[contains(@class, \"submit passp-form-button\")]")).click();
        Thread.sleep(500);
        Driver.getDriver().findElement(By.xpath("//*[@id= \"passp-field-passwd\"]")).sendKeys(yandexPassword);
        Driver.getDriver().findElement(By.xpath("//*[contains(@class, \"submit passp-form-button\")]")).click();
        Thread.sleep(3000);
        if(spam){
            Driver.getDriver().findElement(By.xpath("//*[contains(@data-title, \"Спам\")]")).click();
            Thread.sleep(2000);
        }
        Driver.getDriver().findElement(By.xpath(siteXpath)).click();
        Thread.sleep(2000);
        String currentHandle = Driver.getDriver().getWindowHandle();
        Driver.getDriver().findElement(By.xpath(confirmButtonXpath)).click();
        Thread.sleep(2000);
        Set<String> handles = Driver.getDriver().getWindowHandles();
        for (String actual : handles) {
            if (actual.equalsIgnoreCase(currentHandle)) {
                Driver.getDriver().switchTo().window(currentHandle);
            }
        }
        Thread.sleep(2000);
    }

    private static void setTrashmailParameters() throws IOException, InterruptedException {
        Driver.getDriver().findElement(By.xpath("//*[@id='fe-mob-forward']")).sendKeys(yandexEmail);
        String generatedMail = getTrashMail();
        FileWriter fileWriter = new FileWriter("loginData.txt");
        fileWriter.write(generatedMail + "\n" + PWD);
        fileWriter.close();
        Driver.getDriver().findElement(By.xpath("//*[@id=\"fe-mob-fwd-nb\"]")).click();
        Driver.getDriver().findElement(By.xpath("//*[@id=\"fe-mob-fwd-nb\"]/option[contains(text(), \"10\")]")).click();
        Driver.getDriver().findElement(By.xpath("//*[@id=\"fe-mob-life-span\"]")).click();
        Driver.getDriver().findElement(By.xpath("//*[@id=\"fe-mob-life-span\"]/option[contains(text(), \"1 day\")]")).click();
        Driver.getDriver().findElement(By.xpath("//*[@id=\"fe-mob-submit\"]")).click();
        Thread.sleep(2000);
    }

    private static String getTrashMail() {
        String generatedMail = Driver.getDriver().findElement(By.xpath("//*[@id=\"fe-mob-name\"]")).getAttribute("value");
        generatedMail = generatedMail.concat("@trashmail.com");
        System.out.println(generatedMail);
        return generatedMail;
    }

    public static void bookingLogIn() throws InterruptedException, IOException {
        Driver.getDriver().get("https://www.booking.com/");
        Driver.getDriver().findElement(By.xpath("//*[@id=\"current_account\"]")).click();
        Thread.sleep(2000);
        FileReader fileReader = new FileReader("loginData.txt");
        Scanner scanner = new Scanner(fileReader);
        Driver.getDriver().findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(scanner.nextLine());

        Driver.getDriver().findElement(By.xpath("//*[@type=\"submit\"]")).click();

        Driver.getDriver().findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(scanner.nextLine());
        Driver.getDriver().findElement(By.xpath("//*[@type=\"submit\"]")).click();
    }

    public void bookingNewUser() throws InterruptedException, IOException {
        Driver.getDriver().get("https://www.booking.com/");
        Driver.getDriver().findElement(By.xpath("//*[@id=\"current_account_create\"]")).click();
        Thread.sleep(1000);
        FileReader fileReader = new FileReader("loginData.txt");
        Scanner scanner = new Scanner(fileReader);
        String login = scanner.nextLine();
        Driver.getDriver().findElement(By.xpath("//*[@id=\"login_name_register\"]")).sendKeys(login);
        Driver.getDriver().findElement(By.xpath("//*[contains(@class, \"nw-register\")]/button")).click();
        Thread.sleep(1000);
        String password = scanner.nextLine();
        Driver.getDriver().findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
        Driver.getDriver().findElement(By.xpath("//*[@id=\"confirmed_password\"]")).sendKeys(password);
        Driver.getDriver().findElement(By.xpath("//*[contains(@type, \"submit\")]")).click();
        Thread.sleep(3000);
    }



        /*MainPage.bookingRegistration(PropertyPath.BOOKING_PATH);
        TimeUnit.SECONDS.sleep(3);
        MailSteps.confirmLinkOnYandexMail();
        String currentHandle = MyDriver.getWebDriver().getWindowHandle();
        MyDriver.findElementClick();
        Set<String> handles = MyDriver.getWebDriver().getWindowHandles();
        for (String actual : handles) {
            if (actual.equalsIgnoreCase(currentHandle)) {
                MyDriver.getWebDriver().switchTo().window(currentHandle);
            }
        }
        TimeUnit.SECONDS.sleep(8);
        MyDriver.getWebDriver().get("https://www.booking.com/");
        TimeUnit.SECONDS.sleep(2);
        MyDriver.findElementClick("//*[@id=\"profile-menu-trigger--content\"]");
        MyDriver.findElementClick("//*[contains(@class, \"mydashboard\")]");
        Assert.assertEquals(MyDriver.getWebDriver().findElements(By.xpath("//*[@class=\"email-confirm-banner\"]")).size(), 0);*/


    @After
    public void postCondition() {
        Driver.destroy();
        Driver.driver.remove();
    }

}
