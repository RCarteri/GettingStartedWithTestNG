import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.testng.Assert.*;

public class FirstTestNGTest extends UnitTestBaseClass {
    UserManager um;

    @BeforeMethod
    public void customLocalsetupMethod(Method testMethod) {
        String desc = testMethod.getAnnotation(Test.class).description();
        System.out.println("Starting test: " + testMethod.getName() + "with descripption: " + desc);
//        Arrange
        um = new UserManager();
    }

    @Test(description = "Verify that addUser method returns true when successful")
    private void successfulAddUserReturnsTrue() throws DuplicateUserException {
//    Act
        boolean result = um.addUser("ricardo@gmail.com");
//    Assert
        assertTrue(result);
    }

    @Test(description = "Verify that getUser method retrieves the correct existing user")
    private void getUserReturnsExistingSavedUser() throws DuplicateUserException {
//    Arrange
        um.addUser("ricardo@gmail.com");
//    Act
        String user = um.getUser("ricardo@gmail.com");
//    Assert
        assertEquals(user, "ricardo@gmail.com");
    }

    @Test(description = "Verify that getUser method returns null if the user doesn't exist")
    private void getNonExixtingUserReturnsNull() {
//    Act
        String user = um.getUser("ricardo@gmail.com");
//    Assert
        assertNull(user, "The methos should returns null if it doesn't find a user.");
    }

    @Test(expectedExceptions = DuplicateUserException.class,
            expectedExceptionsMessageRegExp = ".*already exists")
    public void addDuplicateThrowsExceptions() throws DuplicateUserException {
//        Act
        um.addUser("ricardo@gm.com");
        um.addUser("ricardo@gm.com");
    }
}
