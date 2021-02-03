package org.quebin31.spacechallenge

import java.io.File

object Simulation {
    fun loadItems(fileName: String): ArrayList<Item> {
        val lines = File(fileName).readLines()
        val items =
                lines.mapNotNull {
                    val fields = it.split("=")
                    try {
                        Item(name = fields[0], weight = fields[1].toInt())
                    } catch (e: Exception) {
                        null
                    }
                }

        return ArrayList(items)
    }

    private fun <R : Rocket> loadRockets(items: Iterable<Item>, factory: () -> R): ArrayList<R> {
        val rockets = arrayListOf<R>()
        var currentRocket = factory()

        for (item in items) {
            if (!currentRocket.canCarry(item)) {
                rockets.add(currentRocket)
                currentRocket = factory()
            } else {
                currentRocket.carry(item)
            }
        }

        return ArrayList(rockets)
    }

    fun loadU1(items: Iterable<Item>): ArrayList<U1> {
        return loadRockets(items) { U1() }
    }

    fun loadU2(items: Iterable<Item>): ArrayList<U2> {
        return loadRockets(items) { U2() }
    }

    fun <R : Rocket> runSimulation(rockets: Iterable<R>): Int {
        var neededBudget = 0

        for (rocket in rockets) {
            var failed = true

            while (failed) {
                neededBudget += rocket.cost
                failed = !rocket.launch() || !rocket.land()
            }
        }

        return neededBudget
    }
}
