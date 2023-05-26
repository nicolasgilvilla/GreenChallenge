package com.app.greenchallenge.desordenado.menumodule.commonchallenge

import android.view.View
import com.domain.ModelCommon

interface CommonOnClickListener {

    fun onClick(view: View, position: Int, commonList: List<ModelCommon>)

}

