// This package holds the fortunes classes.
package fortunes

// Importing the MajorArcanaCard class from the cards package.
import cards.MajorArcanaCard

// Importing necessary global functions.
import globalFunctions.findMajorArcanaCardByNumber
import globalFunctions.getInt

// Declaring the SoulCard class.
class SoulCard()
{
	// This function calculates the soul card based on a given personality card number.
	fun getSoulCard(personalityCardNumber : Int) : MajorArcanaCard {
		// If the personality card number is more than 9, it needs to be broken down further.
		return if (personalityCardNumber > 9) {
			// Converting the personality card number to string.
			val personalityCardNumberString : String = personalityCardNumber.toString()
			// Getting the integer values of the first and second digits of the personality card number.
			val number1 : Int = personalityCardNumberString.getInt(0)
			val number2 : Int = personalityCardNumberString.getInt(1)
			// Adding the two digits to get the card number.
			val cardNumber : Int = number1 + number2
			// Finding the corresponding Major Arcana Card based on the card number and returning it.
			findMajorArcanaCardByNumber(cardNumber) !!
		} else {
			// If the personality card number is less than 10, it directly corresponds to a Major Arcana Card.
			findMajorArcanaCardByNumber(personalityCardNumber) !!
		}
	}
}
