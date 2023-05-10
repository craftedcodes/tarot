// This package holds the fortunes classes.
package fortunes

// Importing the MajorArcanaCard class from the cards package.
import cards.MajorArcanaCard

// Importing necessary global functions.
import globalFunctions.finalMajorArcanaCard
import globalFunctions.getCrossSum
import globalFunctions.getInt

// Importing the Year class from java.time package.
import java.time.Year

// Declaring the YearCard class.
class YearCard
{
	// This function calculates the year card based on a given birthdate and the current year.
	fun getYearCard(birthDate : String) : MajorArcanaCard
	{
		// Getting the current year as a string
		val currentYear : String = Year.now().toString()
		
		// Converting each character in the birthdate string into an integer.
		val number1 : Int = birthDate.getInt(0)
		val number2 : Int = birthDate.getInt(1)
		val number3 : Int = birthDate.getInt(2)
		val number4 : Int = birthDate.getInt(3)
		
		// Converting each character in the current year string into an integer.
		val number5 : Int = currentYear.getInt(0)
		val number6 : Int = currentYear.getInt(1)
		val number7 : Int = currentYear.getInt(2)
		val number8 : Int = currentYear.getInt(3)
		
		// Getting the cross sum (sum of digits) of the integers derived from the birth date and the current year.
		val crossSum : Int = getCrossSum(number1, number2, number3, number4, number5, number6, number7, number8)
		
		// Finding the corresponding Major Arcana Card based on the cross sum and returning it.
		return finalMajorArcanaCard(crossSum)
	}
}
