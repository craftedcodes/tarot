package globalFunctions

import arcanas.MajorArcana
import cards.MajorArcanaCard

fun findMajorArcanaCardByNumber(number: Int): MajorArcanaCard? {
	val majorArcana = MajorArcana().majorArcana
	return majorArcana.find { it.number == number }
}
