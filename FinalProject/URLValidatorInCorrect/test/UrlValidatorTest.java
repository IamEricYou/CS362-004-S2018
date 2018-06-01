

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!



public class UrlValidatorTest extends TestCase {
	
   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {//You can use this function to implement your manual testing	   
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
		UrlValidator urlValid = new UrlValidator(null,null,UrlValidator.ALLOW_ALL_SCHEMES);

		// scheme doesn't work well with isValid
		String[] schemes_good = {
			"http://"
			//"ftp://",
			//"h3t://",
			//""
		};	

		// scheme doesn't work well with isValid
		String[] schemes_bad = {
			"3ht://",
			"http:/",
			"htttP://",
			"http:",
			"://"
		};

		String[] authority_good = {
			"www.google.com",
			"www.amazon.com",
			"www.facebook.com",
			"0.0.0.0",
			"255.255.255.255",
			"255.com"
		};

		String[] authority_bad = {
			"w1w1w.google.com",
			"zzz.zzz.zzz",
			"@.@.@.@",
			".1.2.3.4",
			"www.@#!@#.$$$",
			"300.300.300.300",
			"go.a",
			"aaa",
			"",
			"255.255.255.255.255"
		};

		String[] port_good ={
			":80",
			":65535",
			":0",
			""
		};

		String[] port_bad = {
			":65636",
			":-1",
			":44a",
			":-aaaa"
		};

		String[] path_good = {
			"/temp",
			"/temp12",
			"/index_1",
			"/index/",
			"/index/file",
			"/$333",
			"/",
			""
		};

		String[] path_bad = {
			"/../",
			"///",
			"/../..",
			"/../index",
			"/index//file",
			"/./"
		};

		int bad_count_1 = 0;
		int bad_count_2 = 0;
		int index_1 = 0;
		int index_2 = 0;
		int index_3 = 0;
		int index_4 = 0;
		
		int length_good = schemes_good.length * authority_good.length * port_good.length  * path_good.length;
		int length_bad = authority_bad.length * port_bad.length  * path_bad.length; // scheme doesn't work well with isValid
		// int length_bad = schemes_bad.length * authority_bad.length * port_bad.length  * path_bad.length;
		while(true){
			String temp_good = schemes_good[index_1] + authority_good[index_2] + port_good[index_3] + path_good[index_4];
			if(!urlValid.isValid(temp_good)){
				System.out.println("This good case is failed to pass " + temp_good);
				bad_count_1++;
			}
			if(index_1 < schemes_good.length-1){
				index_1++;
				continue;
			}

			if(index_2 < authority_good.length-1){
				index_2++;
				continue;
			}

			if(index_3 < port_good.length-1){
				index_3++;
				continue;
			}

			if(index_4 < path_good.length-1){
				index_4++;
				continue;
			}
			break;
		}

		index_1 = 0;
		index_2 = 0;
		index_3 = 0;
		index_4 = 0;

		while(true){
			//String temp = schemes_bad[index_1] + authority_bad[index_2] + port_bad[index_3] + path_bad[index_4];
			String temp_bad = schemes_good[index_1] + authority_bad[index_2] + port_bad[index_3] + path_bad[index_4];
			
			if(urlValid.isValid(temp_bad)){
				System.out.println("This bad case is failed to pass " + temp_bad);
				bad_count_2++;
			}

			// scheme doesn't work well with isValid
			/*if(index_1 < schemes_bad.length-1){
				index_1++;
				continue;
			}*/

			if(index_2 < authority_bad.length-1){
				index_2++;
				continue;
			}

			if(index_3 < port_bad.length-1){
				index_3++;
				continue;
			}

			if(index_4 < path_bad.length-1){
				index_4++;
				continue;
			}
			break;
		}
		System.out.println("The result is: " + bad_count_1 + " failed out of " + length_good);
		System.out.println("These " + bad_count_1 + " URL is valid, but the isValid function didn't work well");
		System.out.println("The result is: " + bad_count_2 + " failed out of " + length_bad);
		System.out.println("These " + bad_count_2 + " URL is invalid, but the isValid function didn't work well");
	}
}
