import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class Lcw_App_Test extends BaseTest{

    HomePage homePage ;
    ProductsPage productsPage ;
    ProductDetailPage productDetailPage ;
    CartPage cartPage ;

    @Test
    @Order(1)
    public void correctLogin() {
        driver.get("https://www.lcwaikiki.com/tr-TR/TR/giris ");
        driver.findElement(By.id("LoginEmail")).sendKeys("binicii.busraa@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("*********");
        driver.findElement(By.id("loginLink")).click();
        Assertions.assertEquals(driver.getTitle(), "Home Page");
    }

    @Test
    @Order(2)
    public void search_a_product(){
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        homePage.searchBox().search("pantolon");
        Assertions.assertTrue(productsPage.isOnProductPage() ,
                "Not on products page!");
    }

    @Test
    @Order(3)
    public void scrollDown(){
        productsPage.seeMoreButton();
        Assertions.assertTrue(productsPage.isOnProductPage() ,
                "Not on products page!" );

    }

    @Test
    @Order(4)
    public void select_a_product(){
        productDetailPage = new ProductDetailPage(driver);
        productsPage.selectProduct();
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage(),
                "Not on product detail page!");
    }

    @Test
    @Order(5)

    public void size(){
        productDetailPage.urunBedeni();
        Assertions.assertTrue(productDetailPage.isUrunBedeni(),
                "urun eklenmedi");

    }


    @Test
    @Order(6)
    public void add_product_to_cart(){
        productDetailPage.addToCart();
        Assertions.assertTrue(homePage.isProductCountUp(),
                "Product count did not increase!");
    }



    @Test
    @Order(7)
    public void go_to_cart(){
        cartPage = new CartPage(driver);
        homePage.goToCart();
        cartPage.productIncrease();
        Assertions.assertTrue(cartPage.checkIfProductAdded() ,
                "Product was not added to cart!");
    }

    @Test
    @Order(8)
    public void deleteProductToCart(){
        cartPage.deleteProduct();
        Assertions.assertTrue(cartPage.isProductDelete() ,
                "Product was not deleted to cart!");
    }

}
