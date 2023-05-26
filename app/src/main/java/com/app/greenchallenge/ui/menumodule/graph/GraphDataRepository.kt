package com.app.greenchallenge.ui.menumodule.graph

import com.github.mikephil.charting.data.Entry

interface GraphDataRepository {
    suspend fun getData(): List<Entry>
}
