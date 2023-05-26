package com.app.greenchallenge.ui.menumodule.graph

import com.github.mikephil.charting.data.Entry

class GraphDataSourceImpl : GraphDataSource {

    override suspend fun getData(): List<Entry> {
        return listOf()
    }
}
