import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FirstTestNGTest extends UnitTestBaseClass{
    UserManager um;

    @BeforeMethod
    public void customLocalsetupMethod() {
        um = new UserManager();
    }

    @Test
    private void successfulAddUserReturnsTrue() {
//    Arrange
//    Act
        boolean result = um.addUser("ricardo@gmail.com");
//    Assert
        assertTrue(result);
    }

    @Test
    private void getUserReturnsExistingSavedUser() {
//    Arrange
        um.addUser("ricardo@gmail.com");
//    Act
        String user = um.getUser("ricardo@gmail.com");
//    Assert
        assertEquals(user, "ricardo@gmail.com");
    }

    @Test
    private void getNonExixtingUserReturnsNull() {
//    Arrange
//    Act
        String user = um.getUser("ricardo@gmail.com");
//    Assert
        assertNull(user, "The methos should returns null if it doesn't find a user.");
    }
}
