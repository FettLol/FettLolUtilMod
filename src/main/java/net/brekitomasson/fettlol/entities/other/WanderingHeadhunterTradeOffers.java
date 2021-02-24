package net.brekitomasson.fettlol.entities.other;

import com.google.common.collect.ImmutableMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.brekitomasson.fettlol.util.HeadHelper;
import net.minecraft.village.TradeOffers;

import java.util.UUID;

public class WanderingHeadhunterTradeOffers {
    public static final Int2ObjectMap<TradeOffers.Factory[]> WANDERING_HEADHUNTER_TRADES;

    private static Int2ObjectMap<TradeOffers.Factory[]> copyToFastUtilMap(ImmutableMap<Integer, TradeOffers.Factory[]> map) {
        return new Int2ObjectOpenHashMap<>(map);
    }

    static {
        WANDERING_HEADHUNTER_TRADES = copyToFastUtilMap(ImmutableMap.of(1, new TradeOffers.Factory[]{
            HeadHelper.playerHeadForSale("Astronaut", "ZiO"),
            HeadHelper.playerHeadForSale("Batman", "HDMinecraft"),
            HeadHelper.playerHeadForSale("BdoubleO100"),
            HeadHelper.playerHeadForSale("BrekiT"),
            HeadHelper.playerHeadForSale("Captain America", "KawaiSenpai"),
            HeadHelper.playerHeadForSale("Chipmunk", "hiiamcoco"),
            HeadHelper.playerHeadForSale("Darth Vader", "Darth_Vader_One"),
            HeadHelper.playerHeadForSale("Deadpool", UUID.fromString("dda66c42-fd6f-4eab-b604-8357091a582a")),
            HeadHelper.playerHeadForSale("Docm77"),
            HeadHelper.playerHeadForSale("Doge", UUID.fromString("c5a68449-6e6a-4c16-8ab4-032208d2ff44")),
            HeadHelper.playerHeadForSale("Donald Duck", "po_ro"),
            HeadHelper.playerHeadForSale("Ducky", "Hacking"),
            HeadHelper.playerHeadForSale("Elffairy"),
            HeadHelper.playerHeadForSale("Etho"),
            HeadHelper.playerHeadForSale("Fourmisain"),
            HeadHelper.playerHeadForSale("Freddy", "Freddy_Fazbear"),
            HeadHelper.playerHeadForSale("Gamer Zombie", "zombiemark"),
            HeadHelper.playerHeadForSale("Ghost", "FireGhest"),
            HeadHelper.playerHeadForSale("Goku", "imMysttic"),
            HeadHelper.playerHeadForSale("Goofy", "Goofy__"),
            HeadHelper.playerHeadForSale("Grian"),
            HeadHelper.playerHeadForSale("GuardianMona"),
            HeadHelper.playerHeadForSale("Herobrine", "JonH"),
            HeadHelper.playerHeadForSale("Homer Simpson", "Homer"),
            HeadHelper.playerHeadForSale("JabbaTheHutt", "JabbaTheHutt"),
            HeadHelper.playerHeadForSale("Joker", "Clown"),
            HeadHelper.playerHeadForSale("Keralis1"),
            HeadHelper.playerHeadForSale("King Slime", "Grifyon"),
            HeadHelper.playerHeadForSale("Kylo Ren", "KnightOfRen"),
            HeadHelper.playerHeadForSale("Link", "ebiddytwister"),
            HeadHelper.playerHeadForSale("Luigi", "Sarixs"),
            HeadHelper.playerHeadForSale("Magikarp", "Fischiiihappen"),
            HeadHelper.playerHeadForSale("Mario", "dammpower"),
            HeadHelper.playerHeadForSale("MegaMan", "MegaMan"),
            HeadHelper.playerHeadForSale("Mewtwo", "Mewtwo"),
            HeadHelper.playerHeadForSale("Michaelangelo", "Turtastic"),
            HeadHelper.playerHeadForSale("Mumbo Jumbo", "Mumbo"),
            HeadHelper.playerHeadForSale("Octopus", "MosTik"),
            HeadHelper.playerHeadForSale("Penguin King", "ThePengKing05"),
            HeadHelper.playerHeadForSale("Penguin", "Ruan"),
            HeadHelper.playerHeadForSale("Pig", "StupidDroid"),
            HeadHelper.playerHeadForSale("Pikachu", "Pikachubutler"),
            HeadHelper.playerHeadForSale("Pink Panther", "dfgsteam"),
            HeadHelper.playerHeadForSale("Polar Bear", "RJ21"),
            HeadHelper.playerHeadForSale("Rendog", "Renthedog"),
            HeadHelper.playerHeadForSale("Robocop", "Granger"),
            HeadHelper.playerHeadForSale("Ronald McDonald", "RonaldMcDonald"),
            HeadHelper.playerHeadForSale("Scar", "GoodTimeWithScar"),
            HeadHelper.playerHeadForSale("Slowpoke", "Slowestpoke"),
            HeadHelper.playerHeadForSale("Spiderman", "CaptPhasma"),
            HeadHelper.playerHeadForSale("Spongebob", "DeckBoxChooser"),
            HeadHelper.playerHeadForSale("Stressmonster", "Stressmonster101"),
            HeadHelper.playerHeadForSale("Sub-Zero", "ReversedUniverse"),
            HeadHelper.playerHeadForSale("Tango"),
            HeadHelper.playerHeadForSale("Vaporeon", "Vaporeon"),
            HeadHelper.playerHeadForSale("VintageBeef"),
            HeadHelper.playerHeadForSale("Welsknight"),
            HeadHelper.playerHeadForSale("Xisuma"),
            HeadHelper.playerHeadForSale("Yoshi", "Yoshi"),
            HeadHelper.playerHeadForSale("Zedaph"),
            HeadHelper.playerHeadForSale("Zeus", "jeb_"),
            HeadHelper.playerHeadForSale("cubfan135"),
            HeadHelper.playerHeadForSale("falsesymmetry"),
            HeadHelper.playerHeadForSale("impulseSV"),
            HeadHelper.playerHeadForSale("iskall85"),
            HeadHelper.playerHeadForSale("xBCrafted"),
        }));
    }

}