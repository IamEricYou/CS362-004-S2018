

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!



public class UrlValidatorTest extends TestCase {
	UrlValidator urlValid = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
	
   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
	   //You can use this function to implement your manual testing	   
	   //assertFalse(urlValid.isValid("http://www.google.com"));
	  
   }
   
   
   public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing
	   //String[] 
	   
   }
   
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing	   

   }
   //You need to create more test cases for your Partitions if you need to 
   
   public void testIsValid()
   {
	   /*
	    *  ResultPair.java (it had a bug, so I've fixed it)
	    * */
	   
	   //http://formvalidation.io/validators/uri/
	   
	   String[] testunit = {
			   "http://www.google.com",
			   "http://www.amazon.com",
			   "http://foo.com/blah_blah",
			   "http:///a",
			   "http://userid:password@example.com/",
			   "http://-error-.invalid/",
			   "http://255.255.255.255",
			   "http://userid@example.com:8080",
			   "http://##/##",
			   "http://google"
			   
			   //"https://www.google.com",
			   //"httt://www.google.com"
			   //"ftp://w22ww.1234.1234"
	   };
	   
	   ResultPair[] testpair = {
			   new ResultPair("http://www.google.com", true),
			   new ResultPair("http://www.amazon.com", true),
			   new ResultPair("http://foo.com/blah_blah", true),
			   new ResultPair("http:///a", false),
			   new ResultPair("http://userid:password@example.com/", true),
			   new ResultPair("http://-error-.invalid/", false),
			   new ResultPair("http://255.255.255.255", true),
			   new ResultPair("http://userid@example.com:8080", true),
			   new ResultPair("http://##/##", false),
			   new ResultPair("http://google", false)
			  
			   //new ResultPair("https://www.google.com", true)
			   //new ResultPair("httt://www.google.com", false) //can't compile when the url doesn't start with http
			   //new ResultPair("ftp://w22ww.1234.1234", false) //can't compile with this line
	   };
	   
	   /*System.out.println("Checking in result pair");
	   for(int i=0; i < testpair.length; i++) {
		   System.out.println("Check the URL: " + testpair[i].item + " -> " + testpair[i].valid );
	   }
	   
	   System.out.println("Checking in isValid() function");
	   for(int i = 0; i < testunit.length; i++) {
		   System.out.println("Check the URL: " + testunit[i]+ " -> " + urlValid.isValid(testunit[i]));
	   }*/
	   
	   int good_count = 0;
	   int bad_count = 0;
	   
	   System.out.println("Check the result");
	   for(int i = 0; i < testunit.length; i++) {
		   if(testpair[i].valid != urlValid.isValid(testunit[i])) {
			   bad_count++;
			   System.out.println("This case is failed: " + testpair[i].item );
		   }
		   good_count++;
	   }
	   System.out.println("The result is: " + bad_count + " failed out of " + good_count);
   }
   
}
