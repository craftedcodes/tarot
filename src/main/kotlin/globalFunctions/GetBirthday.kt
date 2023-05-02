package globalFunctions

fun getBirthDate() : String {
	var regex : Regex
	var birthDate : String
	var birthDay : String
	var birthMonth : String
	var birthYear : String
	
	do
	{
		println("Now, I need to know your day of birth to calculate your fortune.")
		Thread.sleep(400)
		println("""What day were you born?
		|Give it in numbers from 01 to 31.""".trimMargin())
		regex = "^(0?[1-9]|[12][0-9]|3[01])$".toRegex()
		birthDay = readln()
		birthDate = birthDay
		if (birthDay.matches(regex)) break
	} while (!birthDay.matches(regex))
	
	Thread.sleep(400)
	do
	{
		println("Now, I need to know your month of birth to calculate your fortune.")
		Thread.sleep(400)
		println("""What month were you born?
		|Give it in numbers from 01 to 12.""".trimMargin())
		regex = "^(0?[1-9]|1[0-2])\$".toRegex()
		birthMonth = readln()
		birthDate += birthMonth
		if (birthMonth.matches(regex)) break
	} while (!birthMonth.matches(regex))
	
	Thread.sleep(400)
	do
	{
		println("Now, I need to know your birthday to calculate your fortune.")
		Thread.sleep(400)
		println("""What year were you born?
		|Give it in all 4 numbers like 1989.""".trimMargin())
		
		regex = "^[0-9]{4}\$".toRegex()
		
		birthYear = readln()
		birthDate += birthYear
		if (birthYear.matches(regex)) break
	} while (!birthYear.matches(regex))
	
	Thread.sleep(400)
	return birthDate
}
