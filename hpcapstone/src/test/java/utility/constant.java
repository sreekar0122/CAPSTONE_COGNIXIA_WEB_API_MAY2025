package utility;

public class constant {
	
	public static final String browser = "chrome";
	public static final String amazon_appUrl = "https://www.amazon.in/";
	public static final String onlytest_appUrl = "http://only-testing-blog.blogspot.com/2013/11/new-test.html";
	public static final String demoqa_appUrl = "https://demoqa.com/automation-practice-form";
	public static final String hrm_appURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	public static final String sample_URL = "http://only-testing-blog.blogspot.com/2013/11/new-test.html";
	public static final String sample = "https://www.globalsqa.com/demo-site/draganddrop/";
	public static final String alert_url = "https://demo.automationtesting.in/Alerts.html";
	public static final String iframe_url = "https://demo.automationtesting.in/Frames.html";
	public static final String hrmAdminuser = "Admin";
	public static final String hrmAdminpass = "admin123";
	public static final String EcomLogin_appurl = "https://ecommerce-playground.lambdatest.io/index.php?route=account/login";
	public static final String EcomRegister_appurl = "https://ecommerce-playground.lambdatest.io/index.php?route=account/register";
	
//	------------------------------------------------------------------------------------
	public static final String Demoqa_appurl = "https://demoqa.com/";
	
	// Page paths
	public static final String LOGIN_PAGE = "login";
	public static final String LOGIN_PAGE_URL = Demoqa_appurl + LOGIN_PAGE;
	public static final String PROFILE_PAGE_FRAGMENT = "profile"; // used in URL contains

	// Valid credentials
	public static final String VALID_USERNAME = "sreekar";
	public static final String VALID_PASSWORD = "Sreekar@1";

	// Invalid credentials
	public static final String INVALID_USERNAME = "invalidUser";
	public static final String INVALID_PASSWORD = "wrongPassword";
	public static final String WRONG_USERNAME = "wrongUser";

	// Expected error/warning messages
	public static final String INVALID_LOGIN_MSG = "Invalid username or password!";
    
    // Book Search
    public static final String BOOKS_PAGE = "books";
    public static final String POSITIVE_SEARCH_TERM = "Git";
    public static final String POSITIVE_BOOK_RESULT = "Git Pocket Guide";

    public static final String NEGATIVE_SEARCH_TERM = "InvalidBookXYZ";
    public static final String NEGATIVE_BOOK_RESULT = "InvalidBookXYZ";
    
    //Form_page
    public static final String FORM_PAGE = "automation-practice-form";
    
    // Positive Form Data
    public static final String FORM_FIRST_NAME_VALID = "John";
    public static final String FORM_LAST_NAME_VALID = "Doe";
    public static final String FORM_EMAIL_VALID = "john.doe@example.com";
    public static final String FORM_MOBILE_VALID = "9876543210";

    // Negative Form Data
    public static final String FORM_FIRST_NAME_INVALID = "";
    public static final String FORM_LAST_NAME_INVALID = "Smith";
    public static final String FORM_EMAIL_INVALID = "invalid-email";
    public static final String FORM_MOBILE_INVALID = "";

}
