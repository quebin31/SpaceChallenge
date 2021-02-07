package org.quebin31.spacechallenge

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Error: No files received")
        println("Usage: program files...")
        return
    }

    val phaseItems = args.map { phase -> Simulation.loadItems(phase) }

    // Simulation with u1 rockets
    println("Simulation with U1 rockets")
    for ((index, items) in phaseItems.withIndex()) {
        val u1Rockets = Simulation.loadU1(items)
        val u1Budget = Simulation.runSimulation(u1Rockets)
        println(":: Needed budget for phase ${index + 1}: \$$u1Budget millions")
    }

    // Simulation with u2 rockets
    println("Simulation with U2 rockets")
    for ((index, items) in phaseItems.withIndex()) {
        val u2Rockets = Simulation.loadU2(items)
        val u2Budget = Simulation.runSimulation(u2Rockets)
        println(":: Needed budget for phase ${index + 1}: \$$u2Budget millions")
    }
}
