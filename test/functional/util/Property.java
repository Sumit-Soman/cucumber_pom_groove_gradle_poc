package util;


public class Property {
	
	public static int creativeVersion = 0;
	public static String psvrCreative = null;
	public static String dnsGroup = null;
	public static String vendorName = null;
	public static String vendorAbbr = null;
	public static String affliationName =  null;
	public static String separator = System.getProperty("file.separator");
	
	public static String exportExcelPath = System.getProperty("user.dir") + separator + "test" + separator + "resources" + separator +
			"data" + separator;
	public static String screenShotPath = "target" + separator + "test-reports" + separator +
             "failedscreenshots" + separator;
	public static String stationCode = null;
}
