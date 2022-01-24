/** A utility class to make available the padLeft method
	@author Andrew McAllister
*/
public class Util
{
  	//*********************************************************************
  	/** Pads a String with blanks on the left until the String
      	reaches the specified string length. 
     	@param s The String to be padded.
      	@param width The desired String length.
      	@return The padded String. If the given String is longer than the 
      	specified length, the entire String is returned.
  	*/
  	public static String padLeft(String s, int width)
  	{ 	String r = s;
    	while (r.length() < width)
      		r = " " + r;
    	return r;
  	}
} // end class