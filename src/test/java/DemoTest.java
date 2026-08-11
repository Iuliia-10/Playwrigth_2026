import com.microsoft.playwright.CLI;
import org.testng.annotations.Test;

import java.io.IOException;

public class DemoTest {

    @Test
    public void verifyDemoTest() throws IOException, InterruptedException{
        CLI.main(
                new String[]{"codegen", "https://intusers:GjRQVKrtZAFc@stage.slotcity.ua/"}
        );
    }
}
