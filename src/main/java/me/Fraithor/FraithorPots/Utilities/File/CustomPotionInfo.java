package me.Fraithor.FraithorPots.Utilities.File;

import org.bukkit.potion.PotionEffectType;

public class CustomPotionInfo {

    public final PotionEffectType effect;
    public final int level;
    public final int duration;

    public CustomPotionInfo(PotionEffectType effect, int level, int duration) {
        this.effect = effect;
        this.level = level;
        this.duration = duration;
    }

}
