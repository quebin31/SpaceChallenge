package org.quebin31.spacechallenge

import kotlin.random.Random

abstract class Rocket : SpaceShip {
    abstract val cost: Int
    abstract val cargoLimit: Int
    var cargoCarried: Int = 0
        protected set

    override fun launch(): Boolean = true
    override fun land(): Boolean = true
    override fun canCarry(item: Item): Boolean = cargoCarried + item.weight <= cargoLimit

    override fun carry(item: Item) {
        if (!canCarry(item)) return
        cargoCarried += item.weight
    }
}

class U1 : Rocket() {
    override val cost = 100 // millions US$
    override val cargoLimit: Int = 8 * 1000 // kg

    override fun launch(): Boolean {
        val chanceOfExplosion = 0.05 * (cargoCarried / cargoLimit)
        val random = Random.nextDouble()

        return !(random < chanceOfExplosion)
    }

    override fun land(): Boolean {
        val chanceOfCrash = 0.01 * (cargoCarried / cargoLimit)
        val random = Random.nextDouble()

        return !(random < chanceOfCrash)
    }
}

class U2 : Rocket() {
    override val cost = 120 // millions US$
    override val cargoLimit: Int = 11 * 1000 // kg

    override fun launch(): Boolean {
        val chanceOfExplosion = 0.04 * (cargoCarried / cargoLimit)
        val random = Random.nextDouble()

        return !(random < chanceOfExplosion)
    }

    override fun land(): Boolean {
        val chanceOfCrash = 0.08 * (cargoCarried / cargoLimit)
        val random = Random.nextDouble()

        return !(random < chanceOfCrash)
    }
}
