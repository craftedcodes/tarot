package globalFunctions

// Hier wird die Zahl aus dem String extrahiert und in eine MutableList hinzugefügt
fun getIntFromStringForLoop(entry : String) : List<Int> {
	val numbers = mutableListOf<Int>()
	for (index in entry.indices) {
		val digit = entry[index].digitToIntOrNull()
		if (digit != null) {
			numbers.add(digit)
		}
	}
	return numbers
}
