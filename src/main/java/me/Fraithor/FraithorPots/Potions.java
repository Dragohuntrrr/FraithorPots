package me.Fraithor.FraithorPots;

import me.Fraithor.FraithorPots.Utilities.File.CustomPotions;
import me.Fraithor.FraithorPots.Utilities.File.FileBasics;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Potions {

    private final List<CustomPotions> potionsList = new ArrayList<>();

    public void load() { //Load all config potions with a yaml loading scheme
        FileBasics.FILETYPE config = FileBasics.FILETYPE.CONFIG;
        Set<String> _potions = config.getConfig().getKeys(false);
        for (String path : _potions) {
            String name = config.getString(path + ".name");
            List<String> lore = config.getStringList(path + ".lore");
            int duration = config.getInt(path + ".duration");
            List<String> potionIds = config.getStringList(path + ".effects");
            CustomPotions customPotions = new CustomPotions(path, name, lore);
            for (String _potion : potionIds) {
                String[] _potionInfo = _potion.split(":");
                PotionEffectType effect = PotionEffectType.getByName(_potionInfo[0].toUpperCase());
                int level = _potionInfo.length > 1 ? Integer.parseInt(_potionInfo[1]) : 1; //<- Will cause an error if second value isn't an integer (ie: "SPEED:two") (error protection?)
                customPotions.addEffect(effect, level, duration);
            }
        }
    }

    public List<CustomPotions> getPotionsList() {
        return potionsList;
    }

}
