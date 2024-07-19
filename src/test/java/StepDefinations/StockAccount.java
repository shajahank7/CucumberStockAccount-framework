package StepDefinations;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StockAccount {

	public static WebDriver driver;
	//public static String numb;
	public static  String supplier_num;
	public static String purchase_num;
	public static String customernum;
	
	
	

@Given("i open browser with url {string}")
public void i_open_browser_with_url(String url ) {
    System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.get(url);
 
                                 //tag with validinputs
}
@Then("i see login page")
public void i_see_login_page() throws InterruptedException {
    Thread.sleep(2000);
   if(driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed())
   {
	   System.out.println("login is dispalyed");
   }
   
   }
@When("i enter user a {string}")
public void i_enter_user_a(String uid) {
	driver.findElement(By.xpath("//input[@placeholder='User Name']")).clear();
    driver.findElement(By.xpath("//input[@placeholder='User Name']")).sendKeys(uid);
}
@When("i enter password as {string}")
public void i_enter_password_as(String pwd) {
	driver.findElement(By.xpath("//input[@placeholder='Password']")).clear();
   driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pwd);
}
@When("i click login")
public void i_click_login() {
    driver.findElement(By.xpath("//button[@type='submit']")).click();
}
@Then("i see Dashboard")
public void i_see_dashboard() {
   if(driver.findElement(By.xpath("(//a[contains(text(),'Dashboard')])[2]")).isDisplayed())
   {
	   System.out.println("system should displayed login dashboard");
   }
}
@When("i click logout")
public void i_click_logout() {
    driver.findElement(By.xpath("(//a[contains(text(),'Logout')])[3]")).click();
}
@Then("i close browser")
public void i_close_browser() {
    driver.close();
}
	

@When("clik on alert")
public void clik_on_alert() throws InterruptedException {
	Thread.sleep(3000);
  driver.findElement(By.xpath("//button[@class='ajs-button btn btn-primary']")).click();
}
                                       //tag adding stock item


@Then("i click on Stock item")
public void i_click_on_stock_item() {
    driver.findElement(By.xpath("(//a[contains(.,'Stock Items')])[2]")).click();
}
@Then("i click plus button")
public void i_click_plus_button() throws Throwable {
	Thread.sleep(2000);
	 driver.findElement(By.xpath("(//a[@data-caption='Add'])[1]")).click();
}
@Then("i should enter all mondary feilds as {string},{string},{string},{string}")
public void i_should_enter_all_mondary_feilds_as(String Stockname, String PurchasingPrice, String SellingPrice, String Notes) throws IOException, InterruptedException {
    Select sc= new Select(driver.findElement(By.xpath("//select[@data-field='x_Category']")));
    sc.selectByValue("1500");
    Select s= new Select(driver.findElement(By.xpath("//select[@data-field='x_Supplier_Number']")));
    s.selectByValue("Supplier-00000002531");
    Thread.sleep(2000);
    String numb =driver.findElement(By.id("x_Stock_Number")).getAttribute("value");
    
    //write into notepad
		FileWriter fw = new FileWriter("./CaptureData/capturefile.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(numb);
		bw.flush();
		bw.close();
		
		
    driver.findElement(By.xpath("//input[@placeholder='Stock Name']")).sendKeys(Stockname);
    Select scl=new Select(driver.findElement(By.xpath("//select[@data-field='x_Unit_Of_Measurement']")));
    scl.selectByValue("777.0");
    driver.findElement(By.xpath("//input[@placeholder='Purchasing Price']")).sendKeys(PurchasingPrice);
    driver.findElement(By.xpath("//input[@placeholder='Selling Price']")).sendKeys(SellingPrice);
    driver.findElement(By.xpath("//input[@placeholder='Notes']")).sendKeys(Notes);
   }
    


@Then("click ok button on confim page")
public void click_ok_button_on_confim_page() throws InterruptedException {
	Thread.sleep(2000);
    driver.findElement(By.xpath("//button[normalize-space()='OK!']")).click();
	Thread.sleep(4000);
}
@Then("i click add button")
public void i_click_add_button() {
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	}


@Then("click ok button on alert")
public void click_ok_button_on_alert() {
    driver.findElement(By.xpath("//button[@class='ajs-button btn btn-primary']")).click();
}
@Then("i click on Search button and paste the value on Search bar")
public void i_click_on_search_button_and_paste_the_value_on_search_bar() throws Throwable {
	Thread.sleep(3000);
    driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-search ewIcon']")).click();
    FileReader fr = new FileReader("c:./CaptureData/capturefile.txt");
    BufferedReader br = new BufferedReader(fr);
    String numb= br.readLine();
    driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(numb);

}



@Then("click Search button")
public void click_search_button() {
    driver.findElement(By.xpath("//button[@type='submit']")).click();
	

}
@Then("check the item is displayed or not")
public void check_the_item_is_displayed_or_not() throws Throwable {
	Thread.sleep(1000);
	String stock_num=driver.findElement(By.xpath("//table[@id='tbl_a_stock_itemslist']//tr[1]//td[8]//span")).getText();         
	Thread.sleep(3000);
	 FileReader fr = new FileReader("./CaptureData/capturefile.txt");
	    BufferedReader br = new BufferedReader(fr);
	    String numb= br.readLine();
	if(stock_num.equalsIgnoreCase(numb))
	{
		System.out.println("item is present in the table");
	}
	else
	{
		System.out.println("item is not present in the table");
	}
}
	
	
	                                      //tag   supplier link


	
	@Then("i click on supplier link")
	public void i_click_on_supplier_link() {
		driver.findElement(By.xpath("(//a[contains(text(),'Suppliers')])[2]")).click();
	    
	}
	@Then("fill all mandtry fileds in the supplier page as {string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void fill_all_mandtry_fileds_in_the_supplier_page_as(String Sname, String Address, String City, String Country, String cperson, String pnumber, String Email, String Mnumber, String Notes) throws IOException, InterruptedException {
	    Thread.sleep(3000);
		String supplier_num=driver.findElement(By.id("x_Supplier_Number")).getAttribute("value");
		FileWriter fw= new FileWriter("c:./CaptureData/supplierCaptureData.txt");
	    BufferedWriter bw = new BufferedWriter(fw);
	    bw.write(supplier_num);
	    bw.flush();
	    bw.close();
	    driver.findElement(By.xpath("//input[@placeholder='Supplier Name']")).sendKeys(Sname);
	    driver.findElement(By.xpath("//textarea[@placeholder='Address']")).sendKeys(Address);
	    driver.findElement(By.xpath("//input[@placeholder='City']")).sendKeys(City);
	    driver.findElement(By.xpath("//input[@placeholder='Country']")).sendKeys(Country);
	    driver.findElement(By.xpath("//input[@placeholder='Contact Person']")).sendKeys(cperson);
	    driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys(pnumber);
	    driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(Email);
	    driver.findElement(By.xpath("//input[@placeholder='Mobile Number']")).sendKeys(Mnumber);
	    driver.findElement(By.xpath("//textarea[@placeholder='Notes']")).sendKeys(Notes);
	    
	}
	
	@Then("i click on Search button and paste the value on Search bar in supplier module")
	public void i_click_on_search_button_and_paste_the_value_on_search_bar_in_supplier_module() throws IOException {
	    driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-search ewIcon']")).click();
	    FileReader fr = new FileReader("c:./CaptureData/supplierCaptureData.txt");
	    BufferedReader br= new BufferedReader(fr);
	    String supplier_number=br.readLine();
	    driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(supplier_number);
	}
	
	@Then("check the item is displayed or not in supplier module")
	public void check_the_item_is_displayed_or_not_in_supplier_module() throws InterruptedException {
		Thread.sleep(2000);
		String supplie_numtable=driver.findElement(By.xpath("//tr[@class='ewTableRow']//span[@class='a_suppliers_Supplier_Number']//span")).getText();  
		Thread.sleep(2000);
		if(supplie_numtable.equalsIgnoreCase(supplier_num))
		{
			System.out.println("item is present in the table");
		}
		else
		{
			System.out.println("item is not present in the table");
		}
	}
	
	                       // purchase module page
	
	
	
	@Then("i click on Purchases link")
	public void i_click_on_purchases_link() {
	   driver.findElement(By.linkText("Purchases")).click();
	}
	
	
	
	
	@Then("click ok button on confim page on purchases module")
	public void click_ok_button_on_confim_page_on_purchases_module() throws Throwable {
		Thread.sleep(2000);
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	  //button[@type='submit']
	    driver.findElement(By.xpath("//button[normalize-space()='OK!']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//button[@class='ajs-button btn btn-primary']")).click();
	}
	
	

	@Then("i full all mondary feilds in purchase module")
	public void i_full_all_mondary_feilds_in_purchase_module() throws Throwable {
	   Thread.sleep(2000);
	  String purchase_num= driver.findElement(By.className("form-control")).getAttribute("value");
	       
	               //write into notepad
	  
	  FileWriter fw= new FileWriter("c:./CaptureData/purchase_number.txt");
      BufferedWriter bw = new BufferedWriter(fw);
	  bw.write(purchase_num);
	  bw.flush();
	  bw.close();
	  Select sc =new Select(driver.findElement(By.id("x_Supplier_ID")));
	  sc.selectByValue("Supplier-00000002789");
	  driver.findElement(By.id("x_Notes")).sendKeys("purchasese module");
	  driver.findElement(By.id("x_Total_Amount")).sendKeys("10");
	  driver.findElement(By.id("x_Total_Payment")).sendKeys("5");
	  Thread.sleep(1000);
	 // driver.findElement(By.id("x_Total_Balance")).sendKeys("5");
	  
	  
	}

	@Then("i click on Search button and paste the value on Search bar on purchases page")
	public void i_click_on_search_button_and_paste_the_value_on_search_bar_on_purchases_page() throws InterruptedException, IOException {
    Thread.sleep(2000);
	driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-search ewIcon']")).click();
	Thread.sleep(2000);
    FileReader fr= new FileReader("c:./CaptureData/purchase_number.txt");
    BufferedReader br= new BufferedReader(fr);
    String purchase_num=br.readLine();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(purchase_num);
    //driver.findElement(By.xpath("//button[@type='submit']")).click();
	
	}

	@Then("check the item is displayed or not on purchases page")
	public void check_the_item_is_displayed_or_not_on_purchases_page() throws Throwable {
		Thread.sleep(2000);
	  if( driver.findElement(By.xpath("//table[@class='table ewTable']/tbody//tr[1]//td[5]/div/span/span")).isDisplayed());
	  {
		  System.out.println("purchases number is displayes");
	  }
	}
	 
	  
	  
	                      // customer module
	  
	  @Then("i click on customer link")
	  public void i_click_on_customer_link() {
		  driver.findElement(By.linkText("Customers")).click();
	  }

	  @Then("i full all mondary feilds in customer module")
	  public void i_full_all_mondary_feilds_in_customer_module() throws Throwable {
	     Thread.sleep(2000);
	     String customernum=driver.findElement(By.xpath("//input[contains(@id,'x_Customer_Number')]")).getAttribute("value");
	     FileWriter fw= new FileWriter("c:./CaptureData/customernum.txt");
	     BufferedWriter bw=new BufferedWriter(fw);
	     bw.write(customernum);
	     bw.flush();
	     bw.close();
	    
	     driver.findElement(By.xpath("//input[@placeholder='Customer Name']")).sendKeys("sajju");
	     driver.findElement(By.xpath("//textarea[@placeholder='Address']")).sendKeys("dharmaravarm");
	     driver.findElement(By.xpath("//input[@placeholder='City']")).sendKeys("dharmavaram");
	     driver.findElement(By.xpath("//input[@placeholder='Country']")).sendKeys("indian");
	     driver.findElement(By.xpath("//input[@placeholder='Contact Person']")).sendKeys("raju");
	     driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("9876543212");
	     driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("shaju@gamil.com");
	     driver.findElement(By.xpath("//input[@placeholder='Mobile Number']")).sendKeys("987976435");
	     driver.findElement(By.xpath("//input[@placeholder='Notes']")).sendKeys("helloworld");
	     
	     
	  }

	  @Then("click ok button on confim page on customer module")
	  public void click_ok_button_on_confim_page_on_customer_module() throws Throwable {
	     driver.findElement(By.xpath("//button[@type='submit']")).click();
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//button[normalize-space()='OK!']")).click();
	     Thread.sleep(2000);
	     //driver.findElement(By.xpath("//button[@class='ajs-button btn btn-primary']")).click();
	  }

	  @Then("i click on Search button and paste the value on Search bar on customer page")
	  public void i_click_on_search_button_and_paste_the_value_on_search_bar_on_customer_page() throws Throwable {
	    driver.findElement(By.xpath("//button[@class='btn btn-default ewSearchToggle']")).click();
	    Thread.sleep(2000);
	    FileReader fr= new FileReader("c:./CaptureData/customernum.txt");
	    BufferedReader br=new BufferedReader(fr);
	    String customernum=br.readLine();
	    
	    
	    Thread.sleep(2000); 
	    driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(customernum);
	    Thread.sleep(1000); 
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	  }

	  @Then("check the item is displayed or not on customer page")
	  public void check_the_item_is_displayed_or_not_on_customer_page() throws Throwable {
		  Thread.sleep(2000);
	   if(driver.findElement(By.xpath("//table[@class='table ewTable']//tbody//tr[1]//td[5]/div/span/span")).isDisplayed())
	   {
		  System.out.println("customer is displayed");
	   }
	  }

	  
	  
	  
	  
	  
	}
	


