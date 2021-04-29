package me.Fraithor.FraithorPots.Utilities.File;

import me.Fraithor.FraithorPots.FraithorPots;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class CustomPotions {

    public final String name;
    public final String item_name;
    public final List<String> item_lore;
    private final List<CustomPotionInfo> potions = new ArrayList<>();

    public CustomPotions(String name, String item_name, List<String> item_lore) {
        this.name = name;
        this.item_name = item_name;
        this.item_lore = item_lore;
    }

    public void addEffect(PotionEffectType effect, int level, int duration) {
        potions.add(new CustomPotionInfo(effect, level, duration));
    }

    public ItemStack getItem() {
        ItemStack poti = new ItemStack(Material.POTION);
        PotionMeta meta = (PotionMeta) poti.getItemMeta();
        assert meta != null;
        meta.setColor(Color.FUCHSIA);
        for (CustomPotionInfo pi : potions)
            meta.addCustomEffect(new PotionEffect(pi.effect, pi.duration, pi.level), true);
        poti.setItemMeta(meta);
        //ThrownPotion pot = (ThrownPotion)getPl().getWorld().spawn(pl.getLocation().add(0,0,1), (Class)ThrownPotion.class);
        return poti;
    }

    private FraithorPots getPl() {
        return FraithorPots.getInstance();
    }

}
