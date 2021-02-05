package org.quebin31.spacechallenge

import java.io.File

object Simulation {
    /** Load items from the given [fileName] */
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

    /** Load rockets and fill them with the given [items], generic version */
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

    /** Load U1 rockets with the given [items] */
    fun loadU1(items: Iterable<Item>): ArrayList<U1> = loadRockets(items, ::U1)

    /** Load U2 rockets with the given [items] */
    fun loadU2(items: Iterable<Item>): ArrayList<U2> = loadRockets(items, ::U2)

    /** Run the simulation with the given [rockets] and return the needed budget to launch them */
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
