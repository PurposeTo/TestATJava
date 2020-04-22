import Pages.BankOpenPage;
import Pages.GoogleResultsPage;
import Pages.GoogleSearchPage;
import Settings.SelenideDriverSettings;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class GoogleSearchingTest extends SelenideDriverSettings {

    @Test
    public void RunGoogleSearchingTest() {
        String ExceptedUrl = "www.open.ru";

        GoogleSearchPage searchPage = GoogleSearchPage.getNew();
        GoogleResultsPage resultsPage = searchPage.search("Открытие");

        // Для того, что бы "запустить" метод find, необходимо выполнить после (!) любое действие
        // Не кликает/ кликает не туда
        resultsPage.results().find(text(ExceptedUrl)).click();

    }


    @Test
    public void RunBankOpenTest() {
        BankOpenPage bankOpenPage = BankOpenPage.getNew();

        // Сравнить, что курс покупки больше чем курс продажи для USD
        Assert.assertTrue(bankOpenPage.getUSDRateSale() > bankOpenPage.getUSDRatePurchase());

        // Сравнить, что курс покупки больше чем курс продажи для EUR
        Assert.assertTrue(bankOpenPage.getEURRateSale() > bankOpenPage.getEURRatePurchase());

    }
}
