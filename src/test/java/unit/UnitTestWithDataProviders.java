package unit;

import app.DuplicateUserException;
import app.UserManager;
import baseclasses.UnitTestBaseClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UnitTestWithDataProviders extends UnitTestBaseClass {
    UserManager um;

    @BeforeMethod()
    public void setup(){
//        Arrange
        um = new UserManager();
    }

    @DataProvider
    protected Object[][] invalidEmailProvider() {
        return new Object[][]{
                {""},
                {"johnemail.com"},
                {"john@emailcom"}
        };
    }

    @Test(dataProvider = "invalidEmailProvider", expectedExceptions = IllegalArgumentException.class)
    public void emptyUserThrowsException(String invalidEmail) throws DuplicateUserException{
//        Act
        boolean result = um.addUser(invalidEmail);

//        Assert
        assertTrue(result);
    }
}
