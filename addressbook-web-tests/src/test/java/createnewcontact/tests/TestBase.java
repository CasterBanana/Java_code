package createnewcontact.tests;


import createnewcontact.appmanager.ApplicationManager1;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public class TestBase {

    protected final ApplicationManager1 app = new ApplicationManager1();

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }

}
