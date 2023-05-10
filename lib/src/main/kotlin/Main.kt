// Import the necessary classes and functions
import cards.MajorArcanaCard
import fortunes.PersonalityCard
import fortunes.SoulCard
import fortunes.YearCard
import globalFunctions.getBirthDate
import globalFunctions.getCrossSum
import globalFunctions.getInt

// Main function
fun main() {
	// Get the birth date from the user
	val birthDate : String = getBirthDate()
	
	// Extract each digit from the birth date
	val number1 : Int = birthDate.getInt(0)
	val number2 : Int = birthDate.getInt(1)
	val number3 : Int = birthDate.getInt(2)
	val number4 : Int = birthDate.getInt(3)
	val number5 : Int = birthDate.getInt(4)
	val number6 : Int = birthDate.getInt(5)
	val number7 : Int = birthDate.getInt(6)
	val number8 : Int = birthDate.getInt(7)
	
	// Calculate the cross sum of the birth date
	val crossSum : Int = getCrossSum(number1, number2, number3, number4, number5, number6, number7, number8)
	
	// Get the Personality Card based on the birth date
	val personalityCard : MajorArcanaCard = PersonalityCard().getPersonalityCard(birthDate)
	// Print the Personality Card's number, name, and meaning
	println(personalityCard.number)
	println(personalityCard.name)
	println(personalityCard.meaning)
	
	// Get the Soul Card based on the Personality Card's number
	val soulCard : MajorArcanaCard = SoulCard().getSoulCard(personalityCard.number)
	// Print the Soul Card's number, name, and meaning
	println(soulCard.number)
	println(soulCard.name)
	println(soulCard.meaning)
	
	// Get the Year Card based on the birth date
	val yearCard : MajorArcanaCard = YearCard().getYearCard(birthDate)
	// Print the Year Card's number, name, and meaning
	println(yearCard.number)
	println(yearCard.name)
	println(yearCard.meaning)
}
