package util;


import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ConfigurationReader {
	private Properties PRO;
	
//	public ConfigurationReader(){
//		
//		File src=new File("Configuration/config.properties");
//		FileInputStream FIS;
//		try {
//			FIS = new FileInputStream(src);		
//			PRO= new Properties();	
//			PRO.load(FIS);
//		} catch (Exception e) {
//			
//			System.out.println("Exception is: "+ e.getMessage());
//		}
//		
//		
//	}
	public Properties init_prop() {
		
		FileInputStream FIS;
		PRO= new Properties();	
		try {
			File src=new File("Configuration/config.properties");
			FIS = new FileInputStream(src);		
			PRO= new Properties();	
			PRO.load(FIS);
		} catch (Exception e) {
			
			System.out.println("Exception is: "+ e.getMessage());
		}
		return PRO;
	}
	
//	public String getChromePath(){
//		return PRO.getProperty("ChromeDriver");
//	}
//	public String getApplicationURL(){
//		return PRO.getProperty("url");
//	}
//	public String getExcelPath(){
//		return PRO.getProperty("ExcelPath");
//	}
//	public String getIePath(){
//		return PRO.getProperty("IEDriver");
//	}
//	public String getUsernamePath(){
//		return PRO.getProperty("UsernamePath");
//	}
//	public String getPasswordPath(){
//		return PRO.getProperty("PasswordPath");
//	}
//	
//	public String getSignInPath(){
//		return PRO.getProperty("SignInPath");
//	}
//	public String getExcel2Path(){
//		return PRO.getProperty("Excel2Path");
//	}
//	public String getMercurySignUpUrl(){
//		return PRO.getProperty("MercurySignUpUrl");
//	}
//	public String getDriverManager() {
//		return PRO.getProperty("driverManager");
//	}
//	public String getDriverType() {
//		return PRO.getProperty("driverType");
//	}
}
