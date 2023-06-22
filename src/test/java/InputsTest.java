import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class InputsTest {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.setViewportSize(1920, 1080);
        page.navigate("https://letcode.in/edit");

        /* clear the field of existing value then type something in it */
        Locator clearTheTextLocator = page.locator("#clearMe");
        clearTheTextLocator.clear();
        clearTheTextLocator.fill("John");

        /* ensure that the correct value appears */
        assertThat(clearTheTextLocator).hasValue("John");

        /* clear the value again to make sure field is empty */
        clearTheTextLocator.clear();

        //ensure that the field has no value
        assertThat(clearTheTextLocator).hasValue("");

        browser.close();
        playwright.close();
    }
}
