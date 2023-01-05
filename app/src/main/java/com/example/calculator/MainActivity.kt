package com.example.calculator

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CALCULATE.setOnClickListener {
            val num1 = number1.text.toString().toFloat()
            val num2 = number2.text.toString().toFloat()
            lateinit var output: String
            if(ADD.isChecked){
                output = (num1 + num2).toString()
            }
            else  if(SUBTRACT.isChecked){
                output = (num1 - num2).toString()
            }
            else  if(MULTIPLY.isChecked){
                output = (num1 * num2).toString()
            }
            else  if(DIVIDE.isChecked){
                output = (num1 / num2).toString()
            }

            val dialogClickListener =
                DialogInterface.OnClickListener { dialog, which ->
                    when (which) {
                        DialogInterface.BUTTON_NEGATIVE -> {
                            dialog.dismiss()
                        }
                    }
                }
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)


            builder.setMessage("Answer is:  $output")
                .setTitle("OUTPUT")
                .setNegativeButton("OK", dialogClickListener)
                .show()
        }
    }
}