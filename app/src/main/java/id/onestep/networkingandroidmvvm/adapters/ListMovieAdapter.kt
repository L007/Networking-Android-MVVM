package id.onestep.networkingandroidmvvm.adapters

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import id.onestep.networkingandroidmvvm.R
import id.onestep.networkingandroidmvvm.databinding.ListMovieBinding
import id.onestep.networkingandroidmvvm.models.Movie
import id.onestep.networkingandroidmvvm.models.ResultsItem


import id.onestep.networkingandroidmvvm.viewmodels.ListMovieViewModel

class ListMovieAdapter(val context:Context): RecyclerView.Adapter<ListMovieAdapter.ListMovieViewHolder>() {

    private var listMovie:MutableList<ResultsItem?>? = mutableListOf()


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ListMovieViewHolder {
        val binding:ListMovieBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.list_movie,p0,false)
        return ListMovieViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listMovie?.size!!
    }

    override fun onBindViewHolder(p0: ListMovieViewHolder, p1: Int) {
        p0.bindData(listMovie?.get(p0.adapterPosition))
    }

    fun setData(list: MutableList<ResultsItem?>?){
        this.listMovie = list
    }


    class ListMovieViewHolder(private val binding:ListMovieBinding):RecyclerView.ViewHolder(binding.root) {
    fun bindData(model: ResultsItem?){
        val viewModel = ListMovieViewModel(model)
        binding.movie = viewModel
        ///////////// binding.kemena?
    }
    }


}