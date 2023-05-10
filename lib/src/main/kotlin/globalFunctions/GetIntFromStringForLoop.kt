// This package holds the global functions.
package globalFunctions

// This function converts each digit of a string into an integer and adds it to a list.
fun getIntFromStringForLoop(entry : String) : List<Int> {
	// Initialize an empty mutable list of integers.
	val numbers = mutableListOf<Int>()
	
	// Iterate over each character in the string.
	for (index in entry.indices) {
		// Try to convert the current character to an integer.
		val digit = entry[index].digitToIntOrNull()
		
		// If the conversion was successful (i.e., the character was a digit), add the integer to the list.
		if (digit != null) {
			numbers.add(digit)
		}
	}
	
	// Return the list of integers.
	return numbers
}
