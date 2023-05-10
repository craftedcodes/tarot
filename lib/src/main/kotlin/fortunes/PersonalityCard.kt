// This package holds the fortunes classes.
package fortunes

// Importing the MajorArcanaCard class from the cards package.
import cards.MajorArcanaCard

// Importing necessary global functions
import globalFunctions.finalMajorArcanaCard
import globalFunctions.getCrossSum
import globalFunctions.getInt

// Declaring the PersonalityCard class. It's open, which means it can be inherited from.
open class PersonalityCard ()
{
	// This function calculates the personality card based on a given birthdate.
	fun getPersonalityCard(birthdate : String) : MajorArcanaCard {
		// Storing the input birthdate into a local variable.
		val birthDate : String = birthdate
		
		// Converting each character in the birthdate string into an integer.
		// The getInt function presumably gets the integer value of the character at the given index.
		val number1 : Int = birthDate.getInt(0)
		val number2 : Int = birthDate.getInt(1)
		val number3 : Int = birthDate.getInt(2)
		val number4 : Int = birthDate.getInt(3)
		val number5 : Int = birthDate.getInt(4)
		val number6 : Int = birthDate.getInt(5)
		val number7 : Int = birthDate.getInt(6)
		val number8 : Int = birthDate.getInt(7)
		
		// Getting the cross sum (sum of digits) of the integers derived from the birthdate.
		val crossSum : Int = getCrossSum(number1,number2,number3,number4,number5,number6,number7,number8)
		
		// Finding the corresponding Major Arcana Card based on the cross sum and returning it.
		return finalMajorArcanaCard(crossSum)
	}
}
