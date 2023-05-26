package com.app.greenchallenge.desordenado.menumodule.graph

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.mikephil.charting.data.Entry
import kotlinx.coroutines.launch

class GraphViewModel(private val graphDataUseCase: GraphDataUseCase) : ViewModel() {


    private val _data = MutableLiveData<List<Entry>>()
    val data: LiveData<List<Entry>> = _data

    fun refreshData() {
        viewModelScope.launch {
            val newData = graphDataUseCase.getData()
            _data.postValue(newData)
        }
    }
}
