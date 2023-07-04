package com.example.shriramquizapp.utils


object ColorPicker {
    val colors = arrayOf(
        "#E44F55",
        "#FA8056",
        "#818BCA",
        "#7D659F",
        "#51BAB3",
        "#3EB9DF",
        "#3685BC",
        "#E3AD17",
        "#627991",
        "#EF8EAD",
        "#D36280",
        "#4FB66C",
        "#B5BFC6"
    )
    var currentColorIndex = 0

    fun getColor(): String {
        currentColorIndex = (currentColorIndex + 1) % colors.size
        return colors[currentColorIndex]
    }
}