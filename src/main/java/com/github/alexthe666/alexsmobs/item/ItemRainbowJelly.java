package com.github.alexthe666.alexsmobs.item;

import com.github.alexthe666.alexsmobs.entity.util.RainbowUtil;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

public class ItemRainbowJelly extends Item {

    public ItemRainbowJelly(Item.Properties tab) {
        super(tab);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player playerIn, LivingEntity target, InteractionHand hand) {
        int i = RainbowUtil.getRainbowTypeFromStack(stack);
        if (RainbowUtil.getRainbowType(target) != i) {
            RainbowUtil.setRainbowType(target, i);
            RandomSource random = playerIn.getRandom();
            for (int j = 0; j < 6 + random.nextInt(3); j++) {
                double d2 = random.nextGaussian() * 0.02D;
                double d0 = random.nextGaussian() * 0.02D;
                double d1 = random.nextGaussian() * 0.02D;
                playerIn.level.addParticle(new ItemParticleOption(ParticleTypes.ITEM, stack), target.getX() + (double) (random.nextFloat() * target.getBbWidth()) - (double) target.getBbWidth() * 0.5F, target.getY() + target.getBbHeight() * 0.5F + (double) (random.nextFloat() * target.getBbHeight() * 0.5F), target.getZ() + (double) (random.nextFloat() * target.getBbWidth()) - (double) target.getBbWidth() * 0.5F, d0, d1, d2);
            }
            target.gameEvent(GameEvent.ITEM_INTERACT_START);
            target.playSound(SoundEvents.SLIME_SQUISH_SMALL, 1F, target.getVoicePitch());
            if (!playerIn.isCreative()) {
                stack.shrink(1);
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    public ItemStack finishUsingItem(ItemStack st, Level level, LivingEntity e) {
        RainbowUtil.setRainbowType(e, RainbowUtil.getRainbowTypeFromStack(st));
        return this.isEdible() ? e.eat(level, st) : st;
    }

    public int getUseDuration(ItemStack stack) {
        if (stack.getItem().isEdible()) {
            return 64;
        } else {
            return 0;
        }
    }

    public boolean isFoil(ItemStack stack) {
        return super.isFoil(stack) || RainbowUtil.getRainbowTypeFromStack(stack) > 1;
    }

    public enum RainbowType {
        RAINBOW, TRANS, NONBI, BI, ACE, WEEZER, BRAZIL, CHINA, COOLCAT, GOJO, LOBA, MARIO, PUPPY, RACCOON, SOYJACK, TROLL, JOOMFACE, ROBERT, SKULL, FRIEREN;


        public static RainbowType getFromString(String name) {
            if (name.contains("nonbi") || name.contains("non-bi")) {
                return NONBI;
            }
            else if (name.contains("trans")) {
                return TRANS;
            }
            else if (name.contains("bi")) {
                return BI;
            }
            else if (name.contains("asexual") || name.contains("ace") && !name.contains("joom")) {
                return ACE;
            }
            else if (name.contains("weezer")) {
                return WEEZER;
            }
            else if (name.contains("brazil")) {
                return BRAZIL;
            }
            else if (name.contains("robert")) {
                return ROBERT;
            }
            else if (name.contains("joom")) {
                return JOOMFACE;
            }
            else if (name.contains("china")) {
                return CHINA;
            }
            else if (name.contains("coolcat")) {
                return COOLCAT;
            }
            else if (name.contains("gojo")) {
                return GOJO;
            }
            else if (name.contains("loba") || (name.contains("apex"))) {
                return LOBA;
            }
            else if (name.contains("mario")) {
                return MARIO;
            }
            else if (name.contains("puppy")) {
                return PUPPY;
            }
            else if (name.contains("raccoon")) {
                return RACCOON;
            }
            else if (name.contains("soyjack")) {
                return SOYJACK;
            }
            else if (name.contains("troll")) {
                return TROLL;
            }
            else if (name.contains("skull")) {
                return SKULL;
            }
            else if (name.contains("frieren")) {
                return FRIEREN;
            }
            return RAINBOW;
        }
    }
}
