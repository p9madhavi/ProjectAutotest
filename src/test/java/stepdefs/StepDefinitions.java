package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import java.awt.font.ShapeGraphicAttribute;

public class StepDefinitions {

    private static final Logger LOG = Logger.getLogger(StepDefinitions.class);

    WebDriver theWebDriver;
    WebElement theWebElement;
    FluentWait<WebDriver> wait;

//    By usernameBy = By.id("j_username");
    By usernameBy = By.xpath("//input[@id='j_username']");
    By pwdBy = By.name("j_password");
    By buttonBy  = By.className("btn-primary");
    By pTagBy = By.tagName("p");
    By errorBy = By.className("alert-error");
    By strongBy = By.tagName("strong");
    By footerBy = By.className("text-muted");
    By seconddropdownToggleBy = By.className("dropdown-toggle");
    By firstNameBy = By.id("user.firstName");
    By lastNameBy = By.name("user.lastName");
    By successMsgBy = By.xpath("//div[@class='alert alert-success']");
//    By formErrorMsgBy = By.className("alert-error");
    By formErrorMsgBy  = By.xpath("//strong[contains(text(),'Form Errors')]");
//    By formErrorMsgBy = By.xpath("//div[@class='alert alert-error']");
    By regiondetailsBy = By.linkText("Region Details");
    By thirdDropDownBy = By.xpath("//a[contains(text(),'Employee Information')]");
    By myProfileBy = By.linkText("My Profile");
    By logoutBy = By.linkText("Logout");
    By empDetailsBy = By.linkText("All Employees Details");
    By empIdAdamBy = By.linkText("121");
    By tdempAdamPhoneNoBy = By.xpath("//td[contains(text(),'650.123.2234')]");
    By empSearchBy = By.linkText("Employee Search");
    By srchfirstNameBy = By.xpath(" //input[@id='firstName']");
    By srchlastNameBy = By.xpath("//input[@id='lastName']");
    By srchButtonBy = By.xpath("//button[@class='btn btn-primary']");
    By srchErrorMsgBy = By.xpath(" //span[@id='firstName.errors']");
    By trTagBy = By.tagName("tr");
    By tbodyTagBy = By.tagName("tbody");
    By trRegionTagBy = By.tagName("tr");
    By tbodyRegionTagBy = By.tagName("tbody");
    By regionEUBy = By.linkText("Europe");
    By regionUSBy = By.linkText("Americas");
    By countryUSABy = By.linkText("United States of America");
    By countryDenBy = By.linkText("Denmark");
    By countryGerBy = By.linkText("Germany");
//    By pTagLocationBy = By.xpath("//p[contains(text(),'No Locations')]");
    By pTagLocationBy = By.tagName("p");
    By seattleIDBy = By.linkText("1700");
    By germanyIDBy = By.linkText("2700");
//    By tdPostalCodeBy = By.tagName("80925"); {not working}
    By tdPostalCodeBy = By.xpath("//td[contains(text(),'80925')]");
    By trCountryTagBy = By.tagName("tr");
    By tbodyCountryTagBy = By.tagName("tbody");
    By trDepartmentTagBy = By.tagName("tr");
    By tbodyDepartmentTagBy = By.tagName("tbody");



//    By tbodyRegionTagBy = By.xpath("//table[@class='table table-striped table-hover']//tbody");
//    By trRegionTagBy = By.xpath("//body//tbody//tr[1]");
// Login Page
    @Given("Go to Autotools login page")
    public void goToLogin(){
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeD\\chromedriver.exe");
        theWebDriver = new ChromeDriver();
        theWebDriver.get("http://23.120.24.187:10080/autotoolsv2");

//   theWebDriver.close(); ----->After opening all the browser,this method will help to close all browsers
    }

    @And("user enters {string} as username")
    public void enterUserName(String username){
        theWebElement = theWebDriver.findElement(usernameBy);
        theWebElement.sendKeys(username);
    }

    @And("user enters {string} as password")
    public void enterPwd(String pwd){
        theWebElement = theWebDriver.findElement(pwdBy);
        theWebElement.sendKeys(pwd);
    }
    @And("user clicks Sign In button")
    public void clickSignIn(){
        theWebElement = theWebDriver.findElement(buttonBy);
        LOG.debug(theWebElement.getText());
        LOG.debug(theWebElement.getAttribute("type"));
        theWebElement.click();
    }
    @Then("a welcome page with {string} message should display")
    public void welcomeMsg(String welcomeMsg){
        wait = new FluentWait<WebDriver>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfElementLocated(pTagBy));
        theWebElement = theWebDriver.findElement(pTagBy);
//        checking the welcome msg ::: Welcome to Auto Tools
        LOG.debug(theWebElement.getText());
        Assert.assertEquals(theWebElement.getText(), welcomeMsg);
//       checking Welcome messgae font weight ::bold(700)--,font -size :: pixels(38.5px)
        theWebElement = theWebDriver.findElement(By.tagName("h1"));
        LOG.debug(theWebElement.getCssValue("font-weight"));
        LOG.debug(theWebElement.getCssValue("font-size"));
//        Assert.assertTrue(theWebElement.getText().contains("kubecloudsinc"));
        theWebDriver.close();
    }
    @Then("an error message {string} should display")
    public void checkError(String errorMsg){
        wait = new FluentWait<WebDriver>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfElementLocated(errorBy));
        theWebElement = theWebDriver.findElement(strongBy);
        LOG.debug(theWebElement.getText());
        Assert.assertEquals(theWebElement.getText(), errorMsg);
        theWebDriver.close();
//  note:::: both strongBy,errorby are for the errormessge ,one is classname,another is  tagname
    }
    @Then("a welcome page with the footer text {string} should display")
    public void welcomePgFooter(String footerMsg){
        wait = new FluentWait<WebDriver>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfElementLocated(footerBy));
        theWebElement = theWebDriver.findElement(footerBy);
        LOG.debug(theWebElement.getText());
//        Assert.assertEquals(theWebElement.getText(), footerMsg);
        Assert.assertTrue(theWebElement.getText().contains("kubecloudsinc"));
        LOG.debug(theWebElement.getCssValue("font-weight"));
        LOG.debug(theWebElement.getCssValue("font-size"));
        theWebDriver.close();
    }
//    ::::::::::::::::::::::::: U S E R    F O R M  :::::::::::::::::::::::::::
    @And("user clicks on second menuitem dropdown")
    public void clickSecondMenuItemdropdown(){
        theWebElement = theWebDriver.findElement(seconddropdownToggleBy);
        LOG.debug(theWebElement.getText());
        theWebElement.click();
    }
    @And("user clicks on MyProfile dropdown option")
    public void clickMyProfile(){
        theWebElement = theWebDriver.findElement(myProfileBy);
        LOG.debug(theWebElement.getText());
        theWebElement.click();
    }
    @And("user changes the firstname as {string}")
    public void changeFirstName(String changedFirstName){
      theWebElement = theWebDriver.findElement(firstNameBy);
      theWebElement.clear();
      theWebElement.sendKeys(changedFirstName);
    }
    @And("user clears the lastname")
    public void clearLastName(){
        theWebElement = theWebDriver.findElement(lastNameBy);
        theWebElement.clear();
    }

    @And("user clicks on save button")
    public void clickSaveButton() {
        theWebElement = theWebDriver.findElement(buttonBy);
        LOG.debug(theWebElement.getText());

//   ****problem is save button is not displaying after changing the firstname in the UserForm ,
//   so we want to scroll the button up by using these commands
//   (1.actions 2.coordinates 3. with javascript) *********

//        Actions actions = new Actions(theWebDriver);
//        actions.moveToElement(theWebElement).click();
//        actions.perform();
//
//        Coordinates coordinate = ((Locatable)theWebElement).getCoordinates();
//        coordinate.onPage();
//        coordinate.inViewPort();

        ((JavascriptExecutor) theWebDriver).executeScript("arguments[0].scrollIntoView();", theWebElement);
        wait = new FluentWait<WebDriver>(theWebDriver);
         wait.until(ExpectedConditions.presenceOfElementLocated(buttonBy));
          theWebElement.click();
    }
    @Then("a success message {string} should display")
     public void checkSuccessMsg(String successMsg){
        wait = new FluentWait<WebDriver>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfElementLocated(successMsgBy));
        theWebElement = theWebDriver.findElement(successMsgBy);
        LOG.debug(theWebElement.getText());
        Assert.assertTrue(theWebElement.getText().contains("Success! Saved user."));
        theWebDriver.close();
    }
    @Then("a formerror message {string} should display")
    public void checkFormErrorMessage(String formErrorMsg){
        wait = new FluentWait<>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(formErrorMsgBy));
        theWebElement = theWebDriver.findElement(formErrorMsgBy);
        LOG.debug(theWebElement.getText());
        Assert.assertEquals(theWebElement.getText(),formErrorMsg);
    }
    @And("user clicks on LogOut dropdown option")
    public void clickLogout(){
        theWebElement = theWebDriver.findElement(logoutBy);
        LOG.debug(theWebElement.getText());
        theWebElement.click();
        theWebDriver.close();
    }
    @And("user clicks on third menuitem dropdown")
    public void clickThirdMenuItemdropdown(){
        theWebElement = theWebDriver.findElement(thirdDropDownBy);
        LOG.debug(theWebElement.getText());
        theWebElement.click();

    }
    @And("user clicks on All Employees Details dropdown option")
    public void clickEmpDetails(){
        wait = new FluentWait<>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfElementLocated(empDetailsBy));
        theWebElement = theWebDriver.findElement(empDetailsBy);
        LOG.debug(theWebElement.getText());
//      LOG.debug(theWebElement.getAttribute("type"));
        theWebElement.click();
    }
    @Then("a table with {int} employees should display")
    public void checkEmpTotal(int totalEmployees){
        wait = new FluentWait<>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(trTagBy));
        theWebElement = theWebDriver.findElement(tbodyTagBy);
        int actualCount = theWebElement.findElements(trTagBy).size();
        LOG.debug(actualCount);
        Assert.assertEquals(totalEmployees, actualCount);
        theWebDriver.close();
    }
    @Then("checking the phone number of employee Id number 121 is {string}")
    public void chkAdamPhoneNumber(String phoneNumber){
        wait = new FluentWait<>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(tdempAdamPhoneNoBy));
        theWebElement = theWebDriver.findElement(empIdAdamBy);
        String actualPhoneNo = theWebElement.findElement(tdempAdamPhoneNoBy).getText();
        LOG.debug(actualPhoneNo);
        Assert.assertEquals(phoneNumber,actualPhoneNo);
        theWebDriver.close();
    }

    @And("user clicks on Employee Search dropdown option")
    public void clickEmployeeSearch(){
        wait = new FluentWait<>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(empSearchBy));
        theWebElement = theWebDriver.findElement(empSearchBy);
        LOG.debug(theWebElement.getText());
        theWebElement.click();
    }
    @And("user enters {string} in the firstName field")
    public void enterFirstName(String firstName){
        theWebElement = theWebDriver.findElement(srchfirstNameBy);
        theWebElement.sendKeys(firstName);
    }
    @And("user enters {string} in the lastName field")
    public void enterLastName(String lastName){
        theWebElement = theWebDriver.findElement(srchlastNameBy);
        theWebElement.sendKeys(lastName);
    }
    @Then("user clicks on the Search button")
    public void clickSearch(){
        wait = new FluentWait<>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(srchButtonBy));
        theWebElement = theWebDriver.findElement(srchButtonBy);
        theWebElement.click();
//        theWebDriver.close();
    }
    @Then("{string} message should display")
    public void chkSrchErrorMsg(String errorMsg){
       theWebElement =  theWebDriver.findElement(srchErrorMsgBy);
        LOG.debug(theWebElement.getText());
       Assert.assertEquals(theWebElement.getText(),errorMsg);
       theWebDriver.close();

    }


    @And("user clicks on fourth menuitem RegionDetails")
    public void clickRegionDetails(){
      theWebElement =  regiondetailsBy.findElement(theWebDriver);
      theWebElement.click();
    }
    @Then("a table with {int} regions should display")
    public void checkRegionsTotal(int totalregions){
        wait = new FluentWait<>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(trRegionTagBy));
        theWebElement = theWebDriver.findElement(tbodyRegionTagBy);
        int actualCount = theWebElement.findElements(trRegionTagBy).size();
        LOG.debug(actualCount);
        Assert.assertEquals(totalregions, actualCount);
        theWebDriver.close();
    }
    @And("user clicks on the region name Europe")
    public void clickOnEuropeRegion(){
        wait = new FluentWait<>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(regionEUBy));
        theWebElement = theWebDriver.findElement(regionEUBy);
        LOG.debug(theWebElement.getText());
        theWebElement.click();
    }
    @Then("a table with {int} countries should display")
    public void countriesTotal(int countriesTotal){
        wait = new FluentWait<>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(trCountryTagBy));
        theWebElement = theWebDriver.findElement(tbodyCountryTagBy);
        int actualCount = theWebElement.findElements(trCountryTagBy).size();
        LOG.debug(actualCount);
        Assert.assertEquals(actualCount,countriesTotal);
        theWebDriver.close();
    }
    @And("user clicks on the region name Americas")
    public void clickOnAmericasRegion(){
        wait = new FluentWait<>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(regionUSBy));
        theWebElement = theWebDriver.findElement(regionUSBy);
        LOG.debug(theWebElement.getText());
        theWebElement.click();
    }
    @And("user clicks on the country name United States of America")
    public void clickOnUSACountry(){
        wait = new FluentWait<>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(countryUSABy));
        theWebElement = theWebDriver.findElement(countryUSABy);
        LOG.debug(theWebElement.getText());
        theWebElement.click();
    }
    @And("user clicks on the Seattle location ID")
    public void clickOnSeattleID(){
        wait = new FluentWait<>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(seattleIDBy));
        theWebElement = theWebDriver.findElement(seattleIDBy);
        LOG.debug(theWebElement.getText());
        theWebElement.click();
    }
    @Then("a table with {int} Departments should display")
    public void seattleDepartmentsTotal(int departmentTotal){
        wait = new FluentWait<>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(trDepartmentTagBy));
        theWebElement = theWebDriver.findElement(tbodyDepartmentTagBy);
        int actualCount = theWebElement.findElements(trDepartmentTagBy).size();
        LOG.debug(actualCount);
        Assert.assertEquals(actualCount,departmentTotal);
        theWebDriver.close();
    }
    @And("user clicks on the country name Denmark")
    public void clickOnCountryDenmark(){
        wait = new FluentWait<>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(countryDenBy));
        theWebElement = theWebDriver.findElement(countryDenBy);
        LOG.debug(theWebElement.getText());
        theWebElement.click();
    }
    @Then("the locations page with {string} message should display")
    public void noLocationsMsg(String locationMsg){
        wait = new FluentWait<>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(pTagLocationBy));
        theWebElement = theWebDriver.findElement(pTagLocationBy);
        LOG.debug(theWebElement.getText());
        Assert.assertEquals(theWebElement.getText(),locationMsg);
        theWebDriver.close();

    }
    @And("user clicks on the country name Germany")
    public void clickOnCountryGermany(){
        wait = new FluentWait<>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(countryGerBy));
        theWebElement = theWebDriver.findElement(countryGerBy);
        LOG.debug(theWebElement.getText());
        theWebElement.click();
    }
    @Then("checking the postal code {string} for the Germany location ID 2700")
    public void chkPostalCode(String postalCode){
        wait = new FluentWait<>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(tdPostalCodeBy));
        theWebElement = theWebDriver.findElement(germanyIDBy);
        String actualPostalCode = theWebElement.findElement(tdPostalCodeBy).getText();
        LOG.debug(actualPostalCode);
        Assert.assertEquals(actualPostalCode,postalCode);
        theWebDriver.close();
    }




}


