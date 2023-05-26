package com.app.greenchallenge.menumodule.graph

import com.github.mikephil.charting.data.Entry

interface GraphDataRepository {
    suspend fun getData(): List<Entry>
}
