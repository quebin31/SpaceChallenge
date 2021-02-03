package org.quebin31.spacechallenge

interface SpaceShip {
    /** If `true` the launch was succesful, otherwise it crashed */
    fun launch(): Boolean

    /** If `true` the landing was succuesful */
    fun land(): Boolean

    /** Check whether this ship can carry the given [item] */
    fun canCarry(item: Item): Boolean

    /** Carry the given [item] */
    fun carry(item: Item)
}
