import Pages.BankOpenPage;
import Pages.GoogleResultsPage;
import Pages.GoogleSearchPage;
import Settings.SelenideDriverSettings;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class GoogleSearchingTest extends SelenideDriverSettings {
    private String GoogleUrl = "https://www.google.com/";
    private String ExceptedUrl = "www.open.ru";

    @Test
    public void RunGoogleSearchingTest() {
        GoogleSearchPage searchPage = open(GoogleUrl, GoogleSearchPage.class);
        GoogleResultsPage resultsPage = searchPage.search("Открытие");

        // Для того, что бы "запустить" метод find, необходимо выполнить после (!) любое действие
        // Не кликает/ кликает не туда
        resultsPage.results().find(text(ExceptedUrl)).click();

    }


    @Test
    public void RunBankOpenTest() {
        String BankOpenUrl = "https://www.open.ru/";

        BankOpenPage bankOpenPage = open(BankOpenUrl, BankOpenPage.class);

        // Сравнить, что курс покупки больше чем курс продажи для USD
        Assert.assertTrue(bankOpenPage.getUSDRateSale() > bankOpenPage.getUSDRatePurchase());

        // Сравнить, что курс покупки больше чем курс продажи для EUR
        Assert.assertTrue(bankOpenPage.getEURRateSale() > bankOpenPage.getEURRatePurchase());

    }
}
