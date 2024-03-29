package com.app.greenchallenge.desordenado.menumodule.graph

import com.github.mikephil.charting.data.Entry

class GraphDataRepositoryImpl(private val graphDataSource: GraphDataSource) : GraphDataRepository {

    override suspend fun getData(): List<Entry> {
        return graphDataSource.getData()
    }
}
