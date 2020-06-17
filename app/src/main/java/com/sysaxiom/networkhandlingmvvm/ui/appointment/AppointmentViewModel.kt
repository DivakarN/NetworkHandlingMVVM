package com.sysaxiom.networkhandlingmvvm.ui.appointment

import android.content.Context
import androidx.lifecycle.ViewModel
import com.sysaxiom.networkhandlingmvvm.handlers.network.NetworkHandler


class AppointmentViewModel(
    private val context: Context
) : ViewModel() {

    fun getNetwork() = NetworkHandler(context)

}