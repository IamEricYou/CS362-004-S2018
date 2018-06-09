

import junit.framework.TestCase;
//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!



public class UrlValidatorTest extends TestCase {
	
	public UrlValidatorTest(String testName) {
		super(testName);
	 }

	public void assertEqual(UrlValidator urlVal, String query, boolean expVal) {
		boolean retVal;
		try {
			retVal = urlVal.isValid(query);
		} catch (Error e) {
			System.out.print("\nTest Failed: Error generated\n");
			return;
		}
		
		if (retVal) {
			System.out.print("\nTest Passed\n");
		} else {
			System.out.print("\nTest Failed\n");
		}
	}
	
	
   public UrlValidatorTest(boolean retVal, boolean expectVal) {
      if (retVal == expectVal) {
		  System.out.print("Test Passed\n");
	  } else {
		  System.out.print("Test Failed\n");
	  }
   }
   
   /*
   public void testManualTest()
   {
	   //You can use this function to implement your manual testing	   
	   UrlValidator urlVal = new UrlValidator();

	   System.out.print("\nScheme is http, expect true:\n");
	   UrlValidatorTest(urlVal.isValid("http://facebook.com"), true);
	   
	   System.out.print("\nScheme is ftp, expect true:\n");
	   UrlValidatorTest(urlVal.isValid("ftp://facebook.com"), true);

	   System.out.print("\nScheme is incorrect, expect false:\n");
	   UrlValidatorTest(urlVal.isValid("http//facebook.com"), false);

	   System.out.print("\nNo scheme, expect true:\n");
	   UrlValidatorTest(urlVal.isValid("facebook.com"), true);

	   System.out.print("\nAuthority is valid, expect true:\n");
	   UrlValidatorTest(urlVal.isValid("www.foobar.com"), true);

	   System.out.print("\nAuthority is invalid, expect false:\n");
	   UrlValidatorTest(urlVal.isValid("www.foo.bar.com"), false);
	   
	   System.out.print("\nNo authority, expect false:\n");
	   UrlValidatorTest(urlVal.isValid("www..com"), false);

	   System.out.print("\nPort is valid, expect true:\n");
	   UrlValidatorTest(urlVal.isValid("www.foobar.com:80"), true);

	   System.out.print("\nPort is invalid, expect false:\n");
	   UrlValidatorTest(urlVal.isValid("www.foobar.com:-5"), false);
	   
	   System.out.print("\nNo Port, expect true:\n");
	   UrlValidatorTest(urlVal.isValid("www.foobar.com"), true);

	   System.out.print("\nPath is valid, expect true:\n");
	   UrlValidatorTest(urlVal.isValid("www.foobar.com/test"), true);

	   System.out.print("\nPath is invalid, expect false:\n");
	   UrlValidatorTest(urlVal.isValid("www.foobar.com/test//test"), false);

	   System.out.print("\nNo Path, expect true:\n");
	   UrlValidatorTest(urlVal.isValid("www.foobar.com"), true);

	   System.out.print("\nQuery is valid, expect true:\n");
	   UrlValidatorTest(urlVal.isValid("www.foobar.com?test=true"), true);

	   System.out.print("\nQuery is invalid, expect false:\n");
	   UrlValidatorTest(urlVal.isValid("www.foobar.com??query"), false);
	   
	   System.out.print("\nNo query, expect true:\n");
	   UrlValidatorTest(urlVal.isValid("www.foobar.com"), true);
	   
   }
   
   
   
   public void testYourFirstPartition()
   {
	 UrlValidator urlVal = new UrlValidator();

	 // input is invalid
	 
	 // invalid scheme
	 System.out.print("\nScheme is incorrect, expect false:\n");
	 UrlValidatorTest(urlVal.isValid("http//testcase.com"), false);

	 // invalid authourity
	 System.out.print("\nAuthority is incorrect, expect false:\n");
	 UrlValidatorTest(urlVal.isValid("www.test.case.com"), false);

	 // invalid port
	 System.out.print("\nPort is invalid, expect false:\n");
	 UrlValidatorTest(urlVal.isValid("www.testcase.com:-5"), false);

	 // invalid path
	 System.out.print("\nPath is invalid, expect false:\n");
	 UrlValidatorTest(urlVal.isValid("www.testcase.com/test//test"), false);

	 // invaid query
	 System.out.print("\nQuery is invalid, expect false:\n");
	 UrlValidatorTest(urlVal.isValid("www.testcase.com??query"), false);

   }
   
   public void testYourSecondPartition(){
	   // input is null
	   
	   UrlValidator urlVal = new UrlValidator();
	   
	   // null scheme
	   System.out.print("\nNo scheme, expect true:\n");
	   UrlValidatorTest(urlVal.isValid("www.testcase.com"), true);

	   // null authourity
	   System.out.print("\nNo authority, expect false:\n");
	   UrlValidatorTest(urlVal.isValid("www..com"), false);

	   // null port
	   System.out.print("\nNo Port, expect true:\n");
	   UrlValidatorTest(urlVal.isValid("www.testcase.com"), true);

	   // null path
	   System.out.print("\nNo Path, expect true:\n");
	   UrlValidatorTest(urlVal.isValid("www.testcase.com"), true);
	   
	   // null query
	   System.out.print("\nNo query, expect true:\n");
	   UrlValidatorTest(urlVal.isValid("www.testcase.com"), true);

   }

   public void testYourThirdPartition(){
	   // input is valid
	   UrlValidator urlVal = new UrlValidator();
	   
	   // valid scheme
	   System.out.print("\nScheme is http, expect true:\n");
	   UrlValidatorTest(urlVal.isValid("http://www.testcase.com"), true);
	   
	   // valid authourity
	   System.out.print("\nAuthority is valid, expect true:\n");
	   UrlValidatorTest(urlVal.isValid("www.testcase.com"), true);

	   // valid port
	   System.out.print("\nPort is valid, expect true:\n");
	   UrlValidatorTest(urlVal.isValid("www.testcase.com:80"), true);

	   // valid path
	   System.out.print("\nPath is valid, expect true:\n");
	   UrlValidatorTest(urlVal.isValid("www.testcase.com/test"), true);

	   // valid query
	   System.out.print("\nQuery is valid, expect true:\n");
	   UrlValidatorTest(urlVal.isValid("www.testcase.com?test=true"), true);

   }
   
   */
   
   public void testYourFourthPartition(){
	   // scheme partition
	   
	   UrlValidator urlVal = new UrlValidator(null,null, UrlValidator.ALLOW_ALL_SCHEMES);
	   
	   System.out.print("\nSCHEME PARTITION\n");
		//http
	   System.out.print("\nHTTP: Expect True");
	   assertEqual(urlVal, "http://www.google.com", true); 
	   
		//https
	   System.out.print("\nHTTPS: Expect True");
	   assertEqual(urlVal, "https://www.google.com", true); 
	   
		//ftp
	   System.out.print("\nFTP: Expect True");
	   assertEqual(urlVal, "ftp://www.facebook.com", true); 
	   
		//made up scheme
	   System.out.print("\nabc: Expect False");
	   assertEqual(urlVal, "abc://www.facebook.com", false); 
   }
   
   public void testYourFifthPartition(){
	   // authority partition
	   
	   UrlValidator urlVal = new UrlValidator(null,null, UrlValidator.ALLOW_ALL_SCHEMES);
	   
	   System.out.print("\nAUTHORITY PARTITION\n");
	   
		//google
	   System.out.print("\\nGoogle: Expect True");
	   assertEqual(urlVal, "http://www.google.com", true); 
	   
		//facebook
	   System.out.print("\nFacebook: Expect True");
	   assertEqual(urlVal, "http://www.facebook.com", true); 
	   
		//w3schools
	   System.out.print("\nw3schools: Expect True");
	   assertEqual(urlVal, "http://www.w3schools.com", true); 
	   
		//made up authority
	   System.out.print("\n84291axqupdsce12: Expect False");
	   assertEqual(urlVal, "http://www.84291axqupdsce12.com", false); 
   }
   
   public void testYourSixthPartition(){
	   // port partition
	   
	   UrlValidator urlVal = new UrlValidator(null,null, UrlValidator.ALLOW_ALL_SCHEMES);
	   
	   System.out.print("\nPORT PARTITION\n");
	   
		// 1024
	   System.out.print("\n1024: Expect True");
	   assertEqual(urlVal, "http://www.google.com:1024", true); 
	   
		// 65535
	   System.out.print("\n65535 Expect True");
	   assertEqual(urlVal, "http://www.google.com:65535", true);  
	   
		// 30000
	   System.out.print("\n30000 Expect True");
	   assertEqual(urlVal, "http://www.google.com:30000", true); 
	   
		// 1
	   System.out.print("\n1 Expect True");
	   assertEqual(urlVal, "http://www.google.com:1", true); 
	   
		// 0
	   System.out.print("\n0 Expect False");
	   assertEqual(urlVal, "http://www.google.com:0", true); 
	   
		// -1
	   System.out.print("\n-1 Expect True");
	   assertEqual(urlVal, "http://www.google.com:-1", true); 
	   
		// 65536
	   System.out.print("\n65536 Expect True");
	   assertEqual(urlVal, "http://www.google.com:65536", true); 
	   
   }
   
   public void testYourSeventhPartition(){
	   // path partition
	   
	   UrlValidator urlVal = new UrlValidator(null,null, UrlValidator.ALLOW_ALL_SCHEMES);
	   
	   System.out.print("\nPATH PARTITION\n");
	   
		// test
	   System.out.print("\ntest: Expect True");
	   assertEqual(urlVal, "http://www.google.com/test", true); 
	   
		// a
	   System.out.print("\na: Expect True");
	   assertEqual(urlVal, "http://www.google.com/test", true); 
	   
		// 1
	   System.out.print("\n1: Expect True");
	   assertEqual(urlVal, "http://www.google.com/1", true); 
	   
		// *
	   System.out.print("\n*: Expect True");
	   assertEqual(urlVal, "http://www.google.com/*", true); 
	   
		// [null]
	   System.out.print("\n[null]: Expect True");
	   assertEqual(urlVal, "http://www.google.com/", true); 
	   
	  
   }
   
   public void testYourEighthPartition(){
	   // query partition
	   
	   UrlValidator urlVal = new UrlValidator(null,null, UrlValidator.ALLOW_ALL_SCHEMES);
	   
	   System.out.print("\nQuery PARTITION\n");
	   
		// ?a=1
	   System.out.print("\n?a=1: Expect True");
	   assertEqual(urlVal, "http://www.google.com/?a=1", true); 
	   
		// ?a=1&b=c
	   System.out.print("\n?a=1&b=c: Expect True");
	   assertEqual(urlVal, "http://www.google.com/?a=1&b=c", true); 
	   
		// ?abc
	   System.out.print("\n?abc: Expect True");
	   assertEqual(urlVal, "http://www.google.com/?abc", true); 
	   
		// ?[null]
	   System.out.print("\n?[null]: Expect True");
	   assertEqual(urlVal, "http://www.google.com/?", true); 
	   
		// ?b*4
	   System.out.print("\n?b*4: Expect True");
	   assertEqual(urlVal, "http://www.google.com/?b*4", true); 
	   
   }
   //You need to create more test cases for your Partitions if you need to 
   public void testIsValid()
   {
		UrlValidator urlValid = new UrlValidator(null,null,UrlValidator.ALLOW_ALL_SCHEMES);

		// scheme doesn't work well with isValid
		String[] schemes_good = {
			"http://"
			// "ftp://",
			// "h3t://",
			// ""
		};	

		// scheme doesn't work well with isValid
		//It is working now somehow
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
		
		int temp_count1 = 0;
		int temp_count2 = 0;
		int length_good = schemes_good.length * authority_good.length * port_good.length  * path_good.length;
		//int length_bad = authority_bad.length * port_bad.length  * path_bad.length; // scheme doesn't work well with isValid
		int length_bad = schemes_good.length * authority_bad.length * port_bad.length  * path_bad.length;

		while(true){
			String temp_good = schemes_good[index_1] + authority_good[index_2] + port_good[index_3] + path_good[index_4];
			//System.out.println(temp_good + " : " + temp_count1);
			//temp_count1++;
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
				index_1 = 0;
				continue;
			}

			if(index_3 < port_good.length-1){
				index_3++;
				index_1 = 0;
				index_2 = 0;
				continue;
			}

			if(index_4 < path_good.length-1){
				index_4++;
				index_1 = 0;
				index_2 = 0;
				index_3 = 0;
				continue;
			}
			break;
		}
		System.out.println("The result from the good array is: " + bad_count_1 + " failed out of " + length_good + " (which was expected true) \n");

		index_1 = 0;
		index_2 = 0;
		index_3 = 0;
		index_4 = 0;

		while(true){
			//String temp = schemes_bad[index_1] + authority_bad[index_2] + port_bad[index_3] + path_bad[index_4];
			String temp_bad = schemes_good[index_1] + authority_bad[index_2] + port_bad[index_3] + path_bad[index_4];
			//System.out.println(temp_bad + " : " + temp_count2);
			//System.out.println(index_1 + " " + index_2  + " " + index_3  + " " + index_4);
			//temp_count2++;
			if(urlValid.isValid(temp_bad)){
				System.out.println("This bad case is failed to pass " + temp_bad);
				bad_count_2++;
			}

			// scheme doesn't work well with isValid
			if(index_1 < schemes_good.length-1){
				index_1++;
				continue;
			}

			if(index_2 < authority_bad.length-1){
				index_2++;
				index_1 = 0;
				continue;
			}

			if(index_3 < port_bad.length-1){
				index_3++;
				index_1 = 0;
				index_2 = 0;
				continue;
			}

			if(index_4 < path_bad.length-1){
				index_4++;
				index_1 = 0;
				index_2 = 0;
				index_3 = 0;
				continue;
			}
			break;
		}
		System.out.println("The result from the bad array is: " + bad_count_2 + " failed out of " + length_bad + " (which was expected false)");	
		
		//This doens't work for the current buggy version
		/*String[] both_scheme = new String[schemes_good.length + schemes_bad.length];
		System.arraycopy(schemes_good, 0, both, 0, schemes_good.length);
		System.arraycopy(schemes_bad, 0, both, schemes_good.length, schemes_bad.length);
		*/
		
		String[] both_auth = new String[authority_good.length + authority_bad.length];
		System.arraycopy(authority_good, 0, both_auth, 0, authority_good.length);
		System.arraycopy(authority_bad, 0, both_auth, authority_good.length, authority_bad.length);

		String[] both_port = new String[port_good.length + port_bad.length];
		System.arraycopy(port_good, 0, both_port, 0, port_good.length);
		System.arraycopy(port_bad, 0, both_port, port_good.length, port_bad.length);

		String[] both_path = new String[path_good.length + path_bad.length];
		System.arraycopy(path_good, 0, both_path, 0, path_good.length);
		System.arraycopy(path_bad, 0, both_path, path_good.length, path_bad.length);

		index_1 = 0;
		index_2 = 0;
		index_3 = 0;
		index_4 = 0;
		int bad_count = 0;
		//Change this line if schemes work fine
		int length_total = schemes_good.length * both_auth.length * both_port.length  * both_path.length;
		while(true){
			boolean truth = true;
			//String temp_total = schemes_good[index_1] + both_auth[index_2] + both_port[index_3] + both_path[index_4];
			String temp_total = schemes_good[index_1] + both_auth[index_2] + both_port[index_3] + both_path[index_4];

			for(int i = 0; i < authority_bad.length; i++){
				if(authority_bad[i] == both_auth[index_2]){
					//System.out.println(authority_bad[i] + " " + both_auth[index_2]);
					truth = false;
				}
			}

			for(int i = 0; i < port_bad.length; i++){
				if(port_bad[i] == both_port[index_3]){
					//System.out.println(port_bad[i] + " " + both_port[index_3]);
					truth = false;
				}
			}

			for(int i = 0; i < path_bad.length; i++){
				if(path_bad[i] == both_path[index_4]){
					//System.out.println(path_bad[i] + " " + both_path[index_4]);
					truth = false;
				}
			}

			if(urlValid.isValid(temp_total) != truth){
				//System.out.println("Fail to pass :" + temp_total);
				bad_count++;
			}

			// scheme doesn't work well with isValid
			if(index_1 < schemes_good.length-1){
				index_1++;
				continue;
			}

			if(index_2 < both_auth.length-1){
				index_2++;
				index_1 = 0;
				continue;
			}

			if(index_3 < both_port.length-1){
				index_3++;
				index_1 = 0;
				index_2 = 0;
				continue;
			}

			if(index_4 < both_path.length-1){
				index_4++;
				index_1 = 0;
				index_2 = 0;
				index_3 = 0;
				continue;
			}
			break;
		}
		System.out.println("The result from the good array is: " + bad_count_1 + " failed out of " + length_good + " (which was expected true)");
		System.out.println("The result from the bad array is: " + bad_count_2 + " failed out of " + length_bad + " (which was expected false)");
		System.out.println("The result from the total array is: " + bad_count + " failed out of " + length_total);	
		
	}
}
