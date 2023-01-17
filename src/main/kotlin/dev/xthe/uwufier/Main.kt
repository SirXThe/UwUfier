package dev.xthe.uwufier

import kotlin.random.Random

fun main(args: Array<String>) {
    print("Input the text you want to UwUfy: ")
    println(uwufier(readln()))
}

private fun uwufier(text: String): String {
    var uwu = text

    // Replace letters with their UwUfied counterparts
    uwu = uwu.replace('r', 'w').replace('l', 'w').replace('R', 'W').replace('L', 'W')
        .replace("na", "nya").replace("Na", "Nya").replace("nA", "nyA")

    // Stutter sometimes
    var length = 0
    for (word in uwu.split(" ")) {
        if (word.length > 1 && randomChoice(40)) {
            uwu = uwu.substring(0, uwu.indexOf(word, length)) + "${word[0]}-" + uwu.substring(uwu.indexOf(word, length))
        }
        length += word.length
    }

    // Set a random emoji after some words
    val array = uwu.toCharArray()
    for ((offset, char) in array.withIndex()) {
        if (punctuation.contains(char) && randomChoice(20)) {
            uwu = uwu.substring(0, uwu.indexOf(char, offset) + 1) + emojis[Random.nextInt(
                0,
                emojis.size - 1
            )] + uwu.substring(uwu.indexOf(char, offset) + 1)
        }
    }

    // Add a random emoji at the end of the string
    if (punctuation.contains(uwu.last()) && randomChoice(30)) {
        uwu += emojis[Random.nextInt(0, emojis.size - 1)]
    }

    return uwu
}

fun randomChoice(probability: Int): Boolean {
    val randomValue = Math.random() * 100
    return randomValue <= probability
}

private val punctuation = listOf(',', '.', '!', '?', ';', ':')

private val emojis = listOf(
    " (. ❛ ᴗ ❛.)",
    " (◕ᴗ◕✿)",
    " ( ꈍᴗꈍ)",
    " (≧▽≦)",
    " (✿^‿^)",
    " (◠‿・)—☆",
    " >///<",
    " ^v^",
    " OwO",
    " UwU",
    " ^///^",
    " ^~^",
    " Owo",
    " owo",
    " -w-",
    " ^w^",
    " uwu",
    " UwU"
)
