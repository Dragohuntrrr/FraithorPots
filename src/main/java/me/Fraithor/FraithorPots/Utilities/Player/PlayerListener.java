package me.Fraithor.FraithorPots.Utilities.Player;

import me.Fraithor.FraithorPots.Utilities.File.FileBasics;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerListener implements Listener {

    private ItemStack potions = new ItemStack(Material.POTION);
    private ItemMeta potionsItemMeta = potions.getItemMeta();


    //--IM STUCK HERE--\\
    public void onPotionDrink(PlayerItemConsumeEvent event) {
        if (FileBasics.FILETYPE.POTIONS.getString(event.getItem().getItemMeta().getDisplayName())) {

        }
    }

}
