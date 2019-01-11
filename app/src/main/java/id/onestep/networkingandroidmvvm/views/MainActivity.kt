package id.onestep.networkingandroidmvvm.views

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import id.onestep.networkingandroidmvvm.R
import id.onestep.networkingandroidmvvm.adapters.ListMovieAdapter
import id.onestep.networkingandroidmvvm.databinding.ActivityMainBinding
import id.onestep.networkingandroidmvvm.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var viewModel : MainViewModel
    private lateinit var adapter : ListMovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        binding.main=viewModel

        binding.btnSearch.setOnClickListener { viewModel.getMovie(binding.etCategory.getText().toString()) }

    }

    private fun setupRecyvleView(){
        val layoutManager = LinearLayoutManager(this)
        //binding. ke rvMovie
        binding.rvMovie.layoutManager = layoutManager
        adapter = ListMovieAdapter(this)

        binding.rvMovie.adapter=adapter


    }
}
