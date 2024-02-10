package Programmers.level0

class Solution {
    fun solution(a: Int, b: Int): Int {

        val isAOdd = (a%2) != 0 // true면 홀수
        val isBOdd = (b%2) != 0 // true면 홀수

        when{
            isAOdd && isBOdd -> return a*a+b*b
            !isAOdd && !isBOdd -> return Math.abs(a-b)
            else -> return 2*(a+b)
        }

    }
}
