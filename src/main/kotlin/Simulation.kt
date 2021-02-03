package org.quebin31.spacechallenge

import java.io.File

class Simulation {
    fun loadItems(fileName: String): ArrayList<Item> {
        val lines = File(fileName).readLines()
        val items =
                lines.mapNotNull {
                    val fields = it.split("=")
                    try {
                        Item(name = fields[0], weight = fields[1].toInt())
                    } catch { 
                        null 
                    }
                }

        return ArrayList(items)
    }

}
