package id.onestep.networkingandroidmvvm.views

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import id.onestep.networkingandroidmvvm.R
import id.onestep.networkingandroidmvvm.databinding.ActivityMainBinding
import id.onestep.networkingandroidmvvm.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        binding.main=viewModel

        viewModel.getMovie()
    }
}
