import Pages.BankOpenPage;
import Pages.GoogleResultsPage;
import Pages.GoogleSearchPage;
import Settings.SelenideDriverSettings;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;

public class GoogleSearchingTest extends SelenideDriverSettings {

    @Test
    public void RunGoogleSearchingTest() {
        String expectedUrl = "www.open.ru";

        GoogleSearchPage searchPage = GoogleSearchPage.getNew();
        GoogleResultsPage resultsPage = searchPage.search("Открытие");

        // Проверка на то, что среди элементов есть нужный. Вызывает Assert
        SelenideElement expectedElement = resultsPage.results().findBy(text(expectedUrl)).shouldBe();

        // Кликаем на заголовок
        expectedElement.find(By.cssSelector("#rso .r")).click();
        BankOpenPage bankOpenPage = page(BankOpenPage.class);

        // Сравнить, что курс покупки больше чем курс продажи для USD
        Assert.assertTrue(bankOpenPage.getUSDRateSale() > bankOpenPage.getUSDRatePurchase());
        // Сравнить, что курс покупки больше чем курс продажи для EUR
        Assert.assertTrue(bankOpenPage.getEURRateSale() > bankOpenPage.getEURRatePurchase());
    }
}
