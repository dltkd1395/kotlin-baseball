package baseball

fun main() {
    val computerNumbers = ComputerNumber().getRandomNumbers()
    if (!isNumberException(computerNumbers)) {
        throw IllegalArgumentException()
    }

    val playerNumbers = PlayerNumber().inputPlayerNumber()
    if (!isNumberException(playerNumbers)) {
        throw IllegalArgumentException()
    }

    val baseBall = BaseBall(computerNumbers, playerNumbers)
    val strike = baseBall.getStrikeCount()
    val ball = baseBall.getBallCount()

    PlayerNumber().exitGame()

}

fun isNumberException(number: List<Int>): Boolean {
    return number.size == 3 && isOneToNine(number) && isNotDuplicate(number)
}

fun isOneToNine(number: List<Int>): Boolean {
    return number.all { num -> num >= 1 && num <= 9 }
}

fun isNotDuplicate(number: List<Int>): Boolean {
    return number.size == number.distinct().size
}