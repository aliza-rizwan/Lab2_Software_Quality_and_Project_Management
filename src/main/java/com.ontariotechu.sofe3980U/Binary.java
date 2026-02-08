package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 *
 */
public class Binary
{
	private String number="0";  // string containing the binary value '0' or '1'
	/**
	* A constructor that generates a binary object.
	*
	* @param number a String of the binary values. It should contain only zeros or ones with any length and order. otherwise, the value of "0" will be stored.   Trailing zeros will be excluded and empty string will be considered as zero.
	*/
	public Binary(String number) {
		if (number == null || number.isEmpty()) {
			this.number = "0"; // Default to "0" for null or empty input
			return;
		}
	
		// Validate the binary string (only '0' or '1' allowed)
		for (int i = 0; i < number.length(); i++) {
			char ch = number.charAt(i);
			if (ch != '0' && ch != '1') {
				this.number = "0"; // Default to "0" for invalid input
				return;
			}
		}
	
		// Remove leading zeros
		int beg;
		for (beg = 0; beg < number.length(); beg++) {
			if (number.charAt(beg) != '0') {
				break;
			}
		}
	
		// If all digits are '0', ensure number is "0"
		this.number = (beg == number.length()) ? "0" : number.substring(beg);
	
		// uncomment the following code
		/*
		if (this.number.isEmpty()) { // replace empty strings with a single zero
			this.number = "0";
		}
  		*/
	}
	/**
	* Return the binary value of the variable
	*
	* @return the binary value in a string format.
	*/
	public String getValue()
	{
		return this.number;
	}
	/**
	* Adding two binary variables. For more information, visit <a href="https://www.wikihow.com/Add-Binary-Numbers"> Add-Binary-Numbers </a>.
	*
	* @param num1 The first addend object
	* @param num2 The second addend object
	* @return A binary variable with a value of <i>num1+num2</i>.
	*/
	public static Binary add(Binary num1,Binary num2)
	{
		// the index of the first digit of each number
		int ind1=num1.number.length()-1;
		int ind2=num2.number.length()-1;
		//initial variable
		int carry=0;
		String num3="";  // the binary value of the sum
		while(ind1>=0 ||  ind2>=0 || carry!=0) // loop until all digits are processed
		{
			int sum=carry; // previous carry
			if(ind1>=0){ // if num1 has a digit to add
				sum += (num1.number.charAt(ind1)=='1')? 1:0; // convert the digit to int and add it to sum
				ind1--; // update ind1
			}
			if(ind2>=0){ // if num2 has a digit to add
				sum += (num2.number.charAt(ind2)=='1')? 1:0; // convert the digit to int and add it to sum
				ind2--; //update ind2
			}
			carry=sum/2; // the new carry
			sum=sum%2;  // the resultant digit
			num3 =( (sum==0)? "0":"1")+num3; //convert sum to string and append it to num3
		}
		Binary result=new Binary(num3);  // create a binary object with the calculated value.
		return result;
		
	}

	//Bitwise OR
	/**
	 * Performs a bitwise logical OR operation on two binary values.
	 * The two binary values are first padded with leading zeros to ensure
	 * they are of equal length. The OR operation is then applied bit by bit.
	 *
	 * @param a the first binary value
	 * @param b the second binary value
	 * @return a Binary object representing the result of the OR operation
	 */
    public static Binary or(Binary a, Binary b) {
    String x = a.getValue();
    String y = b.getValue();

    int maxLen = Math.max(x.length(), y.length());
    x = String.format("%" + maxLen + "s", x).replace(' ', '0');
    y = String.format("%" + maxLen + "s", y).replace(' ', '0');

    StringBuilder result = new StringBuilder();
    for (int i = 0; i < maxLen; i++) {
        result.append((x.charAt(i) == '1' || y.charAt(i) == '1') ? '1' : '0');
    }

    return new Binary(result.toString());
    }

    //Bitwise AND
	/**
	 * Performs a bitwise logical AND operation on two binary values.
	 * Both binary values are padded with leading zeros so they have
	 * the same length before the AND operation is applied bit by bit.
	 *
	 * @param a the first binary value
	 * @param b the second binary value
	 * @return a Binary object representing the result of the AND operation
	 */

    public static Binary and(Binary a, Binary b) {
    String x = a.getValue();
    String y = b.getValue();

    int maxLen = Math.max(x.length(), y.length());
    x = String.format("%" + maxLen + "s", x).replace(' ', '0');
    y = String.format("%" + maxLen + "s", y).replace(' ', '0');

    StringBuilder result = new StringBuilder();
    for (int i = 0; i < maxLen; i++) {
        result.append((x.charAt(i) == '1' && y.charAt(i) == '1') ? '1' : '0');
    }

    return new Binary(result.toString());
    }

    //Multiply
	/**
	 * Performs binary multiplication between two binary values.
	 * The multiplication is implemented using repeated addition and
	 * left shifting. The existing add function is reused to add up the final result.
	 *
	 * @param a the first binary value (multiplicand)
	 * @param b the second binary value (multiplier)
	 * @return a Binary object representing the result of the multiplication
	 */
    public static Binary multiply(Binary a, Binary b) {
    Binary result = new Binary("0");
    String y = b.getValue();

    int shift = 0;
    for (int i = y.length() - 1; i >= 0; i--) {
        if (y.charAt(i) == '1') {
            String shifted = a.getValue() + "0".repeat(shift);
            result = Binary.add(result, new Binary(shifted));
        }
        shift++;
    }
    return result;
    }

}	
