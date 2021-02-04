import Category.CLOTHES
import Category.HERBS
import Category.METALS
import Category.WEAPONS
import Item.AXE
import Item.CHERRY_BLOSSOM
import Item.COPPER
import Item.DAGGER
import Item.GOLD
import Item.IRON
import Item.LEATHER
import Item.LINEN
import Item.MACE
import Item.MARIGOLD
import Item.ROSE
import Item.SEAWEED
import Item.SILK
import Item.SILVER
import Item.SWORD
import Item.WOOL

class Spell {

  companion object {
    val itemsByCategory = mapOf(
      LEATHER to CLOTHES,
      LINEN to	CLOTHES,
      SILK to	CLOTHES,
      WOOL to	CLOTHES,
      COPPER to	METALS,
      GOLD to	METALS,
      IRON to	METALS,
      SILVER to	METALS,
      AXE to	WEAPONS,
      DAGGER to	WEAPONS,
      MACE to	WEAPONS,
      SWORD to	WEAPONS,
      CHERRY_BLOSSOM to HERBS,
      MARIGOLD to	HERBS,
      ROSE to	HERBS,
      SEAWEED to HERBS,
    )
  }

  fun castTo(belongings: Belongings) {
    belongings.bagWithMetals = organizeAll(belongings, METALS)
    belongings.bagWithClothes = organizeAll(belongings, CLOTHES)
    belongings.bagWithWeapons = organizeAll(belongings, WEAPONS)
    belongings.bagWithHerbs = organizeAll(belongings, HERBS)
    belongings.backpack = mutableListOf()
  }

  private fun organizeAll(belongings: Belongings, category: Category): MutableList<Item> {
    val itemsInCategory = belongings.backpack.filter { itemsByCategory[it] == category }.sorted().take(4).toMutableList()
    belongings.backpack = belongings.backpack.minus(itemsInCategory).toMutableList()
    return itemsInCategory
  }
}