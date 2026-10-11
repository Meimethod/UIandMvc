package cn.edu.sicnu.cs.lrj.second

class Program {
    fun getAdvice(inputText: String, keyGame:String, keyWeb:String, keyMobile:String): Int {
        return when {
            inputText.contains(keyGame) -> R.string.res_game
            inputText.contains(keyWeb) -> R.string.res_web
            inputText.contains(keyMobile) -> R.string.res_mobile
            else -> R.string.res_other
        }
    }
}