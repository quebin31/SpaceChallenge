package org.quebin31.spacechallenge

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Error: No files received")
        println("Usage: program files...")
        return
    }

    for (phase in args) {
        println("Simulation for phase: $phase")
        val items = Simulation.loadItems(phase)

        val u1Rockets = Simulation.loadU1(items)
        val u1Budget = Simulation.runSimulation(u1Rockets)
        println(":: Needed budget with U1 rockets: \$$u1Budget millions")

        val u2Rockets = Simulation.loadU2(items)
        val u2Budget = Simulation.runSimulation(u2Rockets)
        println(":: Needed budget with U2 rockets: \$$u2Budget millions")
    }
}
