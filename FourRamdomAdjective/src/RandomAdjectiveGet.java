import java.util.ArrayList;

public class RandomAdjectiveGet
{
	public static void main(String[] args)
	{
		for(int i =0;i<100;i++)
		{
			PrintRandom();
			PrintRandom();
			PrintRandom();
			PrintRandom();
			System.out.println();
		}
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
			adj.add("Bellicose: quarrelsome");
			adj.add("Bilious: unpleasant, peevish");
			adj.add("Boorish: crude, insensitive");
			adj.add("Calamitous: disastrous");
			adj.add("Caustic: corrosive, sarcastic");
			adj.add("Cerulean: sky blue");
			adj.add("Comely: attractive");
			adj.add("Concomitant: accompanying");
			adj.add("Contumacious: rebellious");
			adj.add("Corpulent: obese");
			adj.add("Crapulous: immoderate in appetite");
			adj.add("Defamatory: maliciously misrepresenting");
			adj.add("Didactic: conveying information or moral instruction");
			adj.add("Dilatory: causing delay, tardy");
			adj.add("Dowdy: shabby, old-fashioned; an unkempt woman");
			adj.add("Efficacious: producing a desired effect");
			adj.add("Effulgent: brilliantly radiant");
			adj.add("Egregious: conspicuous, flagrant");
			adj.add("Endemic: prevalent, native, peculiar to an area");
			adj.add("Equanimous: even, balanced");
			adj.add("Execrable: wretched, detestable");
			adj.add("Fastidious: meticulous, overly delicate");
			adj.add("Feckless: weak, irresponsible");
			adj.add("Fecund: prolific, inventive");
			adj.add("Friable: brittle");
			adj.add("Fulsome: abundant, overdone, effusive");
			adj.add("Garrulous: wordy, talkative");
			adj.add("Guileless: naive");
			adj.add("Gustatory: having to do with taste or eating");
			adj.add("Heuristic: learning through trial-and-error or problem solving");
			adj.add("Histrionic: affected, theatrical");
			adj.add("Hubristic: proud, excessively self-confident");
			adj.add("Incendiary: inflammatory, spontaneously combustible, hot");
			adj.add("Insidious: subtle, seductive, treacherous");
			adj.add("Insolent: impudent, contemptuous");
			adj.add("Intransigent: uncompromising");
			adj.add("Inveterate: habitual, persistent");
			adj.add("Invidious: resentful, envious, obnoxious");
			adj.add("Irksome: annoying");
			adj.add("Jejune: dull, puerile");
			adj.add("Jocular: jesting, playful");
			adj.add("Judicious: discreet");
			adj.add("Lachrymose: tearful");
			adj.add("Limpid: simple, transparent, serene");
			adj.add("Loquacious: talkative");
			adj.add("Luminous: clear, shining");
			adj.add("Mannered: artificial, stilted");
			adj.add("Mendacious: deceptive");
			adj.add("Meretricious: whorish, superficially appealing, pretentious");
			adj.add("Minatory: menacing");
			adj.add("Mordant: biting, incisive, pungent");
			adj.add("Munificent: lavish, generous");
			adj.add("Nefarious: wicked");
			adj.add("Noxious: harmful, corrupting");
			adj.add("Obtuse: blunt, stupid");
			adj.add("Parsimonious: frugal, restrained");
			adj.add("Pendulous: suspended, indecisive");
			adj.add("Pernicious: injurious, deadly");
			adj.add("Pervasive: widespread");
			adj.add("Petulant: rude, ill humored");
			adj.add("Platitudinous: resembling or full of dull or banal comments");
			adj.add("Precipitate: steep, speedy");
			adj.add("Propitious: auspicious, advantageous, benevolent");
			adj.add("Puckish: impish");
			adj.add("Querulous: cranky, whining");
			adj.add("Quiescent: inactive, untroublesome");
			adj.add("Rebarbative: irritating, repellent");
			adj.add("Recalcitrant: resistant, obstinate");
			adj.add("Redolent: aromatic, evocative");
			adj.add("Rhadamanthine: harshly strict");
			adj.add("Risible: laughable");
			adj.add("Ruminative: contemplative");
			adj.add("Sagacious: wise, discerning");
			adj.add("Salubrious: healthful");
			adj.add("Sartorial: relating to attire, especially tailored fashions");
			adj.add("Sclerotic: hardening");
			adj.add("Serpentine: snake-like, winding, tempting or wily");
			adj.add("Spasmodic: having to do with or resembling a spasm, excitable, intermittent");
			adj.add("Strident: harsh, discordant; obtrusively loud");
			adj.add("Taciturn: closemouthed, reticent");
			adj.add("Tenacious: persistent, cohesive,");
			adj.add("Tremulous: nervous, trembling, timid, sensitive");
			adj.add("Trenchant: sharp, penetrating, distinct");
			adj.add("Turbulent: restless, tempestuous");
			adj.add("Turgid: swollen, pompous");
			adj.add("Ubiquitous: pervasive, widespread");
			adj.add("Uxorious: inordinately affectionate or compliant with a wife");
			adj.add("Verdant: green, unripe");
			adj.add("Voluble: glib, given to speaking");
			adj.add("Voracious: ravenous, insatiable");
			adj.add("Wheedling: flattering");
			adj.add("Withering: devastating");
			adj.add("Zealous: eager, devoted");

		}
		int num= (int )(Math. random() * 98);
		System.out.println(adj.get(num));
	}
}
