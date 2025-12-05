package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutCompletePage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.CheckoutOverviewPage;
import utils.ExcelUtil;

public class Test001OrderFlow extends BaseTest {

    @Test
    public void testOrderFlow() {
        test = extent.createTest("test001 - Order Placement");
        
        // Validate URL & Title
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
        Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo"));

        LoginPage login = new LoginPage(driver);

        String user = ExcelUtil.getCell("src/test/resources/data/login_cred.xlsx","Sheet1",1,0);
        String pass = ExcelUtil.getCell("src/test/resources/data/login_cred.xlsx","Sheet1",1,1);

        login.login(user, pass);

        ProductsPage product = new ProductsPage(driver);
        product.sortZA();
        product.addFirstItem();
        product.openCart();

        CartPage cart = new CartPage(driver);
        Assert.assertNotNull(cart.getCartItemName());

        cart.clickCheckout();

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.fillDetails("John","Doe","123456");
        
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.clickFinish();

        CheckoutCompletePage finalPage = new CheckoutCompletePage(driver);
        Assert.assertEquals(finalPage.getSuccessMsg(), "Thank you for your order!");

        test.pass("Order flow completed successfully.");
    }
}

