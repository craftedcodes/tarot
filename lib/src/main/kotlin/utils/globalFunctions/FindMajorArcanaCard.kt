// This package holds the global functions.
package utils.globalFunctions

// Importing the MajorArcana class from the arcanas package.
import arcanas.MajorArcana

// Importing the MajorArcanaCard class from the cards package.
import cards.MajorArcanaCard

// This function finds a Major Arcana Card based on a given number.
fun findMajorArcanaCardByNumber(number: Int): MajorArcanaCard? {
	// Creating an instance of the MajorArcana class and getting the major arcana cards.
	val majorArcana = MajorArcana().majorArcana
	
	// Searching for a card in the major arcana list whose number matches the input number
	// If such a card is found, it's returned. If not, null is returned.
	return majorArcana.find { it.number == number }
}
