package br.com.scuad.snowtest.domain.models

class Query(
    val title: String,
    val text: String,
    val color: COLOR = COLOR.GREEN
) {

    enum class COLOR{
        BLUE,
        RED,
        YELLOW,
        GREEN
    }

}