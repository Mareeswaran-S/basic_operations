package com.example.task1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    var commonJsonArray: JSONArray = JSONArray()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var Name = findViewById<EditText>(R.id.etName)
        var Email = findViewById<EditText>(R.id.etEmail)
        var Number = findViewById<EditText>(R.id.etNum)
        var Print = findViewById<Button>(R.id.btnprint)
        var Check = findViewById<CheckBox>(R.id.cksave)
        var textView = findViewById<TextView>(R.id.txt)

        Check.setOnCheckedChangeListener { buttonView, isChecked ->
            if (Check.isChecked) {
                Print.isEnabled = true
            } else {
                Print.isEnabled = false
            }
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
        }

        Print.setOnClickListener {
            val commonJsonObj: JSONObject = JSONObject()
            commonJsonObj.put("name", Name.text.toString())
            commonJsonObj.put("email", Email.text.toString())
            commonJsonObj.put("Number", Number.text.toString())
            commonJsonArray.put(commonJsonObj)

            val result = StringBuilder()
            for (i in 0 until commonJsonArray.length()) {
                val jsonObject = commonJsonArray.getJSONObject(i)
                val name = jsonObject.optString("name")
                val email = jsonObject.optString("email")
                val Number = jsonObject.optString("Number")
                result.append("\n name :").append(name).append(" \n email :").append(email).append(" \n Number :\n").append(Number)
            }
            textView.text = result.toString()
        }
    }
}