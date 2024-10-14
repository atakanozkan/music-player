package org.hyperskill.musicplayer.architecture.ui.mapper

interface Mapper<in INPUT, out OUTPUT> {
    fun map(input: INPUT): OUTPUT
    fun mapList(inputList: List<INPUT>): List<OUTPUT> {
        return inputList.map { map(it) }
    }
}
