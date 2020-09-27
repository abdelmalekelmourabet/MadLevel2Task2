package com.example.madlevel2task2

data class Questions(val questions: String, val answers: Boolean) {
    companion object {
        val List_Questions: Array<String> = arrayOf(
            "5 + 5 = 10",
            "13 + 13 = 25",
            "2 + 2 = 4",
            "4 + 4 = 9",
            "4 + 5 = 9"
        )

        val List_Answers: Array<Boolean> = arrayOf(true, false, true, false, true)
    }
}