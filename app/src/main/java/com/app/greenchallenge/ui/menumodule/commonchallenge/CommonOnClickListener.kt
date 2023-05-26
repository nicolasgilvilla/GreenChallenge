package com.app.greenchallenge.ui.menumodule.commonchallenge

import android.view.View
import com.domain.ModelCommon

interface CommonOnClickListener {

    fun onClick(view: View, position: Int, commonList: List<ModelCommon>)

}

