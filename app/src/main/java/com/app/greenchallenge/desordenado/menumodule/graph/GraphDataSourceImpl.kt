package com.app.greenchallenge.desordenado.menumodule.graph

import com.github.mikephil.charting.data.Entry

class GraphDataSourceImpl : GraphDataSource {

    override suspend fun getData(): List<Entry> {
        return listOf()
    }
}
