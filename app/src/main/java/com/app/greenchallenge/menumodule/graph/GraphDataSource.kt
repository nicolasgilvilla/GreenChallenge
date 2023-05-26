package com.app.greenchallenge.menumodule.graph

import com.github.mikephil.charting.data.Entry

interface GraphDataSource {
    suspend fun getData(): List<Entry>
}
