package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;


public class RegistrationHelper extends HelperBase {

    public RegistrationHelper(ApplicationManager app) {
        super(app);

    }

    public void start(String username, String email) {
        wd.get(app.getProperty("web.baseUrl") + "/signup_page.php");
        type(By.name("username"),username);
        type(By.name("email"), email);
        click(By.cssSelector("input[value='Зарегистрироваться']"));
        //click(By.cssSelector("input[type='submit']"));// указание кнопки регистрации другое
        //click(By.cssSelector("input[value='Signup']"));// старый вариант

    }

    public void finish(String confirmationLink,String user, String password ) {
        wd.get(confirmationLink);
        type(By.name("realname"), user);
        type(By.name("password"), password);
        type(By.name("password_confirm"), password);
        //click(By.cssSelector("input[value='Изменить учетную запись']"));
        click(By.xpath("//*[@id=\"account-update-form\"]/fieldset/span/button"));

    }

    public void adminEnter(String username, String password){
        wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
        type(By.name("username"), username);
        click(By.cssSelector("input[value='Вход']"));
        type(By.name("password"), password);
        click(By.cssSelector("input[value='Вход']"));
    }

    public void userAutorization(String username, String password){
        wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
        type(By.name("username"), username);
        type(By.name("password"), password);
        click(By.cssSelector("input[value='Вход']"));

    }



    public void goToUserPage(){
        wd.get(app.getProperty("web.baseUrl") + "/manage_user_page.php");

    }

    public void ResetPassword(String username){
        wd.get(app.getProperty("web.baseUrl") + "/manage_user_page.php");
        click(By.linkText(username));
        click(By.cssSelector("input[value='Сбросить пароль']"));// не жмакает на кнопку, сволота
        //click(By.xpath("input[value='Сбросить пароль']"));
    }
}
