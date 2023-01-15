package guri.projects.a7minworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import guri.projects.a7minworkout.databinding.ActivityBmiactivityBinding
import java.math.BigDecimal
import java.math.RoundingMode

class BMIActivity : AppCompatActivity() {

    private var binding : ActivityBmiactivityBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmiactivityBinding.inflate(layoutInflater)
        setContentView(binding?.root)


        setSupportActionBar(binding?.toolbarBmiActivity)

        if(supportActionBar != null)
        {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.title = "CALCULATE BMI"
        }

        binding?.toolbarBmiActivity?.setNavigationOnClickListener {
            onBackPressed()
        }


        binding?.btnCalculateUnits?.setOnClickListener {

            if(validateMetricUnits())
            {
                val heightValue : Float = binding?.etMetricUnitHeight?.text.toString().toFloat()

                val weightValue : Float = binding?.etMetricUnitWeight?.text.toString().toFloat()

                val bmi = weightValue/(heightValue*heightValue)


                displayBMIResult(bmi)
            }
            else{
                Toast.makeText(this@BMIActivity, "Field is empty : Enter values", Toast.LENGTH_LONG).show()
            }
        }




    }

    private fun displayBMIResult(bmi: Float)
    {
        val bmiLabel : String
        val bmiDescription : String

        if(bmi.compareTo(18.5f) <= 0) // bmi < 15
        {
            bmiLabel = "UnderWeight"
            bmiDescription = "Eat"
        }
        else if(bmi.compareTo(18.5f) > 0 && bmi.compareTo(25f) <= 0)
        {
            bmiLabel = "Normal"
            bmiDescription = "Normal Range"
        }else if(bmi.compareTo(25f) > 0 && bmi.compareTo(30f) <= 0)
        {
            bmiLabel = "OverWeight"
            bmiDescription = "Start Dieting"
        }else
        {
            bmiLabel = "Obese"
            bmiDescription = "Start Dieting"
        }

        val bmiValue = BigDecimal(bmi.toDouble())
            .setScale(2, RoundingMode.HALF_EVEN).toString()

        binding?.llDiplayBMIResult?.visibility = View.VISIBLE
        binding?.tvBMIValue?.text = bmiValue

        binding?.tvBMIType?.text = bmiLabel
        binding?.tvBMIDescription?.text = bmiDescription

    }

    private fun validateMetricUnits() : Boolean{

        var isValid = true

        if(binding?.etMetricUnitWeight?.text.toString().isEmpty())
        {
            isValid = false
        }else if(binding?.etMetricUnitHeight?.text.toString().isEmpty())
        {
            isValid = false
        }

//        if(binding?.etMetricUnitWeight?.text.toString().isEmpty() ||
//            binding?.etMetricUnitHeight?.text.toString().isEmpty())
//        {
//            isValid = false
//        }

        return isValid
    }
}