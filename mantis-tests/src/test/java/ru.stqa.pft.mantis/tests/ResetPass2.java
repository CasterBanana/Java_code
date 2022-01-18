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

public class ResetPass2 extends TestBase{
    //@BeforeMethod
    public void startMailServer(){
        app.mail().start();
    }

    @Test
    public void testResetPass2() throws IOException, MessagingException {

        app.registration().adminEnter("administrator", "root");
        app.registration().goToUserPage();
        app.registration().ResetPassword();// порядок

        String email = String.format("user1642406378885@localhost");
        List<MailMessage> mailMessages = app.mail().waitForMail(1, 60000);
        String confirmationLink = findConfirmationLink(mailMessages, email);
        String user = String.format("user1642406378885");
        String password = "azaza";
        app.registration().finish(confirmationLink, user, password);
        app.registration().userAutorization(user, password);
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
