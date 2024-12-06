// File path for file accessing, common values are set in this class.

package Constants;

public class Constants 
{
	public static final String TestDataFile = "";                                        // mention ppty file path
	public static final String CONFIGFILE = System.getProperty("user.dir") + "\\src\\main\\resources\\Config.properties"; // ppty file path | Create inside src/main/resourse |	
	public static final int EXPLICITWAIT = 10;                                          // explicit wait constants	
	public static final String NOTES_FILEPATH = System.getProperty("user.dir") + "\\src\\main\\resources\\uploads\\selenium.jpg"; 	
	public static final String EXCEL_FILEPATH = "\\src\\main\\resources\\uploads\\invalid_login_ExcelRead.xlsx";
	public static final String SHEET_NAME = "Sheet1";	
	public static final int EXCEL_ROWCOUNT = 0;
	public static final int EXCEL_COLUMNCOUNT = 1;
}
