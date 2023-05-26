package com.app.greenchallenge.desordenado.menumodule.graph

import com.github.mikephil.charting.data.Entry

interface GraphDataRepository {
    suspend fun getData(): List<Entry>
}
