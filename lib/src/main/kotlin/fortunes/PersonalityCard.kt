package fortunes

import cards.MajorArcanaCard
import globalFunctions.findFinalMajorArcanaCard

open class PersonalityCard ()
{
	fun getPersonalityCard(crossSum : Int) : MajorArcanaCard {
		return findFinalMajorArcanaCard(crossSum)
	}
}
