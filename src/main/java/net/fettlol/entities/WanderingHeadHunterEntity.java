package net.fettlol.entities;

import net.fettlol.entities.other.WanderingHeadhunterTradeOffers;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.WanderingTraderEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOfferList;
import net.minecraft.village.TradeOffers;
import net.minecraft.world.World;

public class WanderingHeadHunterEntity extends WanderingTraderEntity {

    public WanderingHeadHunterEntity(EntityType<? extends WanderingTraderEntity> entityType, World world) {
        super(entityType, world);
        // doesn't seem to exist in v1.17...
        // this.teleporting = true;
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_PANDA_AMBIENT;
    }

    protected SoundEvent getTradingSound(boolean sold) {
        return SoundEvents.ENTITY_PANDA_SNEEZE;
    }

    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.ENTITY_OCELOT_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_OCELOT_DEATH;
    }

    protected void fillRecipes() {
        TradeOffers.Factory[] trades = WanderingHeadhunterTradeOffers.WANDERING_HEADHUNTER_TRADES.get(1);
        if (trades != null) {
            TradeOfferList traderOfferList = this.getOffers();
            this.fillRecipesFromPool(traderOfferList, trades, 9);

            int i = this.random.nextInt(trades.length);
            TradeOffers.Factory factory = trades[i];
            TradeOffer tradeOffer = factory.create(this, this.random);
            if (tradeOffer != null) {
                traderOfferList.add(tradeOffer);
            }
        }
    }

}
