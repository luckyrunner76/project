import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.calculator.R
import com.example.calculator.databinding.ActivityMainBinding
import com.example.calculator.fragments.Fragment_calculator
import com.example.calculator.fragments.Fragment_percentage
import com.example.calculator.fragments.Fragment_stopwatch
import com.example.calculator.fragments.Fragment_timer



private const val TAG_CALCULATOR = "Fragment_calculator"
private const val TAG_PERCENTAGE = "Fragment_percentage"
private const val TAG_STOPWATCH = "Fragment_stopwatch"
private const val TAG_TIMER = "Fragment_timer"

class MainActivity  : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setFragment(TAG_CALCULATOR, Fragment_calculator())

        binding.navigationView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.Fragment_calculator -> setFragment(TAG_CALCULATOR, Fragment_calculator())
                R.id.Fragment_percentage -> setFragment(TAG_PERCENTAGE, Fragment_percentage())
                R.id.Fragment_stopwatch -> setFragment(TAG_STOPWATCH, Fragment_stopwatch())
                R.id.Fragment_timer-> setFragment(TAG_TIMER, Fragment_timer())
            }
            true
        }
    }

    private fun setFragment(tag: String, fragment: Fragment) {
        val manager: FragmentManager = supportFragmentManager
        val fragTransaction = manager.beginTransaction()

        if (manager.findFragmentByTag(tag) == null){
            fragTransaction.add(R.id.mainFrameLayout, fragment, tag)
        }

        val calculator = manager.findFragmentByTag(TAG_CALCULATOR)
        val percentage = manager.findFragmentByTag(TAG_PERCENTAGE)
        val stopwatch = manager.findFragmentByTag(TAG_STOPWATCH)
        val timer = manager.findFragmentByTag(TAG_TIMER)

        if (calculator != null){
            fragTransaction.hide(calculator)
        }

        if (percentage != null){
            fragTransaction.hide(percentage)
        }

        if (stopwatch != null) {
            fragTransaction.hide(stopwatch)
        }

        if (timer != null) {
            fragTransaction.hide(timer)
        }

        if (tag == TAG_CALCULATOR) {
            if (calculator!=null){
                fragTransaction.show(calculator)
            }
        }
        else if (tag == TAG_PERCENTAGE) {
            if (percentage != null) {
                fragTransaction.show(percentage)
            }
        }
        else if (tag == TAG_STOPWATCH) {
            if (stopwatch != null) {
                fragTransaction.show(stopwatch)
            }
        }
        else if (tag == TAG_TIMER){
            if (timer != null){
                fragTransaction.show(timer)
            }
        }

        fragTransaction.commitAllowingStateLoss()
    }
}