package nopCommerce.pageUIs;

public class AbstractPageUI {
//	Header (5 Variable)
	public static final String HEADER_MY_ACCOUNT_LINK = "//a[@class='ico-account']";
	public static final String HEADER_WISHLIST_LINK = "//span[@class='wishlist-label']";
	public static final String HEADER_SHOPPING_CART_LINK = "//span[@class='cart-label']";
	public static final String HEADER_HOME_PAGE_LINK = "//div[@class='header-logo'//a]";
	public static final String HEADER_REGISTER_LINK = "//a[@class='ico-register']";
	public static final String HEADER_LOGIN_LINK = "//a[@class='ico-login']";

//  Footer (23 variable) 
	public static final String FOOTER_MY_ACCOUNT_LINK = "//div[@class='footer']//a[text()='My account']";
	public static final String FOOTER_SITEMAP_LINK = "//div[@class='footer']//a[text()='Sitemap']";
	public static final String FOOTER_SHIPPING_AND_RETURN_LINK = "//div[@class='footer']//a[text()='Shipping & returns']";
	public static final String FOOTER_SEARCH_LINK = "//div[@class='footer']//a[text()='Search']";
	
//
	public static final String HOME_PAGE_LINK = "//a[text()='HomePage']";
	public static final String REGISTER_LINK ="//a[@class='ico-register']" ;
	public static final String LOGIN_LINK ="//a[@class='ico-login']" ;

// Dynamic (pagename) for Footer
	public static final String DYNAMIC_FOOTER_LINK = "//div[@class='footer']//a[text()='%s']";
	public static final String DYNAMIC_RADIO_BUTTON = "//input[@id='%s']";
	public static final String DYNAMIC_TEXTBOX = "//input[@id='%s']";
	public static final String DYNAMIC_TEXTAREA = "//input[@id='%s']";
	public static final String DYNAMIC_CHECKBOX = "//input[@id='%s']";
	public static final String DYNAMIC_BUTTON = "//input[@id='%s']";
	public static final String DYNAMIC_DROPDOWN_LIST = "//select[@name='%s']";
	public static final String DYNAMIC_REQUIRED_FIELDS_ERROR_MSG = "//select[@name='%s-error']";

	
}
