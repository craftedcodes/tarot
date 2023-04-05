import java.time.Year

// Geburtstagseingabe
fun birthday(birthday : String = readln()) : String {
	// TODO: Wenn for loops gemacht, in if else und iterieren abchecken, ob Eingabe richtig ist und dann Exception abfangen.
	return birthday
}

// Hier wird die Zahl aus dem String extrahiert
// TODO: Try-Catch umbauen
fun getIntFromString(variable : String, index : Int) : Int
{
	return try {
		variable[index].digitToInt()
	} catch (ex: Exception) {
		println("""Deine Eingabe entspricht scheinbar nicht dem Format TT.MM.JJJJ.
			Bitte gib nochmal dein Geburtsdatum ein.
		""".trimIndent())
		return 0
	}
}

// Quersummenberechnung
//? Check, ob es eine Listenfunktion, die die Summe aller Int Inhalte
fun calAddEightNum(
		number1 : Int,
		number2 : Int,
		number3 : Int,
		number4 : Int,
		number5 : Int,
		number6 : Int,
		number7 : Int,
		number8 : Int,
                  ) : Int
{
	return number1 + number2 + number3 + number4 + number5 + number6 + number7 + number8
}

// Karten mischen Funktion
fun shuffleCards(cardDeck : MutableMap<String, String>) : MutableList<String>
{
	return cardDeck.keys.shuffled().toMutableList()
}

// Berechnung der finalen Karte
fun finalCard(calculation : Int, cardDeck : MutableMap<String, String>) : List<String>
{
	val usedCardDeck : Map<String, String> = cardDeck.toMap()
	if (calculation in 22 .. 41)
	{
		val cardNumber : String = (calculation - 21).toString()
		val cardDeckNames : MutableList<String> = cardDeck.keys.toMutableList()
		val cardName : String = cardDeckNames.find { it.startsWith(cardNumber) } ?: ""
		val cardMeaning : String = usedCardDeck.getValue(cardName)
		
		println("""Deine Karte ist $cardName und sie bedeutet:
				$cardMeaning""".trimIndent())
		return listOf(cardName, cardMeaning)
	}
	else if (calculation > 42)
	{
		val midNumber : String = calculation.toString()
		val midNumber1 : Int = getIntFromString(midNumber, 0)
		val midNumber2 : Int = getIntFromString(midNumber, 1)
		val cardNumber : String = (midNumber1 + midNumber2).toString()
		val cardDeckNames : MutableList<String> = cardDeck.keys.toMutableList()
		val cardName : String = cardDeckNames.find { it.startsWith(cardNumber) } ?: ""
		return if (cardName == "")
		{
			println("Deine Karte gibt es nicht")
			listOf("", "")
		}
		else
		{
			val cardMeaning : String = usedCardDeck.getValue(cardName)
			
			println("""Deine Karte ist $cardName und sie bedeutet:
				$cardMeaning""".trimIndent())
			listOf(cardName, cardMeaning)
		}
	}
	else
	{
		val cardNumber : String = calculation.toString()
		val cardDeckNames : MutableList<String> = cardDeck.keys.toMutableList()
		val cardName : String = cardDeckNames.find { it.startsWith(cardNumber) } ?: ""
		return if (cardName == "")
		{
			println("Deine Karte gibt es nicht")
			listOf("", "")
		}
		else
		{
			val cardMeaning : String = usedCardDeck.getValue(cardName)
			
			println("""Deine Karte ist $cardName und sie bedeutet:
				$cardMeaning""".trimIndent())
			listOf(cardName, cardMeaning)
		}
	}
}

// Persönlichkeitskarte
fun personalityCard(cardDeck : MutableMap<String, String>, greeting : String, birthDate: String) : List<String>
{
	println(greeting)
	// val birthDate : String = birthday()
	
	val number1 : Int = getIntFromString(birthDate, 0)
	val number2 : Int = getIntFromString(birthDate, 1)
	val number3 : Int = getIntFromString(birthDate, 3)
	val number4 : Int = getIntFromString(birthDate, 4)
	val number5 : Int = getIntFromString(birthDate, 6)
	val number6 : Int = getIntFromString(birthDate, 7)
	val number7 : Int = getIntFromString(birthDate, 8)
	val number8 : Int = getIntFromString(birthDate, 9)
	
	
	val calculation : Int = calAddEightNum(number1, number2, number3, number4, number5, number6, number7, number8)
	
	return finalCard(calculation, cardDeck)
}

// Seelenkarte
fun soulCard(cardDeck : MutableMap<String, String>, personalityCard : String) : List<String>
{
	println("Jetzt berechnen wir deine Seelenkarte!")
	val personalityCardNumber = personalityCard.filter { it.isDigit() }
	if (personalityCardNumber.length >= 2)
	{
		val number1 : Int = getIntFromString(personalityCard, 0)
		val number2 : Int = getIntFromString(personalityCard, 1)
		
		val cardNumber : String = (number1 + number2).toString()
		val cardDeckNames : MutableList<String> = cardDeck.keys.toMutableList()
		val cardName : String = cardDeckNames.find { it.startsWith(cardNumber) } ?: ""
		return if (cardName == "")
		{
			println("Deine Karte gibt es nicht")
			listOf("", "")
		}
		else
		{
			val cardMeaning : String = cardDeck.getValue(cardName)
			
			println("Deine Karte ist $cardName und sie bedeutet $cardMeaning")
			return listOf(cardName, cardMeaning)
		}
	}
	else
	{
		val cardMeaning : String = cardDeck.getValue(personalityCard)
		
		
		println("Deine Karte ist $personalityCard und sie bedeutet $cardMeaning")
		return listOf(personalityCard, cardMeaning)
	}
	
}

// Jahreskarte
fun yearCard(cardDeck : MutableMap<String, String>, greeting : String, birthDate : String) : List<String>
{
	println(greeting)
	
	val number1 : Int = getIntFromString(birthDate, 0)
	val number2 : Int = getIntFromString(birthDate, 1)
	val number3 : Int = getIntFromString(birthDate, 3)
	val number4 : Int = getIntFromString(birthDate, 4)
	
	val currentYear : String = Year.now().toString()
	val number5 : Int = getIntFromString(currentYear, 0)
	val number6 : Int = getIntFromString(currentYear, 1)
	val number7 : Int = getIntFromString(currentYear, 2)
	val number8 : Int = getIntFromString(currentYear, 3)
	
	val calculation : Int = calAddEightNum(number1, number2, number3, number4, number5, number6, number7, number8)
	
	return finalCard(calculation, cardDeck)
}

fun main()
{
	// Krüge
	val gobletCards : MutableMap<String, String> = mutableMapOf(
			"Bube der Kelche" to "oberflächliche Begeisterung, leichte Schwärmerei, unverfänglich",
			"Ritter der Kelche" to "romantisch, starke Gefühle, Intensität, Hingabe",
			"Königin der Kelche" to "wahres Verständnis, einfühlsam, wahrhaftig",
			"König der Kelche" to "erfahren, weise, gerecht, zugewandt",
			"Ass der Kelche" to "Liebe und Glück",
			"2 Kelche" to "neue Beziehung, Liebe zwischen zwei Menschen",
			"3 Kelche" to "gute Laune, Anlass zur Freude",
			"4 Kelche" to "eine ungenutzte Chance, eine gute Gelegenheit, die nicht genutzt wurde",
			"5 Kelche" to "traurige Wendung, Schmerz, Bedauern",
			"6 Kelche" to "kindliche Freude, Offenheit",
			"7 Kelche" to "Fantasie bis zur Illusion",
			"8 Kelche" to "Aufbruch zu neuen Ufern, Kehrtwende im Leben",
			"9 Kelche" to "Verschwendung von Geld oder Festklammern daran",
			"10 Kelche" to "Glück, Gemeinschaft, gutes Omen",
	                                                           )
	
	// Stäbe
	val barCards : MutableMap<String, String> = mutableMapOf(
			"Bube der Stäbe" to "Aufbruch, neue Chancen, Unbekanntes entdecken, Freude auf Neues, Kreativität und Offenheit, auch für eine neue Liebe",
			"Ritter der Stäbe" to "Temperament, Elan, beflügelt von Reibung, Genuss, den Moment leben",
			"Königin der Stäbe" to "souverän, entschieden, kämpferisch, loyal, stark, starker Charakter, bestimmte aber faire Unterstützerin",
			"König der Stäbe" to "elanvoll, dynamisch, selbstbewusst, stattlich, Führungsqualität, moralisch",
			"Ass der Stäbe" to "Erfolg auf ganzer Linie, Enthusiasmus, Freude am Tun",
			"2 Stäbe" to "Pläne schmieden, Grundlagen schaffen",
			"3 Stäbe" to "positiver Ausblick, gute Basis",
			"4 Stäbe" to "Freude, Feiern, geregelte und stabile Lebensumstände",
			"5 Stäbe" to "zwischenmenschliche Turbulenzen, Konkurrenz, Uneinigkeit",
			"6 Stäbe" to "Gewinnen, Triumph, Durchsetzungsvermögen",
			"7 Stäbe" to "massiver Gegenwind, starke Konflikte",
			"8 Stäbe" to "Vorbote einer positiven Veränderung",
			"9 Stäbe" to "Stärke und Vorsicht sind gefragt: schwierige Umstände können bevorstehen",
			"10 Stäbe" to "große Bürde, zu schwere Last, Hilfe/Entlastung nötig",
	                                                        )
	
	// Schwerter
	val swordCards : MutableMap<String, String> = mutableMapOf(
			"Bube der Schwerter" to "herausfordernd, provozierend, Kritik oder Konfrontation im Anmarsch, Ärger, aber eher substanzlos",
			"Ritter der Schwerter" to "ausdauernder Angreifer, Warnung vor Streit oder Kampf, Feindseligkeit und Unfrieden",
			"Königin der Schwerter" to "ist umsichtig, wägt ab, ist gerecht und bedacht, vereint Verstand und Intuition, ist zukunftsorientiert",
			"König der Schwerter" to "Strategie, überlegtes Handeln, Weitsicht, klarer Kopf, lässt sich nicht in die Karten gucken",
			"Ass der Schwerter" to "klarer Verstand, echtes Verstehen, Erkenntnis",
			"2 Schwerter" to "begrenztes Erkennen, Zweifel, Unklarheit",
			"3 Schwerter" to "ein Fehler wurde begangen, Bereuen, falsche Entscheidung",
			"4 Schwerter" to "Pause, Blockade, Rückzug",
			"5 Schwerter" to "böse Taktik, böse Absichten",
			"6 Schwerter" to "Ungewissheit, Unbekanntes, Schreck",
			"7 Schwerter" to "Hinterlist, Falle, Betrug, Feigheit",
			"8 Schwerter" to "zu starre Strukturen, mangelnder Mut, zu wenig Offenheit",
			"9 Schwerter" to "emotionale Belastungen, Probleme",
			"10 Schwerter" to "Schock, plötzliches Ende, Schließen eines Kapitels (auch unfreiwillig)",
	                                                          )
	
	// Münzen/Scheiben
	val coinCards : MutableMap<String, String> = mutableMapOf(
			"Bube der Münzen" to "freigiebig und unbekümmert in Bezug auf Geld, schwelgt gern in Schönem, ohne die Arbeit dahinter zu sehen",
			"Ritter der Münzen" to "zielstrebig, überlegt, ehrgeizig und konsequent, darf aber auch Lebensfreude und Leichtigkeit nicht vergessen",
			"Königin der Münzen" to "bodenständig und weiß, was sie tut, kann sich auch mal ausruhen und das Gleichgewicht achten",
			"König der Münzen" to "hat Vieles erreicht, ist lebenserprobt, hat Erfahrung, genießt das Leben, tut etwas dafür ud achtet das Leben",
			"Ass der Münzen" to "handfester Erfolg, Triumph, Reichtum, Geschenk",
			"2 Münzen" to "Anpassungsfähigkeit, das Leben flexibel bewältigen können",
			"3 Münzen" to "Prüfung, Meilenstein, etwas wird enthüllt, Chance zur Aufklärung",
			"4 Münzen" to "sich selbst isolieren, verharren auf Besitz/Errungenschaften, Andere wegstoßen",
			"5 Münzen" to "Hilfsbedürftigkeit, Verlust, Armut, Not, sich durchschlagen müssen, Durststrecke",
			"6 Münzen" to "Hilfsbereitschaft, Teilen, Großzügigkeit, Geben",
			"7 Münzen" to "stetige Entwicklung in die richtige Richtung, längerfristiger Ertrag",
			"8 Münzen" to "schrittweise voranschreiten und aufbauen, richtiger Weg",
			"9 Münzen" to "Gewinn, Chance, plötzliches Geschenk, positive Wendung und Gelegenheit",
			"10 Münzen" to "Lohn für Mühen, Fülle, aber auch Geheimnisse und Mysterien jenseits der materiellen Welt",
	                                                         )
	
	// kleines Arkana
	val littleArcana : MutableMap<String, String> = (gobletCards + barCards + swordCards + coinCards).toMutableMap()
	
	// großes Arkana
	val bigArcana : MutableMap<String, String> = mutableMapOf(
			"0 - Der Narr" to """Abgebildet ist meist ein junger Mann, der sorglos und beschwingt seines Weges geht.
				Diese Karte steht für Sorglosigkeit und einen unbekümmerten Menschen.
				Diese Tarotkarte kann in ihrer Bedeutung durchaus positiv sein im Sinne von Leichtigkeit.
				Je nachdem, welche weiteren Karten im Kartenbild mit ihr zusammenhängen, kann sie aber auch für Scheitern, Versagen und mangelnde Bemühung oder Ernsthaftigkeit stehen.""".trimMargin(),
			"1 - Der Magier" to """Der Magier ist eine sehr beliebte Karte, da er eine sehr spirituelle und mächtige Figur ist, die Erfolg und Umsetzung bedeutet.
				Diese Tarotkarte bedeutet Selbsterkenntnis, Wissen und Gestaltungskraft.
				Der Magier versteht die Prinzipien des Lebens und weiß, sie anzuwenden.
				Es ist eine Karte der Vervollkommnung, kann aber auch für eine Person stehen, die sich ihrer Kräfte und Fähigkeiten (zu) sehr bewusst ist und dadurch überheblich ist.""".trimMargin(),
			"2 - Die Hohepriesterin" to """Die Tarotkarte Hohepriesterin steht für die weibliche Kraft an sich, ist also eine kraftvolle weibliche Karte.
				Ihre Macht bezieht die Hohepriesterin durch ihre intuitiven Fähigkeiten und die Gabe, hinter oder durch den Schleier zu sehen (mit diesem ist sie meist abgebildet).
				Sie ist eine wissende Frau, die Entscheidungen treffen und Dinge durchschauen kann.""".trimMargin(),
			"3 - Die Herrscherin" to """Die Herrscherin ist eine sehr positive Tarotkarte der Fülle, der Reife und der Vollendung.
				Sie steht für Fruchtbarkeit und das Aus dem Vollen schöpfen. Außerdem hat diese Karte eine mütterliche Dimension, zusammen mit großer Stärke. Ebenso wie beim Magier kann die Bedeutung dieser Tarotkarte auch ins Negative gehen, indem sie einen Mensch bezeichnet, der seine Macht ausnutzt.
				Ebenso wie die Karten der Hohepriesterin ist dies eine Karte, die stark für das Thema Weiblichkeit steht – hier vor allem in Verbindung mit weltlichen Themen.""".trimMargin(),
			"4 - Der Herrscher" to """Die Tarotkarten-Bedeutung der fünften Karte dreht sich um Herrschaft, Macht, Kontrolle und Verantwortung.
				Es ist eine sehr sachliche und geradlinige Karte, die Leiten, Führen und Verantwortung bedeutet.
				Je nachdem, in welchem Zusammenhang sie mit den anderen Tarotkarten steht, kann sie auch eine Respektperson bedeuten.""".trimMargin(),
			"5 - Der Hierophant" to """Der Hierophant steht für den göttlichen Willen auf der Erde und damit für Sinn, Wahrheit und die Gesetze des Lebens.
				Gemeint sind damit eigene Überzeugungen und Werte, aber auch allgemeine Sinnfragen.
				Ob spirituell oder weltlich: Beide Bereiche deckt der Hierophant ab.
				Da aber niemand einer höheren Macht blindlings folgen muss, kann diese Tarotkarte auch eine Warnung sein, Vorbilder zu hinterfragen und Sinnfragen selbst zu beantworten.
				In Beziehungen kann diese Karte bedeuten, dass eine Person der anderen überlegen ist – oder sich über sie erhebt.""".trimMargin(),
			"6 - Die Liebenden" to """Hier ist die Tarotkarten-Bedeutung recht eindeutig, denn diese Karte dreht sich um die Liebe und die Verbindung zwischen Menschen.
				Es muss nicht immer eine erotische, romantische oder liebende Beziehung sein; auch harmonische Freundschaften, Partnerschaften oder anderweitige Verbindungen deckt diese Tarotkarte ab.
				Und nicht zuletzt: Auch Zugehörigkeit, Zuneigung und die Bedeutung des Herzens werden von dieser Karte repräsentiert.""".trimMargin(),
			"7 - Der Wagen" to """Diese Tarotkarte ist nichts Geringeres als der einfahrende Triumphwagen – jedoch verrät nur der Zusammenhang beim Kartenlegen, was genau er bedeutet.
				Ist der Wagen bereits auf der Zielgeraden, nähert er sich gerade an oder geht die Reise erst los?
				Dann gilt es auch, auf die richtige Richtung zu achten.
				Aber so oder so: Diese Tarotkarte steht für Bewegung, Entwicklung und Chancen.""".trimMargin(),
			"8 - Die Gerechtigkeit" to """Diese Tarotkarte steht für Gerechtigkeit, Ausgleich und Wahrheit – und damit auch für Ehrlichkeit.
				An der Wahrheit ist kein Vorbeikommen.
				Diese Karte kann also Hoffnung machen oder auch eine Warnung sein, denn für mangelnde Gerechtigkeit ist ein Ausgleich nötig, der auch eine Strafe sein kann.""".trimMargin(),
			"9 - Der Eremit" to """Der Eremit ist ein Mensch, der sich von der Welt zurückzieht und sich auf eine innere Reise begibt.
				Auf andere Menschen kann er unnahbar und auch unfreundlich wirken, wenn sein Rückzug eine Folge emotionaler Verletzungen oder Enttäuschungen ist.
				Doch auch Wahrheitssuche, Weiterentwicklung und inneres Wachstum können sein Antrieb sein.
				Diese Karte verkörpert innere Einkehr, eine starke Persönlichkeit und geistige Erkenntnisse und steht dafür, den eigenen Weg zu gehen.""".trimMargin(),
			"10 - Das Rad des Schicksals" to """Das „Rad des Schicksals“ ist die Schicksalskarte im Tarot.
				Beim Deuten des Kartenbildes sollte ihr besondere Aufmerksamkeit geschenkt werden.
				Diese Karte steht für den ewigen Kreislauf des Lebens und auch karmische Muster.
				Beim Kartenlegen deutet sie auf ein Thema oder eine Situation mit zentraler Bedeutung hin.
				Was bei dieser Karte nicht vergessen werden darf:
				Auch Karma ist änderbar, denn man kann und muss immer selbst die Steuer setzen.""".trimMargin(),
			"11 - Die Kraft" to """Diese positive Tarotkarte bezeichnet Mut, persönliche Stärke und auch die Aussicht auf Erfolg, wenn man für etwas kämpft.
				Sie kann ein guter Hinweis sein, wo es sich lohnt, Energie aufzuwenden oder Vertrauen zu haben.
				Diese Tarotkarte steht von sich aus nicht für eine aggressive Kraft, sondern für innere Stärke und Mut.""".trimMargin(),
			"12 - Der Gehängte" to """Diese Karte löst oft Erschrecken aus, weil eine stark negative Bedeutung angenommen wird.
				Der Gehängte kann zwar mit Strafe und Qual in Verbindung gebracht werden, damit können aber auch eine Transformation und ein Wandel gemeint sein.
				Einen Einschnitt bedeutet diese Tarotkarte allemal, jedoch kann dies auch ein Vorteil sein.
				Geduld, innere Ruhe und Akzeptanz sind gute Ratgeber, um Krisen zu überstehen und als neuer Mensch aus ihnen hervor zu gehen.""".trimMargin(),
			"13 - Der Tod" to """Auch diese Tarotkarte kann Erschrecken und Traurigkeit auslösen, denn sie bedeutet das Ende von etwas.
				Gemeint ist damit jedoch mitnichten der physische Tod einer Person, sondern in erster Linie eine Ablösung, ein Loslassen, ein Ende oder einen Stopp.
				Jedes Ende bringt den Start von etwas Neuem mit sich, daher ist diese Tarotkarte keineswegs negativ.
				Veränderung kann auf allen Ebenen stattfinden – die umliegenden Karten geben Aufschluss darüber, worauf sich dieser Wandel bezieht.""".trimMargin(),
			"14 - Die Mäßigkeit" to """Die Tarotkarten-Bedeutung der „Mäßigkeit“ liegt in ihrer Funktion als sanfte Ratgeberin:
				Lasse es langsam angehen, habe einen wachen Geist und achte auf die angemessenen Verhältnisse.
				Weniger ist manchmal mehr, und das Abwägen beider Seiten kann zu einer klugen Entscheidung verhelfen.
				Diese Karte entschleunigt und lässt einen Schritt zurücktreten.""".trimMargin(),
			"15 - Der Teufel" to """Diese Karte ist eine hilfreiche Warnung, denn sie deutet auf Blockaden, Hindernisse oder Schwierigkeiten hin.
				Auch ein Mensch, dem man nicht trauen kann, kann gemeint sein. Diese Tarotkarte weist darauf hin, vorsichtig zu sein – auch in Bezug auf das eigene Verhalten.
				Es gibt kein Licht ohne Schatten, und so ist es auch im Leben.""".trimMargin(),
			"16 - Der Turm" to """Der Turm ist auch von den Lenormandkarten bekannt.
				Er ist ebenfalls eine warnende Karte, denn er kann Zerstörung, Fall und Katastrophe bedeuten.
				Die Karte kann aber auch etwas harmloser darauf hinweisen, dass ein Rückzug stattgefunden hat oder eine Art (innere) „Gefangenschaft“ vorliegt.
				So oder so: Es ist eine Karte, die Einschnitte anzeigt und dazu anregt, über den Ausweg nachzudenken, um neu und gestärkt weiter zu machen.""".trimMargin(),
			"17 - Der Stern" to """Diese Tarotkarte hat eine sehr schöne Bedeutung, denn sie steht für Erfüllung, Schönheit und Glück.
				Eine absolute Glückskarte also, die gutes Gelingen und Segen anzeigt.
				Ein Stern der Hoffnung, ein Stern, der leitet: Mit dieser Tarotkarte steht ein gutes Omen an Ihrer Seite.
				Auch diese Karte sowie die folgenden kommen in den Lenormandkarten vor.""".trimMargin(),
			"18 - Der Mond" to """Der Mond steht für das Unbewusste, die innere Einkehr, die Intuition und den engen Kontakt zum eigenen Bewusstsein.
				In der Nacht, wenn alles zur Ruhe kommt, liegt das Wesentliche offen und wird von seinem Licht beschienen.
				Eine Tarotkarte, die den Kontakt zur eigenen Seele anspricht und darum bittet, sich mit den eignen Gedanken, Gefühlen und seelischen Prozessen zu befassen.
				Eine Karte der Ruhe und Hingabe, die dazu ermuntert, sich auch schwierigen Themen zu stellen, die ein Teil vom Ganzen sind.""".trimMargin(),
			"19 - Die Sonne" to """Eine positiv, starke Karte, die Glück und gutes Gelingen bedeutet.
				Die Sonne ist die Licht- und Wärmespenderin und der Inbegriff von Lebenskraft.
				Eine Karte voll Energie, Schaffenskraft und Vervollkommnung.
				Ein Hinweis auf ein gutes Gelingen und Licht – im Inneren wie im Äußeren.""".trimMargin(),
			"20 - Das Gericht" to """Die Tarotkarten-Bedeutung des „Gerichts“ weist darauf hin, die Dinge (oder sich selbst) genau zu prüfen.
				Was ist richtig, was ist zu tun? Gleichzeitig kann die Karte darauf hinweisen, dass eine Angelegenheit zum Abschluss kommt.
				Sie steht daher auch sehr stark für Abschluss und klare Schnitte.
				Ehrlichkeit, Verstand und Sachlichkeit sind da oft die besten Ratgeber, um etwas klar zu Ende zu bringen und dann neu beginnen zu können.""".trimMargin(),
			"21 - Die Welt" to """Diese Tarotkarte bedeutet Vollendung, Erfolg und alles, was Bestand hat.
				Sie steht für Handfestes, Verwirklichtes und Angekommensein.
				Die Tarotkarte der Welt steht auch für Erwachsensein, Reife und den Blick für das große Ganze.
				Daher kann diese Karte auch ein Hinweis sein, mit etwas Distanz auf Probleme zu schauen, um das Wesentliche zu erkennen.""".trimMargin(),
	                                                         )
	
	// komplettes Tarot
	val bothArcana : MutableMap<String, String> = (littleArcana + bigArcana).toMutableMap()
	
	shuffleCards(bothArcana)
	
	println("""Um deine Tarotkarten zu berechnen benötigen wir dein Geburtsdatum.
	Tippe es wie folgt ein und bestätige es anschließend mit der Eingabetaste: TT.MM.JJJJ.""".trimIndent())
	
	val birthDate : String = birthday()
	
	val greetingPersonalityCard = """
		Jetzt ermitteln wir deine Persönlichkeitskarte.""".trimIndent()
	
	val greetingYearCard = """
		Jetzt ermitteln wir deine Jahreskarte für ${Year.now()}.""".trimIndent()
	
	val personalityCard = personalityCard(bigArcana, greetingPersonalityCard, birthDate)

	Thread.sleep(1500)
	
	soulCard(bigArcana, personalityCard[0])
	
	Thread.sleep(1500)
	
	yearCard(bigArcana, greetingYearCard, birthDate)
	
}
