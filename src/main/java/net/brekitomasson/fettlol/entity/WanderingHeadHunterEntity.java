package net.brekitomasson.fettlol.entity;

import com.google.common.collect.ImmutableMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.brekitomasson.fettlol.init.Entities;
import net.brekitomasson.fettlol.util.HeadHelper;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.MobNavigation;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOfferList;
import net.minecraft.village.TradeOffers;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class WanderingHeadHunterEntity extends MerchantEntity {

    public AttributeContainer attributeContainer;

    public WanderingHeadHunterEntity(World world) {
        super(Entities.WANDERING_HEAD_HUNTER, world);

        ((MobNavigation) this.getNavigation()).setCanPathThroughDoors(false);
        this.getNavigation().setCanSwim(true);
    }

    @Override
    public boolean canSpawn(WorldView world) {
        return super.canSpawn(world);
    }

    @Override
    public boolean canSpawn(WorldAccess world, SpawnReason spawnReason) {
        // We don't want to summon in caves etc. Ideally this would check for sky access.
        if (getY() <= 50) {
            return false;
        }

        return world.getEntitiesByClass(
            WanderingHeadHunterEntity.class,
            new Box(new BlockPos(getX(), getY(), getZ())).expand(20), (e) -> true
        ).isEmpty() && super.canSpawn(world, spawnReason);
    }

    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new StopFollowingCustomerGoal(this));
        this.goalSelector.add(2, new FleeEntityGoal(this, ZombieEntity.class, 8.0F, 0.5D, 0.5D));
        this.goalSelector.add(2, new FleeEntityGoal(this, EvokerEntity.class, 8.0F, 0.5D, 0.5D));
        this.goalSelector.add(2, new FleeEntityGoal(this, VindicatorEntity.class, 8.0F, 0.5D, 0.5D));
        this.goalSelector.add(2, new FleeEntityGoal(this, VexEntity.class, 8.0F, 0.5D, 0.5D));
        this.goalSelector.add(2, new FleeEntityGoal(this, PillagerEntity.class, 15.0F, 0.5D, 0.5D));
        this.goalSelector.add(2, new FleeEntityGoal(this, IllusionerEntity.class, 13.0F, 0.5D, 0.5D));
        this.goalSelector.add(2, new FleeEntityGoal(this, CreeperEntity.class, 10.0F, 0.5D, 0.5D));
        this.goalSelector.add(2, new EscapeDangerGoal(this, 0.55D));
        this.goalSelector.add(2, new LookAtCustomerGoal(this));
        this.goalSelector.add(3, new WanderAroundGoal(this, 0.4D));
        this.goalSelector.add(4, new WanderNearTargetGoal(this, 0.4F, 5.0F));
        this.goalSelector.add(5, new LookAtEntityGoal(this, MobEntity.class, 5.0F));
    }

    @Override
    public AttributeContainer getAttributes() {
        if (attributeContainer == null) {
            attributeContainer = new AttributeContainer(MobEntity.createMobAttributes().build());
        }

        return attributeContainer;
    }

    @Override
    protected void afterUsing(TradeOffer offer) {
        if (offer.shouldRewardPlayerExperience()) {
            int i = 3 + this.random.nextInt(4);
            this.world.spawnEntity(new ExperienceOrbEntity(this.world, this.getX(), this.getY() + 0.5D, this.getZ(), i));
        }
    }

    protected SoundEvent getTradingSound(boolean sold) {
        return sold ? SoundEvents.ENTITY_WANDERING_TRADER_YES : SoundEvents.ENTITY_WANDERING_TRADER_NO;
    }

    protected SoundEvent getAmbientSound() {
        return this.hasCustomer() ? SoundEvents.ENTITY_WANDERING_TRADER_TRADE : SoundEvents.ENTITY_WANDERING_TRADER_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.ENTITY_OCELOT_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_OCELOT_DEATH;
    }

    protected void fillRecipes() {
        TradeOffers.Factory[] tradesCommon = TRADES.get(1);
        TradeOffers.Factory[] tradesRare = TRADES.get(2);
        if (tradesCommon != null && tradesRare != null) {
            TradeOfferList traderOfferList = this.getOffers();
            this.fillRecipesFromPool(traderOfferList, tradesCommon, 5);
            int i = this.random.nextInt(tradesRare.length);
            TradeOffers.Factory factory = tradesRare[i];
            TradeOffer tradeOffer = factory.create(this, this.random);
            if (tradeOffer != null) {
                traderOfferList.add(tradeOffer);
            }
        }
    }

    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        if (this.isAlive() && !this.hasCustomer() && !this.isBaby()) {
            player.incrementStat(Stats.TALKED_TO_VILLAGER);

            if (!this.getOffers().isEmpty() && !this.world.isClient) {
                this.setCurrentCustomer(player);
                this.sendOffers(player, this.getDisplayName(), 1);
            }
            return ActionResult.success(this.world.isClient);
        } else {
            return super.interactMob(player, hand);
        }
    }

    @Override
    public int getLimitPerChunk() {
        return 1;
    }

    @Override
    public boolean isLeveledMerchant() {
        return false;
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    public static final Int2ObjectMap<TradeOffers.Factory[]> TRADES =
        new Int2ObjectOpenHashMap(
            ImmutableMap.of(1, new TradeOffers.Factory[]{
                    HeadHelper.playerHeadForSale("Astronaut", "ZiO"),
                    HeadHelper.playerHeadForSale("Batman", "HDMinecraft"),
                    HeadHelper.playerHeadForSale("Boba Fett", "Taco"),
                    HeadHelper.playerHeadForSale("Captain America", "KawaiSenpai"),
                    HeadHelper.playerHeadForSale("Chipmunk", "hiiamcoco"),
                    HeadHelper.playerHeadForSale("Cthulhu", "ELF_PUNSHER"),
                    HeadHelper.playerHeadForSale("Darth Vader", "Darth_Vader_One"),
                    HeadHelper.playerHeadForSale("Deadpool", "michael5671"),
                    HeadHelper.playerHeadForSale("Doge", "Doggy"),
                    HeadHelper.playerHeadForSale("Donald Duck", "jimskott"),
                    HeadHelper.playerHeadForSale("Donald Duck", "po_ro"),
                    HeadHelper.playerHeadForSale("Ducky", "Hacking"),
                    HeadHelper.playerHeadForSale("Freddy", "Freddy_Fazbear"),
                    HeadHelper.playerHeadForSale("Gamer Zombie", "zombiemark"),
                    HeadHelper.playerHeadForSale("Ghost", "FireGhest"),
                    HeadHelper.playerHeadForSale("Goku", "imMysttic"),
                    HeadHelper.playerHeadForSale("Goofy", "Goofy__"),
                    HeadHelper.playerHeadForSale("Herobrine", "JonH"),
                    HeadHelper.playerHeadForSale("Homer Simpson", "Homer"),
                    HeadHelper.playerHeadForSale("JabbaTheHutt", "JabbaTheHutt"),
                    HeadHelper.playerHeadForSale("Joker", "Clown"),
                    HeadHelper.playerHeadForSale("King Slime", "Grifyon"),
                    HeadHelper.playerHeadForSale("Kylo Ren", "KnightOfRen"),
                    HeadHelper.playerHeadForSale("Link", "ebiddytwister"),
                    HeadHelper.playerHeadForSale("Luigi", "Sarixs"),
                    HeadHelper.playerHeadForSale("Magikarp", "Fischiiihappen"),
                    HeadHelper.playerHeadForSale("Mario", "dammpower"),
                    HeadHelper.playerHeadForSale("MegaMan", "MegaMan"),
                    HeadHelper.playerHeadForSale("Mewtwo", "Mewtwo"),
                    HeadHelper.playerHeadForSale("Michaelangelo", "Turtastic"),
                    HeadHelper.playerHeadForSale("Octopus", "MosTik"),
                    HeadHelper.playerHeadForSale("Penguin King", "ThePengKing05"),
                    HeadHelper.playerHeadForSale("Penguin", "Ruan"),
                    HeadHelper.playerHeadForSale("Pig", "StupidDroid"),
                    HeadHelper.playerHeadForSale("Pikachu", "Pikachubutler"),
                    HeadHelper.playerHeadForSale("Pink Panther", "dfgsteam"),
                    HeadHelper.playerHeadForSale("Polar Bear", "RJ21"),
                    HeadHelper.playerHeadForSale("Robocop", "Granger"),
                    HeadHelper.playerHeadForSale("Ronald McDonald", "RonaldMcDonald"),
                    HeadHelper.playerHeadForSale("Slowpoke", "Slowestpoke"),
                    HeadHelper.playerHeadForSale("Spiderman", "CaptPhasma"),
                    HeadHelper.playerHeadForSale("Spongebob", "DeckBoxChooser"),
                    HeadHelper.playerHeadForSale("Sub-Zero", "ReversedUniverse"),
                    HeadHelper.playerHeadForSale("Vaporeon", "Vaporeon"),
                    HeadHelper.playerHeadForSale("Yoshi", "Yoshi"),
                    HeadHelper.playerHeadForSale("Zeus", "jeb_"),
                },
                2, new TradeOffers.Factory[]{
                    HeadHelper.playerHeadForSale("Elffairy"),
                    HeadHelper.playerHeadForSale("BrekiT"),
                    HeadHelper.playerHeadForSale("GuardianMona"),
                    HeadHelper.playerHeadForSale("Xisuma"),
                    HeadHelper.playerHeadForSale("Docm77"),
                    HeadHelper.playerHeadForSale("xBCrafted"),
                    HeadHelper.playerHeadForSale("Etho"),
                    HeadHelper.playerHeadForSale("Mumbo Jumbo", "Mumbo"),
                    HeadHelper.playerHeadForSale("impulseSV"),
                    HeadHelper.playerHeadForSale("Rendog", "Renthedog"),
                    HeadHelper.playerHeadForSale("Stressmonster", "Stressmonster101"),
                    HeadHelper.playerHeadForSale("Scar", "GoodTimeWithScar"),
                    HeadHelper.playerHeadForSale("Zedaph"),
                    HeadHelper.playerHeadForSale("cubfan135"),
                    HeadHelper.playerHeadForSale("Welsknight"),
                    HeadHelper.playerHeadForSale("Keralis"),
                    HeadHelper.playerHeadForSale("falsesymmetry"),
                    HeadHelper.playerHeadForSale("VintageBeef"),
                    HeadHelper.playerHeadForSale("BdoubleO100"),
                    HeadHelper.playerHeadForSale("Tango"),
                    HeadHelper.playerHeadForSale("Grian"),
                    HeadHelper.playerHeadForSale("iskall85"),
                    HeadHelper.playerHeadForSale("Fourmisain"),
                }));

}
