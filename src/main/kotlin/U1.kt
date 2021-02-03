package org.quebin31.spacechallenge

import kotlin.random.Random

class U1 : Rocket() {
    override val cost = 100 // millions US$
    override val cargoLimit: Int = 8 * 1000 // kg

    override fun launch(): Boolean {
        val chanceOfExplosion = 0.05 * (cargoCarried / cargoLimit)
        val random = Random.nextDouble()

        return random < chanceOfExplosion
    }

    override fun land(): Boolean {
        val chanceOfCrash = 0.01 * (cargoCarried / cargoLimit)
        val random = Random.nextDouble()

        return random < chanceOfCrash
    }
}
