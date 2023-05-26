package com.app.greenchallenge.ui.menumodule.graph

import com.github.mikephil.charting.data.Entry

class GraphDataUseCase(private val graphDataRepository: GraphDataRepository) {

    suspend fun getData(): List<Entry> {
        return graphDataRepository.getData()
    }
}
