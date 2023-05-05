package arcanas

import cards.*

class MinorArcana
{
	var minorArcana : List<Card> = BarCards().barCards + CoinCards().coinCards + GobletCards().gobletCards + SwordCards().swordCards
}
