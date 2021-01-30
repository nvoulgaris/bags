import static Item.AXE
import static Item.CHERRY_BLOSSOM
import static Item.COPPER
import static Item.DAGGER
import static Item.GOLD
import static Item.IRON
import static Item.LEATHER
import static Item.LINEN
import static Item.ROSE

import spock.lang.Specification

class SpellShould extends Specification {

  Belongings belongings
  Spell spell

  def setup() {
    belongings = new Belongings()
    spell = new Spell()
  }

  def "leave the belongings empty when casting a spell and Durance has no items"() {
    when:
      spell.castTo(belongings)
    then:
      belongings.areEmpty() == true
  }

  def "not leave the belongings empty when casting a spell when Durance has items"() {
    given:
      belongings.addToBackpack(IRON)
    when:
      spell.castTo(belongings)
    then:
      belongings.areEmpty() == false
  }

  def "add a single metal item to the bag with metals"() {
    given:
      belongings.addToBackpack(IRON)
    when:
      spell.castTo(belongings)
    then:
      belongings.backpack == []
      belongings.bagWithMetals == [IRON]
  }

  def "add two metal items to the bag with metals and sort them alphabetically"() {
    given:
      belongings.addToBackpack(IRON)
      belongings.addToBackpack(GOLD)
    when:
      spell.castTo(belongings)
    then:
      belongings.backpack == []
      belongings.bagWithMetals == [GOLD, IRON]
  }

  def "add items to the bag with the corresponding category"() {
    given:
      belongings.addToBackpack(IRON)
      belongings.addToBackpack(LEATHER)
      belongings.addToBackpack(AXE)
      belongings.addToBackpack(CHERRY_BLOSSOM)
    when:
      spell.castTo(belongings)
    then:
      belongings.backpack == []
      belongings.bagWithClothes == [LEATHER]
      belongings.bagWithMetals == [IRON]
      belongings.bagWithWeapons == [AXE]
      belongings.bagWithHerbs == [CHERRY_BLOSSOM]
  }

  def "organize items alphabetically in all bags"() {
    given:
      belongings.addToBackpack([LINEN, LEATHER])
      belongings.addToBackpack([GOLD, COPPER])
      belongings.addToBackpack([DAGGER, AXE])
      belongings.addToBackpack([ROSE, CHERRY_BLOSSOM])
    when:
      spell.castTo(belongings)
    then:
      belongings.backpack == []
      belongings.bagWithClothes == [LEATHER, LINEN]
      belongings.bagWithMetals == [COPPER, GOLD]
      belongings.bagWithWeapons == [AXE, DAGGER]
      belongings.bagWithHerbs == [CHERRY_BLOSSOM, ROSE]
  }
}