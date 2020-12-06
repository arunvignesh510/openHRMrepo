package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Page_Objects {
	
	@FindBy(id="txtUsername")
	public static WebElement userName;
	
	@FindBy(id="txtPassword")
	public static WebElement password;
	
	@FindBy(id="btnLogin")
	public static WebElement submitButton;

	
	@FindBy(xpath="//*[@id='dashboard-quick-launch-panel-menu_holder']//following::td[1]")
	public static WebElement AssignLeave;
}
