package com.sysaxiom.networkhandlingmvvm.utils

import android.app.Application
import com.sysaxiom.networkhandlingmvvm.handlers.network.NetworkHandler
import com.sysaxiom.networkhandlingmvvm.ui.appointment.AppointmentViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MVVMBasicsApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@MVVMBasicsApplication))
        bind() from singleton { NetworkHandler(instance()) }
        bind() from provider { AppointmentViewModelFactory(instance()) }

    }

}