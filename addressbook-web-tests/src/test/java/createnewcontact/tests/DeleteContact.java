package createnewcontact.tests;

import org.testng.annotations.*;


public class DeleteContact extends TestBase {


    @Test
    public void testGroupDeletionTests() throws Exception {
        app.selectContact();
        app.deleteContact();
        app.getAcceptContact(); // подтверждение для всплыващющего окна
        app.openHome();

    }


}
