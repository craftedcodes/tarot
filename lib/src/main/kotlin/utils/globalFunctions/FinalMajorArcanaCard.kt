// This package holds the global functions.
package utils.globalFunctions

// This function finds the final Major Arcana Card based on a given cross sum.
fun finalMajorArcanaCard(crossSum : Int) =
		// If the cross sum is between 22 and 41, subtract 21 from it to get the card number.
		if (crossSum in 22 .. 41)
		{
			val cardNumber : Int = crossSum - 21
			// Find the Major Arcana Card corresponding to the card number and return it.
			findMajorArcanaCardByNumber(cardNumber) !!
		}
		// If the cross sum is greater than 42, break it down into two digits and add them together to get the card number.
		else if (crossSum > 42)
		{
			// Converting the cross sum to string.
			val crossSumString = crossSum.toString()
			// Getting the integer values of the first and second digits of the cross sum.
			val number1 : Int = crossSumString.getInt(0)
			val number2 : Int = crossSumString.getInt(1)
			// Adding the two digits to get the card number.
			val cardNumber : Int = number1 + number2
			// Finding the corresponding Major Arcana Card based on the card number and returning it.
			findMajorArcanaCardByNumber(cardNumber) !!
		}
		// If the cross sum is less than 22, it directly corresponds to a Major Arcana Card.
		else
		{
			val cardNumber : Int = crossSum
			// Finding the corresponding Major Arcana Card based on the card number and returning it.
			findMajorArcanaCardByNumber(cardNumber) !!
		}
