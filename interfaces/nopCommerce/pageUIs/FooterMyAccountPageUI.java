package nopCommerce.pageUIs;

public class FooterMyAccountPageUI {

//	Header (5 Variable)
	public static final String HEADER_MY_ACCOUNT_LINK = "//a[@class='ico-account']";
	public static final String HEADER_WISHLIST_LINK = "//span[@class='wishlist-label']";
	public static final String HEADER_SHOPPING_CART_LINK = "//span[@class='cart-label']";

//  Footer (23 variable) 
	public static final String FOOTER_MY_ACCOUNT_LINK = "//div[@class='footer']//a[text()='My account']";
	public static final String FOOTER_SITEMAP_LINK = "//div[@class='footer']//a[text()='Sitemap']";
	public static final String FOOTER_SHIPPING_AND_RETURN_LINK = "//div[@class='footer']//a[text()='Sitemap']";
	public static final String FOOTER_SEARCH_LINK = "//div[@class='footer']//a[text()='Search']";
	
	public static final String SubPage_MYACCOUNT = "//div[@class='listbox']//ul[@class='list']//a[@class='inactive'][contains(text(),'%s')]";
	public static final String ADDRESS_MYACC = "//a[@class='inactive'][contains(text(),'Addresses')]";
	
//	public static final String BtnADDNEW ="//input[@class='button-1 add-address-button']";
	public static final String BtnDYNAMIC = "//input[@class='%s']";
	public static final String changePASSWORD = "//input[@id='%s']";
	public static final String MessageCHANGEPASS = "//div[@class='result']";
	
	public static final String BodyREVIEW = "//div[@class=\"product-review-item\"]";

}
