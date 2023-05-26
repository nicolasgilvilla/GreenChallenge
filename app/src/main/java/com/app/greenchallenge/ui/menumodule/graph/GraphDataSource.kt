package com.app.greenchallenge.ui.menumodule.graph

import com.github.mikephil.charting.data.Entry

interface GraphDataSource {
    suspend fun getData(): List<Entry>
}
