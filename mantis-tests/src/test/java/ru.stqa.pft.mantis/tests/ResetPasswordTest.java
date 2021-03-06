package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ResetPasswordTest extends TestBase {
    //@BeforeMethod
    public void startMailServer(){
        app.mail().start();
    }

    @Test(enabled = false)
    public void testRegistration() throws IOException, MessagingException {

        app.registration().adminEnter("administrator", "root");
        app.registration().goToUserPage();
        //app.registration().ResetPassword(); // тут сделано

        long now = System.currentTimeMillis();


        String email = String.format("user1@localhost.localdomain", now);
        List<MailMessage> mailMessages = app.mail().waitForMail(2, 60000);
        String confirmationLink = findConfirmationLink(mailMessages, email);

        String user = String.format("user1", now);
        String password = "password";


        app.registration().finish(confirmationLink, user, password);

        assertTrue(app.newSession().login(user, password));
    }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex  = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }

    //@AfterMethod(alwaysRun = true)
    public void stopMailServer(){
        app.mail().stop();
    }
}
