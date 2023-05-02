package globalFunctions

fun String.getInt(index : Int): Int {
	return try {
		this[index].digitToInt()
	} catch (ex: Exception) {
		println("""Deine Eingabe entspricht scheinbar nicht dem Format TT.MM.JJJJ.
			Bitte gib nochmal dein Geburtsdatum ein.
		""".trimIndent())
		return 0
	}
}
