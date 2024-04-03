package com.example.myhistorryapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    enum class HistoricalFigures(val age: Int, val description: String, val person: String) {
        Figure_1(95, "Nelson Mandela was a great leader and anti-apartheid revolutionary who served as President of South Africa.", "Nelson Mandela"),
        Figure_2(90, "Sir Winston Churchill was a British statesman, soldier, and writer who served as Prime Minister of the United Kingdom during the Second World War.", "Sir Winston Churchill"),
        Figure_3(66, "Marie Curie was a pioneering physicist and chemist known for her research on radioactivity.", "Marie Curie"),
        Figure_4(76, "Albert Einstein was a theoretical physicist known for developing the theory of relativity.", "Albert Einstein"),
        Figure_5(84, "Isaac Newton was an English mathematician, physicist, and astronomer, widely recognized as one of the most influential scientists of all time.", "Isaac Newton"),
        Figure_6(67, "Leonardo da Vinci was an Italian polymath of the Renaissance, known for his contributions to art, science, and engineering.", "Leonardo da Vinci"),
        Figure_7(39, "Cleopatra VII was the last active ruler of the Ptolemaic Kingdom of Egypt, known for her intelligence and charm.", "Cleopatra VII"),
        Figure_8(32, "Alexander the Great was a Macedonian king who created one of the largest empires in ancient history.", "Alexander the Great"),
        Figure_10(39, "Amelia Earhart was an aviation pioneer and the first female aviator to fly solo across the Atlantic Ocean.", "Amelia Earhart"),
        Figure_11(78, "Mahatma Gandhi was the leader of the Indian independence movement against British rule, known for his practice of nonviolent civil disobedience.", "Mahatma Gandhi"),
        Figure_12(87, "Mother Teresa, known in the Catholic Church as Saint Teresa of Calcutta, was an Albanian-Indian Roman Catholic nun and missionary.", "Mother Teresa"),
        Figure_13(56, "Julius Caesar was a Roman general and statesman who played a critical role in the events that led to the demise of the Roman Republic and the rise of the Roman Empire.", "Julius Caesar"),
        Figure_14(49, "Alexander Hamilton was a Founding Father of the United States, an influential interpreter and promoter of the U.S. Constitution, and the founder of the nation's financial system.", "Alexander Hamilton"),
        Figure_15(37, "Vincent van Gogh was a Dutch Post-Impressionist painter who is among the most famous and influential figures in the history of Western art.", "Vincent van Gogh"),
        Figure_16(56, "Ludwig van Beethoven was a German composer and pianist. A crucial figure in the transition between the Classical and Romantic eras in classical music, he remains one of the most recognized and influential musicians of this period.", "Ludwig van Beethoven"),
        Figure_17(72, "Isaac Asimov was an American writer and professor of biochemistry, known for his works of science fiction and popular science.", "Isaac Asimov"),
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val edtAgeText = findViewById<EditText>(R.id.enterage)
        val btnResult = findViewById<Button>(R.id.resultbtn)
        val btnClear = findViewById<Button>(R.id.clearbtn)
        val textResult = findViewById<TextView>(R.id.textResult)

        btnResult?.setOnClickListener() {

            val Age = edtAgeText.text.toString().toInt()

            if (Age in 20..100) {

                val figureAge = HistoricalFigures.values().map { it.age }

                val figures = when (Age) {

                    in figureAge -> {
                        val figure = HistoricalFigures.values().find { it.age == Age }
                        listOf("You are ($Age),the same age as ${figure?.description}")
                    }

                    in figureAge.map { it - 1 } -> {
                        val figure = HistoricalFigures.values().find { it.age == Age - 1 }
                        listOf("You are around the same age as ${figure?.person} , ${figure?.description}")
                    }

                    in figureAge.map { it - 2 } -> {
                        val figure = HistoricalFigures.values().find { it.age == Age - 2 }
                        listOf("You are around the same age as ${figure?.person} +${figure?.description}")
                    }

                    in figureAge.map { it - 3 } -> {
                        val figure = HistoricalFigures.values().find { it.age == Age - 3 }
                        listOf("You are around the same age as ${figure?.person} ${figure?.description}")
                    }

                    in figureAge.map { it + 1 } -> {
                        val figure = HistoricalFigures.values().find { it.age == Age + 1 }
                        listOf("You are around the same age as ${figure?.person} ; ${figure?.description}")
                    }

                    in figureAge.map { it + 2 } -> {
                        val figure = HistoricalFigures.values().find { it.age == Age + 2 }
                        listOf("You are around the same age as" + "${figure?.person}" + "${figure?.description}")
                    }

                    in figureAge.map { it + 3 } -> {
                        val figure = HistoricalFigures.values().find { it.age == Age - +3 }
                        listOf("You are around the same age as ${figure?.person}  ${figure?.description}")
                    }

                    else -> listOf(" No hisorical figure found for age $Age.")
                }
                textResult.text = figures.joinToString("\n")
            } else {
                textResult.text = "please enter an age in the range requirement (20-100) "
            }
        }
        btnClear?.setOnClickListener() {
            edtAgeText.text.clear()
            textResult.text = ""
        }
    }
}