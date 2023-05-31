import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;


public class ElementsTests {
    @Test
    public void testRadioButtonSelection() {
        Selenide.open("https://demoqa.com/");
        Selenide.open("https://demoqa.com/");


        Selenide.$x("//span[text()='Elements']").click();
        Selenide.$x("//span[text()='Radio Button']").click();
        Selenide.$x("//label[text()='Impressive']").click();
        Assert.assertTrue(Selenide.$x("//p[text()='You have selected Impressive']").exists());

    }

    @Test(dependsOnMethods = "testRadioButtonSelection")
    public void dependentTestMethod() {


        Selenide.open("https://demoqa.com/");
        Selenide.$x("//span[text()='Elements']").click();
        Selenide.$x("//span[text()='Buttons']").click();
        Selenide.$("#dynamicClickMessage").click();
        Assert.assertTrue(Selenide.$("#dynamicClickMessage").shouldHave(Condition.text("You have done a dynamic click")).exists());
        Selenide.actions().contextClick(Selenide.$("#rightClickBtn")).perform();
        Assert.assertTrue(Selenide.$("#rightClickMessage").shouldHave(Condition.text("You have done a right click")).exists());
    }
}
