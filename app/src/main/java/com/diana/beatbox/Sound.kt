package com.diana.beatbox

class Sound(_assetPath: String) {

    val name: String
    val assetPath: String = _assetPath

    init {
        val components: List<String> = assetPath.split("/")
        val filename: String = components[components.size - 1]
        name = filename.replace(".wav", "")
    }

    constructor() : this("")

}