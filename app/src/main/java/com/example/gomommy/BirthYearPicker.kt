package com.example.gomommy

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import java.time.Year

class BirthYearPicker : AppCompatActivity() {
    private lateinit var btnSelectYear: Button
    private lateinit var tvSelectedYear: TextView
    private lateinit var npYear: NumberPicker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_birth_year_picker)

        btnSelectYear = findViewById(R.id.btnSelectYear)
        tvSelectedYear = findViewById(R.id.tvSelectedYear)
        npYear = findViewById(R.id.npYear)

        // Set up the NumberPicker with a range of years
        val currentYear = Year.now().value
        val yearRange = ArrayList<String>()
        yearRange.add("Select") // Add "Select" as the first item
        for (year in currentYear downTo 2000) {
            yearRange.add(year.toString())
        }
        npYear.minValue = 0
        npYear.maxValue = yearRange.size - 1
        npYear.displayedValues = yearRange.toTypedArray()

        btnSelectYear.setOnClickListener {
            // Get the selected year from the NumberPicker
            val selectedYear = if (npYear.value == 0) null else yearRange[npYear.value].toInt()

            // Update the selected year in the TextView
            tvSelectedYear.text = "Selected Year: ${selectedYear ?: "Not selected"}"
        }
    }
}