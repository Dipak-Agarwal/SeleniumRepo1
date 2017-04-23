package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {

	public static String getCurrentTime()
	{
		
		SimpleDateFormat customFormat=new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss");
		
		Date currentDate=new Date();
		
	    String mydate=customFormat.format(currentDate);
	
		return mydate;
		
	}

}
