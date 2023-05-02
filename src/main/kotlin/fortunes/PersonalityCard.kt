package fortunes

import arcanas.MajorArcana
import cards.MajorArcanaCard
import globalFunctions.findFinalMajorArcanaCard
import globalFunctions.findMajorArcanaCardByNumber

open class PersonalityCard ()
{
	fun getPersonalityCard(crossSum : Int) : MajorArcanaCard {
		return findFinalMajorArcanaCard(crossSum)
	}
}
