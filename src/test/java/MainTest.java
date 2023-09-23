import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Timeout;

public class MainTest extends TestCase {


    @Disabled
    @Test
    @Timeout(22)
    public void testMain() throws Exception {
        Main.main(null);
    }
}