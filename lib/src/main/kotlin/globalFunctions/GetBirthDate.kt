// This package holds the global functions.
package globalFunctions

// This function gets a birthdate from the user.
fun getBirthDate() : String {
	// Declare variables to hold regex patterns and user input.
	var regex : Regex
	var birthDate : String
	var birthDay : String
	var birthMonth : String
	var birthYear : String
	
	// Prompt the user to enter the day of their birth.
	do
	{
		println("Now, I need to know your day of birth to calculate your fortune.")
		Thread.sleep(400)
		println("""What day were you born?
		|Give it in numbers from 01 to 31.""".trimMargin())
		
		// Define a regex pattern to validate the day of birth.
		regex = "^(0?[1-9]|[12][0-9]|3[01])$".toRegex()
		
		// Read the user's input.
		birthDay = readln()
		
		// Assign the user's input to the birthDate variable.
		birthDate = birthDay
		
		// If the user's input matches the regex pattern, break the loop.
		if (birthDay.matches(regex)) break
	} while (!birthDay.matches(regex))
	
	// Delay for a while.
	Thread.sleep(400)
	
	// Prompt the user to enter the month of their birth.
	do
	{
		println("Now, I need to know your month of birth to calculate your fortune.")
		Thread.sleep(400)
		println("""What month were you born?
		|Give it in numbers from 01 to 12.""".trimMargin())
		
		// Define a regex pattern to validate the month of birth.
		regex = "^(0?[1-9]|1[0-2])\$".toRegex()
		
		// Read the user's input.
		birthMonth = readln()
		
		// Add the user's input to the birthDate variable.
		birthDate += birthMonth
		
		// If the user's input matches the regex pattern, break the loop.
		if (birthMonth.matches(regex)) break
	} while (!birthMonth.matches(regex))
	
	// Delay for a while.
	Thread.sleep(400)
	
	// Prompt the user to enter the year of their birth.
	do
	{
		println("Now, I need to know your birthday to calculate your fortune.")
		Thread.sleep(400)
		println("""What year were you born?
		|Give it in all 4 numbers like 1989.""".trimMargin())
		
		// Define a regex pattern to validate the year of birth.
		regex = "^[0-9]{4}\$".toRegex()
		
		// Read the user's input.
		birthYear = readln()
		
		// Add the user's input to the birthDate variable.
		birthDate += birthYear
		
		// If the user's input matches the regex pattern, break the loop.
		if (birthYear.matches(regex)) break
	} while (!birthYear.matches(regex))
	
	// Delay for a while.
	Thread.sleep(400)
	
	// Return the birthdate.
	return birthDate
}
