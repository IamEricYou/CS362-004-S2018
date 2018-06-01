

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!



public class UrlValidatorTest extends TestCase {
	
   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
	   System.out.println(urlValid.isValid("http://www.google.com"));
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
		UrlValidator urlValid = new UrlValidator(null,null,UrlValidator.ALLOW_ALL_SCHEMES);
	
		ResultPair[] testpair = {
			//Scheme test
			new ResultPair("http://www.google.com", true),
			// new ResultPair("ftp://www.google.com", true),
			// new ResultPair("https://www.google.com", true),
			// new ResultPair("htt://www.google.com", false),
			// new ResultPair("http/www.google.com", false),
			// new ResultPair("http:/?www.google.com", false),
			// new ResultPair("http:///www.google.com", false),
			
			//Authority test
			new ResultPair("http://www.amazon.com", true),
			new ResultPair("http://255.255.255.255", true),
			new ResultPair("http://www.oregonstate.edu", true),
			new ResultPair("http://-error-.invalid/", false),
			new ResultPair("http://...", false),
			new ResultPair("http://w22ww.1234.1234", false),
			new ResultPair("http://##/##", false),
			new ResultPair("http://15.15.15.15", false),
		
			
			//Port test
			new ResultPair("http://userid@example.com:8080", true),
			new ResultPair("http://www.google.com:8000", true),
			new ResultPair("http://www.google.com:80", true),
			new ResultPair("http://www.google.com:-10", false),
			new ResultPair("http://www.google.com:66666", false),
			new ResultPair("http://www.google.com:8238a", false),

			//Path test
			new ResultPair("http://www.google.com/index", true),
			new ResultPair("http://www.google.com/index/", true),
			new ResultPair("http://www.google.com/temp/temp", true),
			new ResultPair("http://www.google.com/t88", true),
			new ResultPair("http://www.google.com/../", false),
			new ResultPair("http://www.google.com/../..", false),
			new ResultPair("http://www.google.com/..//index", false),

			//Query test
			new ResultPair("http://www.google.com?action=view", true),
			new ResultPair("http://www.google.com?action=edit=temp", true),
			new ResultPair("http://www.google.com?set=true&temp=val", true),
			new ResultPair("http://www.google.com??!?$", false),
			new ResultPair("http://www.google.com!#", false)
		};
		
	   /*System.out.println("Checking in result pair");
	   for(int i=0; i < testpair.length; i++) {
		   System.out.println("Check the URL: " + testpair[i].item + " -> " + testpair[i].valid );
	   }
	   
	   System.out.println("Checking in isValid() function");
	   for(int i = 0; i < testunit.length; i++) {
		   System.out.println("Check the URL: " + testunit[i]+ " -> " + urlValid.isValid(testunit[i]));
	   }*/
	   
	   int bad_count = 0;
	   
	   System.out.println("Check the result");
	   for(int i = 0; i < testpair.length; i++) {
		   if(testpair[i].valid != urlValid.isValid(testpair[i].item)) {
			   bad_count++;
			   System.out.println("This case is failed: " + testpair[i].item );
		   }
	   }
	   System.out.println("The result is: " + bad_count + " failed out of " + testpair.length);
   }
   
}
