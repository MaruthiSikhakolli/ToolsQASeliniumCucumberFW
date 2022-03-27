package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CartPage {
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.CSS, using = ".cart-button") 
	private WebElement btn_Cart;
	
	@FindBy(how = How.CSS, using = ".checkout-button.alt") 
	private WebElement btn_ContinueToCheckout;
	
	@FindBy(how = How.CSS, using = ".cart-table.alt") 
	private WebElement BooksTable;
	
	@FindBy(how = How.CSS, using = ".cart-table.alt") 
	private WebElement dropdown;
	
	public void dropdownSelection() {
		Select selectObj = new Select(dropdown);
		
		if(selectObj.isMultiple()){
			List<WebElement> options = selectObj.getOptions();

			for(WebElement ele: options){
				String temp = ele.getText();
				selectObj.selectByVisibleText(temp);
			}
		}
		
		List<WebElement> selectedOptions = selectObj.getAllSelectedOptions();

		for(WebElement option: selectedOptions){
			System.out.println(option.getText());
		}

		selectObj.deselectAll();
	}
	
	public void htmlTable() {
		System.setProperty("web.chrome.driver", "path to chrome driver");
		WebDriver driver = new ChromeDriver();
		WebElement htmlTable = driver.findElement(By.id("TableID"));
		
		//Get rows of the table
		List<WebElement> rows = htmlTable.findElements(By.tagName("tr"));
		int totalRows = rows.size();
		
		//Get headers of the table
		List<WebElement> headers = rows.get(0).findElements(By.tagName("th"));
		
		//Printing headers of the table
		for(WebElement ele: headers)
			System.out.println(ele.getText());
		
		//Get cells of the table
		List<WebElement> cells = htmlTable.findElements(By.tagName("td"));
		int totalCells = cells.size();
	
		//Printing each cell value of the table
		for(WebElement ele: cells)
			System.out.print(ele.getText());
	}
	
	public void clickOn_Cart() {
		btn_Cart.click();
	}
	
	public void clickOn_ContinueToCheckout(){
		btn_ContinueToCheckout.click();
		try { Thread.sleep(5000);}
		catch (InterruptedException e) {}
	}
	
	public void iterate_over_cart_table() {
		List<WebElement> rowVals = BooksTable.findElements(By.tagName("tr"));
		
		//Finding total rows
		int rowNum = rowVals.size();
		
		System.out.println("Total number of rows = " + rowNum);
		
		//Get column header values from first row
		List<WebElement> colHeader = rowVals.get(0).findElements(By.tagName("th"));
		
		//Loop through the header values and print them to console
		System.out.println("Header values:");
		for(int i=0; i<colHeader.size(); i++)
			System.out.println(colHeader.get(i).getText());
		
		//Loop through the remaining rows
		for(int i=1; i<rowNum; i++){
			
			//Get each row's column values by tag name
			List<WebElement> colVals = rowVals.get(i).findElements(By.tagName("td"));
			int colNum = colVals.size();
			
			//Loop through each column
			for(int j=0; j<colNum; j++)
				System.out.println(colVals.get(j).getText());
		}	
	}
}

















