import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage{
    By productNameLocator = new By.ByClassName(".container-fluid.filter-header .new-filter-area .product-item-wrapper a .info .product-item-info .title, .container-fluid.filter-header #divModels .product-item-wrapper a .info .product-item-info .title, .container-fluid.filter-header .header-section .product-item-wrapper a .info .product-item-info .title, .container-fluid.filter-header .SearchPage .product-item-wrapper a .info .product-item-info .title, .container-fluid.filter-header .FavoriteListPage .product-item-wrapper a .info .product-item-info .title, .container-fluid.filter-header .CategoryPage .product-item-wrapper a .info .product-item-info .title, .container-fluid.content-area .new-filter-area .product-item-wrapper a .info .product-item-info .title, .container-fluid.content-area #divModels .product-item-wrapper a .info .product-item-info .title, .container-fluid.content-area .header-section .product-item-wrapper a .info .product-item-info .title, .container-fluid.content-area .SearchPage .product-item-wrapper a .info .product-item-info .title, .container-fluid.content-area .FavoriteListPage .product-item-wrapper a .info .product-item-info .title, .container-fluid.content-area .CategoryPage .product-item-wrapper a .info .product-item-info .title");
    By increaseProductLocater = By.id("Cart_AddQuantity_734655976");
    By deleteProductLocater = By.id("Cart_ProductDelete_734655976");
    By deleteButtonLocater = By.id("Cart_ProductDelete_734655976");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkIfProductAdded() {
        return getProducts().size() > 0 ;
    }

    private List<WebElement> getProducts(){
        return findAll(productNameLocator);
    }

    public void productIncrease() {
        click(increaseProductLocater);
    }

    public void deleteProduct() {
        click(deleteProductLocater);
        click(deleteButtonLocater);
    }

    public boolean isProductDelete() {
        return isDisplayed(deleteButtonLocater);
    }


    }

