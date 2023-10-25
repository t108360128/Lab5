package com.example.lab5
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var editTextText: EditText
    private lateinit var textView: TextView
    private lateinit var tv_name: TextView
    private lateinit var tv_winner: TextView
    private lateinit var tv_mmora: TextView
    private lateinit var tv_cmora: TextView
    private lateinit var btn_scissor: RadioButton
    private lateinit var btn_stone: RadioButton
    private lateinit var btn_paper: RadioButton
    private lateinit var btn_mora: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextText = findViewById(R.id.editTextText)
        textView = findViewById(R.id.textView)
        tv_name = findViewById(R.id.tv_name)
        tv_winner = findViewById(R.id.tv_winner)
        tv_mmora = findViewById(R.id.tv_mmora)
        tv_cmora = findViewById(R.id.tv_cmora)
        btn_mora = findViewById(R.id.btn_mora)
        btn_scissor = findViewById(R.id.btn_scissor)
        btn_stone = findViewById(R.id.btn_stone)
        btn_paper = findViewById(R.id.btn_paper)

        btn_mora.setOnClickListener {
            if (editTextText.length() < 1) {
                textView.text = "請輸入玩家姓名"
            } else {
                tv_name.text = String.format("名字\n%s", editTextText.text.toString())
                if (btn_scissor.isChecked) {
                    tv_mmora.text = "我方出拳\n剪刀"
                } else if (btn_stone.isChecked) {
                    tv_mmora.text = "我方出拳\n石頭"
                } else {
                    tv_mmora.text = "我方出拳\n布"
                }
                val computerRandom = (0..2).random()
                when (computerRandom) {
                    0 -> tv_cmora.text = "電腦出拳\n剪刀"
                    1 -> tv_cmora.text = "電腦出拳\n石頭"
                    2 -> tv_cmora.text = "電腦出拳\n布"
                }
                if ((btn_scissor.isChecked && computerRandom == 2) ||
                    (btn_stone.isChecked && computerRandom == 0) ||
                    (btn_paper.isChecked && computerRandom == 1)
                ) {
                    tv_winner.text = "勝利者\n${editTextText.text.toString()}"
                    textView.text = "恭喜你獲勝了!"
                } else if ((btn_scissor.isChecked && computerRandom == 1) ||
                    (btn_stone.isChecked && computerRandom == 2) ||
                    (btn_paper.isChecked && computerRandom == 0)
                ) {
                    tv_winner.text = "勝利者\n電腦"
                    textView.text = "可惜,電腦獲勝了!"
                } else {
                    tv_winner.text = "勝利者\n平手"
                    textView.text = "平局,再試一次!"
                }
            }
        }
    }
}