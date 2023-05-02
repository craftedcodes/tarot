package fortunes

import cards.MajorArcanaCard
import globalFunctions.findFinalMajorArcanaCard
import globalFunctions.getCrossSum
import globalFunctions.getInt
import java.time.Year

class YearCard
{
	
	
	fun getYearCard(birthDate : String) : MajorArcanaCard
	{
		val currentYear : String = Year.now().toString()
		val number1 : Int = birthDate.getInt(0)
		val number2 : Int = birthDate.getInt(1)
		val number3 : Int = birthDate.getInt(2)
		val number4 : Int = birthDate.getInt(3)
		val number5 : Int = currentYear.getInt(0)
		val number6 : Int = currentYear.getInt(1)
		val number7 : Int = currentYear.getInt(2)
		val number8 : Int = currentYear.getInt(3)
		
		val crossSum : Int = getCrossSum(number1, number2, number3, number4, number5, number6, number7, number8)
		
		return findFinalMajorArcanaCard(crossSum)
	}
}
