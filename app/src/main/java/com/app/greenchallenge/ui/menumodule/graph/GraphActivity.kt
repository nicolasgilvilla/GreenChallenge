package com.app.greenchallenge.ui.menumodule.graph

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.app.greenchallenge.R
import com.app.greenchallenge.databinding.ActivityGraphBinding
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.LegendEntry
import com.github.mikephil.charting.data.*

class GraphActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGraphBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGraphBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showPieOrBar(true)

        binding.refreshButton.setOnClickListener {
            showPieOrBar(true)
        }

        binding.btnLeft.setOnClickListener {
            showPieOrBar(false)
        }

        binding.layoutToolbar.goBackButton.setOnClickListener {
            onBackPressed()
        }

    }

    private fun showPieOrBar(b: Boolean) {
        if (b) {
            binding.layoutToolbar.titleBar.text = getString(R.string.generales)
            //Graficos generales, boton individual
            binding.barChart.visibility = View.GONE
            binding.refreshButton.visibility = View.GONE
            binding.pieChart.visibility = View.VISIBLE
            binding.btnLeft.visibility = View.VISIBLE
            setUpPieChar()
        } else {
            binding.layoutToolbar.titleBar.text = getString(R.string.individuales)
            //Graficos individuales, boton general
            binding.barChart.visibility = View.VISIBLE
            binding.refreshButton.visibility = View.VISIBLE
            binding.pieChart.visibility = View.GONE
            binding.btnLeft.visibility = View.GONE
            setUpBarChar()
        }
    }

    private fun setUpPieChar() {

        val entries = listOf(
            PieEntry(26f, 26),
            PieEntry(23f, 23),
            PieEntry(12f, 12),
            PieEntry(35f, 35),
            PieEntry(10f, 10)
        )
        val dataSet = PieDataSet(entries, "Datos")
        val colors = listOf(
            Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW, Color.MAGENTA
        )
        dataSet.colors = colors
        dataSet.valueTextSize = 24f


        val labels = listOf("Marinos", "Sociales", "Naturales", "Reciclables", "Invernaderos")
        val legendEntries = mutableListOf<LegendEntry>()
        for (i in labels.indices) {
            val label = labels[i]
            val color = colors[i]
            val legendEntry = LegendEntry().apply {
                formColor = color
                this.label = label
            }
            legendEntries.add(legendEntry)
        }


        val pieChart: PieChart = findViewById(R.id.pieChart)
        pieChart.animateXY(1000, 1000)
        val data = PieData(dataSet)
        pieChart.data = data


        val legend: Legend = pieChart.legend
        legend.setCustom(legendEntries)
        legend.isEnabled = true
        legend.verticalAlignment = Legend.LegendVerticalAlignment.TOP
        legend.horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT

        pieChart.invalidate()
    }

    private fun setUpBarChar() {

        val barChart: BarChart = findViewById(R.id.barChart)

        val entries = listOf(
            BarEntry(1f, 5f),
            BarEntry(2f, 7f),
            BarEntry(3f, 5f),
            BarEntry(4f, 15f),
            BarEntry(5f, 1f)
        )

        val dataSet = BarDataSet(entries, "Datos de barras")

        val colors = listOf(
            Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW, Color.MAGENTA
        )
        dataSet.colors = colors
        dataSet.valueTextSize = 18f

        val barData = BarData(dataSet)

        barChart.data = barData
        barChart.setFitBars(true)
        barChart.animateY(1000)

        val legend: Legend = barChart.legend
        val labels = listOf("Marinos", "Sociales", "Naturales", "Reciclables", "Invernaderos")

        val legendEntries = mutableListOf<LegendEntry>()
        for (i in labels.indices) {
            val label = labels[i]
            val color = colors[i]
            val legendEntry = LegendEntry().apply {
                formColor = color
                this.label = label
                formSize = 12f
            }
            legendEntries.add(legendEntry)
        }

        legend.setCustom(legendEntries)
        legend.isEnabled = true
        legend.verticalAlignment = Legend.LegendVerticalAlignment.TOP
        legend.horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT

    }
}


