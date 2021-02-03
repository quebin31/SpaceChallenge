package org.quebin31.spacechallenge

abstract class Rocket : SpaceShip {
    abstract val cost: Int
    abstract val cargoLimit: Int
    var cargoCarried: Int = 0

    override fun launch(): Boolean = true
    override fun land(): Boolean = true
    override fun canCarry(item: Item): Boolean = cargoCarried + item.weight <= cargoLimit

    override fun carry(item: Item) {
        if (!canCarry(item)) return

        cargoCarried += item.weight
    }
}
