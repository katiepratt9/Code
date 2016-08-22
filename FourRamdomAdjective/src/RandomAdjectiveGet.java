import java.util.ArrayList;

public class RandomAdjectiveGet
{
	public static void main(String[] args)
	{
		PrintRandom();
		PrintRandom();
		PrintRandom();
		PrintRandom();
	}

	public static void PrintRandom()
	{
		ArrayList<String> adj = new ArrayList<String>();
		{
			adj.add("Adamant: unyielding; a very hard substance");
			adj.add("Adroit: clever, resourceful");
			adj.add("Antic: clownish, frolicsome");
					adj.add("Arcadian: serene");
					adj.add("Baleful: deadly, foreboding");
					adj.add("Bellicose: quarrelsome (its synonym belligerent can also be a noun)
			Bilious: unpleasant, peevish
			Boorish: crude, insensitive
			Calamitous: disastrous
			Caustic: corrosive, sarcastic; a corrosive substance
			Cerulean: sky blue
			Comely: attractive
			Concomitant: accompanying
			Contumacious: rebellious
			Corpulent: obese
			Crapulous: immoderate in appetite
			Defamatory: maliciously misrepresenting
			Didactic: conveying information or moral instruction
			Dilatory: causing delay, tardy
			Dowdy: shabby, old-fashioned; an unkempt woman
			Efficacious: producing a desired effect
			Effulgent: brilliantly radiant
			Egregious: conspicuous, flagrant
			Endemic: prevalent, native, peculiar to an area
			Equanimous: even, balanced
			Execrable: wretched, detestable
			Fastidious: meticulous, overly delicate
			Feckless: weak, irresponsible
			Fecund: prolific, inventive
			Friable: brittle
			Fulsome: abundant, overdone, effusive
			Garrulous: wordy, talkative
			Guileless: naive
			Gustatory: having to do with taste or eating
			Heuristic: learning through trial-and-error or problem solving
			Histrionic: affected, theatrical
			Hubristic: proud, excessively self-confident
			Incendiary: inflammatory, spontaneously combustible, hot
			Insidious: subtle, seductive, treacherous
			Insolent: impudent, contemptuous
			Intransigent: uncompromising
			Inveterate: habitual, persistent
			Invidious: resentful, envious, obnoxious
			Irksome: annoying
			Jejune: dull, puerile
			Jocular: jesting, playful
			Judicious: discreet
			Lachrymose: tearful
			Limpid: simple, transparent, serene
			Loquacious: talkative
			Luminous: clear, shining
			Mannered: artificial, stilted
			Mendacious: deceptive
			Meretricious: whorish, superficially appealing, pretentious
			Minatory: menacing
			Mordant: biting, incisive, pungent
			Munificent: lavish, generous
			Nefarious: wicked
			Noxious: harmful, corrupting
			Obtuse: blunt, stupid
			Parsimonious: frugal, restrained
			Pendulous: suspended, indecisive
			Pernicious: injurious, deadly
			Pervasive: widespread
			Petulant: rude, ill humored
			Platitudinous: resembling or full of dull or banal comments
			Precipitate: steep, speedy
			Propitious: auspicious, advantageous, benevolent
			Puckish: impish
			Querulous: cranky, whining
			Quiescent: inactive, untroublesome
			Rebarbative: irritating, repellent
			Recalcitrant: resistant, obstinate
			Redolent: aromatic, evocative
			Rhadamanthine: harshly strict
			Risible: laughable
			Ruminative: contemplative
			Sagacious: wise, discerning
			Salubrious: healthful
			Sartorial: relating to attire, especially tailored fashions
			Sclerotic: hardening
			Serpentine: snake-like, winding, tempting or wily
			Spasmodic: having to do with or resembling a spasm, excitable, intermittent
			Strident: harsh, discordant; obtrusively loud
			Taciturn: closemouthed, reticent
			Tenacious: persistent, cohesive,
			Tremulous: nervous, trembling, timid, sensitive
			Trenchant: sharp, penetrating, distinct
			Turbulent: restless, tempestuous
			Turgid: swollen, pompous
			Ubiquitous: pervasive, widespread
			Uxorious: inordinately affectionate or compliant with a wife
			Verdant: green, unripe
			Voluble: glib, given to speaking
			Voracious: ravenous, insatiable
			Wheedling: flattering
			Withering: devastating
			Zealous: eager, devoted
			adj.add("funny: ");
			adj.add("foggy: ");
			adj.add("fruitful: ");
			adj.add("florescent: ");
		}
		int num= (int )(Math. random() * 3);
		System.out.println(adj.get(num));
	}
}
