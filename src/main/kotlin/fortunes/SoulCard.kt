package fortunes

import cards.MajorArcanaCard
import globalFunctions.findMajorArcanaCardByNumber
import globalFunctions.getInt

class SoulCard()
{
	fun getSoulCard(personalityCardNumber : Int) : MajorArcanaCard {
		return if (personalityCardNumber > 9) {
			val personalityCardNumberString : String = personalityCardNumber.toString()
			val number1 : Int = personalityCardNumberString.getInt(0)
			val number2 : Int = personalityCardNumberString.getInt(1)
			val cardNumber : Int = number1 + number2
			findMajorArcanaCardByNumber(cardNumber) !!
		} else {
			findMajorArcanaCardByNumber(personalityCardNumber) !!
		}
	}
}
