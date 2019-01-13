package id.onestep.networkingandroidmvvm.views

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import id.onestep.networkingandroidmvvm.R
import id.onestep.networkingandroidmvvm.adapters.ListMovieAdapter
import id.onestep.networkingandroidmvvm.databinding.ActivityMainBinding

import id.onestep.networkingandroidmvvm.viewmodels.MainViewModel

class MainActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener {
    private lateinit var binding:ActivityMainBinding
    private lateinit var viewModel : MainViewModel
    private lateinit var adapter : ListMovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        binding.main=viewModel

        ArrayAdapter.createFromResource(
            this,
            R.array.category_name,
            R.layout.spinner_item

        ).also { adapter ->

            adapter.setDropDownViewResource(R.layout.spinner_item)

            binding.spCategory.adapter = adapter }
        

        binding.spCategory.onItemSelectedListener = this
        binding.btnSearch.setOnClickListener { viewModel.getMovie(binding.etCategory.getText().toString()) }


        setupRecyvleView()
        observeLiveData()



    }

    private fun setupRecyvleView(){
        val layoutManager = LinearLayoutManager(this)
        //binding. ke rvMovie
        binding.rvMovie.layoutManager = layoutManager
        adapter = ListMovieAdapter(this)

        binding.rvMovie.adapter=adapter


    }

    private fun observeLiveData(){
        viewModel.listMovie.observe(this, Observer {
                adapter.setData(it?.results!!)
                adapter.notifyDataSetChanged()
        })
        viewModel.error.observe(this, Observer {  })
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
       viewModel.getMovie(parent.getItemAtPosition(pos).toString())
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        // Another interface callback
    }
}

