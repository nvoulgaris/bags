class Belongings {

    var backpack = mutableListOf<Item>()
    var bagWithClothes = mutableListOf<Item>()
    var bagWithMetals = mutableListOf<Item>()
    var bagWithWeapons = mutableListOf<Item>()
    var bagWithHerbs = mutableListOf<Item>()

    fun addToBackpack(item: Item) {
        backpack.add(item)
    }

    fun addToBackpack(items: List<Item>) {
        backpack.addAll(items)
    }

    fun areEmpty(): Boolean {
        return backpack.isEmpty() && bagWithMetals.isEmpty()
    }
}