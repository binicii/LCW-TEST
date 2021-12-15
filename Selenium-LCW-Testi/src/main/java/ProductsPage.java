import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends  BasePage {

    By seeMoreButtonLocater = By.className("paginator__button");
    By shippingOptionLocator =By.xpath("\"http://www.w3.org/2000/svg\"");
    By productNameLocator= By.className("product-image__image");
    //"product-card__title"   product-card__title);

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductPage() {
        return isDisplayed(shippingOptionLocator);
    }

    public void seeMoreButton() {
        click(seeMoreButtonLocater);
    }

    public void selectProduct() {
        //getAllProducts().get(i).click();
        click(productNameLocator);
    }

//    private List<WebElement> getAllProducts(){
//        return findAll(productNameLocator);
//    }
}
