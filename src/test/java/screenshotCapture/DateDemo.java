package screenshotCapture;

import java.util.Date;

public class DateDemo {

	public static void main(String[] args) {
		Date d= new Date();
		String str=d.toString().replace(" ","_").replace(":","_") + ".png";
		//Wed_Nov_13_10_03_54_IST_2024.png
		System.out.println(str);

	}

}
