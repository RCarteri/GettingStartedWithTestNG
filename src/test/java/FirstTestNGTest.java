import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FirstTestNGTest {
    @Test
    private void successfulAddUserReturnsTrue() {
//    Arrange
        UserManager um = new UserManager();
//    Act
        boolean result = um.addUser("ricardo@gmail.com");
//    Assert
        assertTrue(result);
    }

    @Test
    private void getUserReturnsExistingSavedUser() {
//    Arrange
        UserManager um = new UserManager();
        um.addUser("ricardo@gmail.com");
//    Act
        String user = um.getUser("ricardo@gmail.com");
//    Assert
       assertEquals(user, "ricardo@gmail.com");
    }

    @Test
    private void getNonExixtingUserReturnsNull() {
//    Arrange
        UserManager um = new UserManager();
//    Act
        String user = um.getUser("ricardo@gmail.com");
//    Assert
        assertNull(user, "The methos should returns null if it doesn't find a user.");
    }
}
