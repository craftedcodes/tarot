package globalFunctions

fun findFinalMajorArcanaCard(crossSum : Int) = if (crossSum in 22 .. 41)
{
	val cardNumber : Int = crossSum - 21
	findMajorArcanaCardByNumber(cardNumber) !!
}
else if (crossSum > 42)
{
	val crossSumString = crossSum.toString()
	val number1 : Int = crossSumString.getInt(0)
	val number2 : Int = crossSumString.getInt(1)
	val cardNumber : Int = number1 + number2
	findMajorArcanaCardByNumber(cardNumber) !!
}
else
{
	val cardNumber : Int = crossSum
	findMajorArcanaCardByNumber(cardNumber) !!
}
