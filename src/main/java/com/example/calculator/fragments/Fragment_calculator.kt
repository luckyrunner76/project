package com.example.calculator.fragments

import android.os.Build
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
//import android.widget.Toast
//import androidx.annotation.RequiresApi
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.content.ContextCompat
//import androidx.core.view.children
//import androidx.core.view.isVisible
//import androidx.room.Room
//import com.example.calculator.Dao.AppDatabase
import com.example.calculator.R
//import com.example.calculator.databinding.FragmentCalculatorBinding
////import com.example.calculator.isNumber
//import com.example.calculator.model.History
//import com.google.android.material.bottomnavigation.BottomNavigationView
//
//
class Fragment_calculator : Fragment(R.layout.fragment_calculator) {
//
//    private lateinit var binding: FragmentCalculatorBinding
//
    override fun onCreateView(
       inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_calculator, container, false)

        return view
    }
//
//  //  class MainActivity : AppCompatActivity(){
//
//        private val expressionTextView: TextView by lazy {
//            findViewById<TextView>(R.id.txt_expression)
//        }
//        private val resultTextView: TextView by lazy {
//            findViewById<TextView>(R.id.txt_result)
//        }
//
//        private val historyLayout: View by lazy {
//            findViewById<View>(R.id.historyLayout)
//        }
//
//        private val historyLinearLayout: LinearLayout by lazy {
//            findViewById<LinearLayout>(R.id.historyLinearLayout)
//        }
//
//        private val fl: FrameLayout by lazy {
//            findViewById(R.id.fl_con)
//        }
//
//        lateinit var  db: AppDatabase
//
//        private var isOperator = false
//        private var hasOperator = false
//
//
//
//        // 메모리에 올라갔을 때
//        override fun onCreate(savedInstanceState: Bundle?) {
//            super.onCreate(savedInstanceState)
//
//            // 레이아웃과 연결
//            setContentView(R.layout.activity_main)
//
//            val nav_view = findViewById<BottomNavigationView>(R.id.nav_view)
//
//            fun changeFragment(fragment: Fragment) {
//                supportFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.fl_con, fragment)
//                    .commit()
//            }
//
//            nav_view.setOnItemSelectedListener { item ->
//
//                changeFragment(
//                    when (item.itemId) {
//                        R.id.Fragment_calculator -> {
//                            nav_view.itemIconTintList = ContextCompat.getColorStateList(this, R.color.green)
//                            nav_view.itemTextColor = ContextCompat.getColorStateList(this, R.color.yellow)
//                            Fragment_calculator()
//                            // Respond to navigation item 1 click
//                        }
//                        R.id.Fragment_percentage -> {
//                            nav_view.itemIconTintList = ContextCompat.getColorStateList(this, R.color.green)
//                            nav_view.itemTextColor = ContextCompat.getColorStateList(this, R.color.yellow)
//                            Fragment_percentage()
//                            // Respond to navigation item 2 click
//                        }
//                        R.id.Fragment_stopwatch-> {
//                            nav_view.itemIconTintList = ContextCompat.getColorStateList(this, R.color.green)
//                            nav_view.itemTextColor = ContextCompat.getColorStateList(this, R.color.yellow)
//                            Fragment_stopwatch()
//                            // Respond to navigation item 3 click
//                        }
//                        else -> {
//                            nav_view.itemIconTintList = ContextCompat.getColorStateList(this, R.color.green)
//                            nav_view.itemTextColor = ContextCompat.getColorStateList(this, R.color.yellow)
//                            Fragment_timer()
//                        }
//                    }
//                )
//                true
//            }
//            nav_view.selectedItemId = R.id.Fragment_calculator
//
//
//            db = Room.databaseBuilder(
//                applicationContext,
//                AppDatabase::class.java,
//                "historyDB"
//            ).build()
//
//        }
//
//        @RequiresApi(Build.VERSION_CODES.M)
//        fun buttonClicked(v : View) {
//            when (v.id) {
//                R.id.btn_0 -> numberButtonClicked("0")
//                R.id.btn_1 -> numberButtonClicked("1")
//                R.id.btn_2 -> numberButtonClicked("2")
//                R.id.btn_3 -> numberButtonClicked("3")
//                R.id.btn_4 -> numberButtonClicked("4")
//                R.id.btn_5 -> numberButtonClicked("5")
//                R.id.btn_6 -> numberButtonClicked("6")
//                R.id.btn_7 -> numberButtonClicked("7")
//                R.id.btn_8 -> numberButtonClicked("8")
//                R.id.btn_9 -> numberButtonClicked("9")
//
//                R.id.btn_plus -> operatorButtonClicked("+")
//                R.id.btn_minus -> operatorButtonClicked("-")
//                R.id.btn_multi -> operatorButtonClicked("X")
//                R.id.btn_div -> operatorButtonClicked("/")
//                R.id.btn_mod -> operatorButtonClicked("%")
////            R.id.btn_bracket1 -> bracketOnclick("(")
////            R.id.btn_bracket2 -> bracketOnclick(")")
//
//            }
//        }
//
//        private fun numberButtonClicked(number: String) {
//            if (isOperator) {
//                expressionTextView.append(" ")
//            }
//            isOperator = false
//
//            val expressionText = expressionTextView.text.split(" ")
//            if (expressionText.isNotEmpty() && expressionText.last().length >= 15) {
//                Toast.makeText(this, "15자리 까지만 사용할수 있습니다.", Toast.LENGTH_SHORT).show()
//                return
//            } else if (expressionText.last().isEmpty() && number == "0") {
//                Toast.makeText(this, "0은 제일앞에 올 수 없습니다.", Toast.LENGTH_SHORT).show()
//                return
//            }
//            expressionTextView.append(number)
//            resultTextView.text = calculateExpression()
//        }
//
//        @RequiresApi(Build.VERSION_CODES.M)
//        private fun operatorButtonClicked(operator: String) {
//            if (expressionTextView.text.isEmpty()) {
//                return
//            }
//
//            when {
//                isOperator -> {
//                    val text = expressionTextView.text.toString()
//                    expressionTextView.text = text.dropLast(1) + operator
//                }
//                hasOperator -> {
//                    Toast.makeText(this, "연산자는 한번만 사용할 수 있습니다.", Toast.LENGTH_SHORT).show()
//                    return
//                }
//                else -> {
//                    expressionTextView.append(" $operator")
//                }
//
//            }
//
//
//            val ssb = SpannableStringBuilder(expressionTextView.text)
//            ssb.setSpan(
//                ForegroundColorSpan(getColor(R.color.green)),
//                expressionTextView.text.length - 1, expressionTextView.text.length,
//                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//            )
//            expressionTextView.text = ssb
//            isOperator = true
//            hasOperator = true
//        }
//
//        fun String.isNumber(): Boolean {
//            return try {
//                this.toBigInteger()
//                true
//            } catch (e: NumberFormatException) {
//                false
//            }
//        }
//
//
//        fun resultButtonClicked(v: View) {
//            val expressionTexts = expressionTextView.text.split(" ")
//            if (expressionTextView.text.isEmpty() || expressionTexts.size == 1) {
//                return
//            }
//            if (expressionTexts.size != 3 && hasOperator) {
//                Toast.makeText(this, "수식을 완성해주세요", Toast.LENGTH_SHORT).show()
//                return
//            }
//            if (expressionTexts[0].isNumber().not() || expressionTexts[2].isNumber().not()) {
//                Toast.makeText(this, "오류가 발생했습니다.", Toast.LENGTH_SHORT).show()
//
//                return
//            }
//            val expressionText = expressionTextView.text.toString()
//            val resultText = calculateExpression()
//
//            Thread(Runnable {
//                db.historyDao().insertHistory(History(null,expressionText,resultText))
//            }).start()
//
//            resultTextView.text =""
//            expressionTextView.text = resultText
//
//            isOperator = false
//            hasOperator = false
//
//        }
//
//
//        private fun calculateExpression(): String {
//            val expressionTexts = expressionTextView.text.split(" ")
//
//            if (hasOperator.not() || expressionTexts.size != 3) {
//                return ""
//            } else if (expressionTexts[0].isNumber().not() || expressionTexts[2].isNumber().not()) {
//                return ""
//            }
//            val exp1 = expressionTexts[0].toBigInteger()
//            val exp2 = expressionTexts[2].toBigInteger()
//            val op = expressionTexts[1]
//
//            return when (op) {
//                "+" -> (exp1 + exp2).toString()
//                "-" -> (exp1 - exp2).toString()
//                "X" -> (exp1 * exp2).toString()
//                "%" -> (exp1 % exp2).toString()
//                "/" -> (exp1 / exp2).toString()
//                else -> ""
//            }
//        }
//
//        fun clearButtonClicked(v: View) {
//            expressionTextView.text = ""
//            resultTextView.text = ""
//            isOperator = false
//            hasOperator =false
//        }
//
//        fun historyButtonClicked(v: View) {
//            historyLayout.isVisible = true
//            historyLinearLayout.removeAllViews() //리니어 레이아웃밑에 있는 view들 전부 삭제
//
//            Thread(Runnable {
//                db.historyDao().getAll().reversed().forEach {
//                    runOnUiThread{
//                        val historyView = LayoutInflater.from(this).inflate(R.layout.history_row,null,false)
//                        historyView.findViewById<TextView>(R.id.txt_expression).text = it.expression
//                        historyView.findViewById<TextView>(R.id.txt_result).text = "= ${it.result}"
//
//                        historyLinearLayout.addView(historyView)
//                    }
//                }
//            }).start()
//        }
//
//        fun closeHistoryButtonClicked(v: View) {
//            historyLayout.isVisible = false
//        }
//
//        fun historyClearButtonClicked(v: View) {
//            historyLinearLayout.removeAllViews()
//
//            Thread(Runnable {
//                db.historyDao().deleteAll()
//            }).start()
//        }
//    }
//
}