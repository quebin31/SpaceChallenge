package org.quebin31.spacechallenge

import kotlin.random.Random

class U2 : Rocket() {
    override val cost = 120 // millions US$
    override val cargoLimit: Int = 11 * 1000 // kg

    override fun launch(): Boolean {
        val chanceOfExplosion = 0.04 * (cargoCarried / cargoLimit)
        val random = Random.nextDouble()

        return random < chanceOfExplosion
    }

    override fun land(): Boolean {
        val chanceOfCrash = 0.08 * (cargoCarried / cargoLimit)
        val random = Random.nextDouble()

        return random < chanceOfCrash
    }
}
