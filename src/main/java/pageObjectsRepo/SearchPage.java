package pageObjectsRepo;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import genericUtilities.CommonUtils;

public class SearchPage extends BasePage {

	public SearchPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//ul[@class='breadcrumb']//a[text()='Search']")
	private WebElement searchPageBreadcrumb;

	@FindBy(linkText = "HP LP3065")
	private WebElement existingProductOne;

	@FindBy(xpath = "//input[@id='button-search']/following-sibling::p")
	private WebElement noProductMessage;

	@FindBy(className = "product-thumb")
	private List<WebElement> productThumbnails;
	
	@FindBy(css = "#input-search")
	private  WebElement searchCreteriaBoxField;
	
	
	@FindBy(css = "#button-search")
	private WebElement searchButton;
	
	@FindBy(css = "#description")
	private WebElement scerchInProductDescriptionCheckBox;
	
	@FindBy(linkText = "iMac")
	private WebElement existingProductThree;
	
	@FindBy(css ="select[name='category_id']")
	private WebElement categoryDropdown;
	
	
		

	public boolean didWeNavgateToScerchResultPage() {
		return searchPageBreadcrumb.isDisplayed();
	}

	public boolean isProductDisplayedInSearchResults() {
		return existingProductOne.isDisplayed();

	}

	public String getNoProductMessage() {
		try {
			return noProductMessage.getText();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	public int getProductsCount() {
		return productThumbnails.size();
	}
	
	public String getSearchCreteriaBoxFieldPlaceholderText() {
		return searchCreteriaBoxField.getAttribute("Placeholder");
	}
	
	public void enterProductIntoSearchCreteriaBoxField(String productName) {
		searchCreteriaBoxField.sendKeys(productName);
		
		
	}
	
	public void clickOnSearchButton() {
		searchButton.click();
		
	}
	
	public void clickOnScerchInProductDescriptionCheckBox() {
		scerchInProductDescriptionCheckBox.click();
	}
	
	public boolean isProductHavingTextInItsDescriptionDisplayedInSearchResults() {
		return existingProductThree.isDisplayed();
	}
	
	public void selectCategoryFromDropDown(String categoryName) throws InterruptedException {
		Select categorySelect = new Select(categoryDropdown);
		Thread.sleep(2000);
		categorySelect.selectByVisibleText(categoryName);
	}
	
	

	
}