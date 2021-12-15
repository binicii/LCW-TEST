import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage{

    By Size= By.id("option-size");
    By bedenTablosu= By.id("add-to-favorite-detail");

    By addToCartButtonLocator =By.id("pd_add_to_cart");



    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductDetailPage() {
        return isDisplayed(addToCartButtonLocator);
    }


    public void addToCart() {
        click(addToCartButtonLocator);
    }


    public boolean isUrunBedeni() {              //beden tablosu resmı kontrolu  favori
        return  isDisplayed(bedenTablosu);
    }

    public void urunBedeni() {
        click(Size);
    }
}
