package com.sysaxiom.networkhandlingmvvm.ui.appointment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sysaxiom.networkhandlingmvvm.R
import kotlinx.android.synthetic.main.activity_appointment.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class AppointmentActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()

    private val factory : AppointmentViewModelFactory by instance()

    lateinit var viewModel: AppointmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointment)

        viewModel = ViewModelProviders.of(this, factory).get(AppointmentViewModel::class.java)

        viewModel.getNetwork().observe(this, Observer {
            if(it.isNetworkAvailable.equals(true)){
                textview.text = "Internet Availble"
            } else if(it.isNetworkAvailable.equals(false)){
                textview.text = "Internet Not Availble"
            }
        })


    }

}
