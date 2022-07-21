import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Ignore
public class DisabledTest extends UnitTestBaseClass{
    @Test(enabled = false)
    public void unabledTest1() {
        System.out.println("Test 1");
    }

    @Test
    public void unabledTest2() {
        System.out.println("Test 2");
    }

}
