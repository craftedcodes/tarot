import cards.MajorArcanaCard
import fortunes.PersonalityCard
import fortunes.SoulCard
import fortunes.YearCard
import globalFunctions.getBirthDate
import globalFunctions.getCrossSum
import globalFunctions.getInt
fun main() {
	val birthDate : String = getBirthDate()
	val number1 : Int = birthDate.getInt(0)
	val number2 : Int = birthDate.getInt(1)
	val number3 : Int = birthDate.getInt(2)
	val number4 : Int = birthDate.getInt(3)
	val number5 : Int = birthDate.getInt(4)
	val number6 : Int = birthDate.getInt(5)
	val number7 : Int = birthDate.getInt(6)
	val number8 : Int = birthDate.getInt(7)
	val crossSum : Int = getCrossSum(number1,number2,number3,number4,number5,number6,number7,number8)
	val personalityCard : MajorArcanaCard = PersonalityCard().getPersonalityCard(crossSum)
	println(personalityCard.number)
	println(personalityCard.name)
	println(personalityCard.meaning)
	val soulCard : MajorArcanaCard = SoulCard().getSoulCard(personalityCard.number)
	println(soulCard.number)
	println(soulCard.name)
	println(soulCard.meaning)
	val yearCard : MajorArcanaCard = YearCard().getYearCard(birthDate)
	println(yearCard.number)
	println(yearCard.name)
	println(yearCard.meaning)
}
