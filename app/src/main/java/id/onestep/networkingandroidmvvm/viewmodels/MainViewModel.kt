package id.onestep.networkingandroidmvvm.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import id.onestep.networkingandroidmvvm.models.ResultsItem
import id.onestep.networkingandroidmvvm.networks.MainRepos

class MainViewModel(application:Application):AndroidViewModel(application) {
    private val repo = MainRepos()

    var listMovie:MutableLiveData<ResultsItem> = MutableLiveData()
    var error:MutableLiveData<Throwable> = MutableLiveData()

    fun getMovie(){
        repo.reqMovie(
                {listMovie.postValue(it)},
                {error.postValue(it)})
    }

    override fun onCleared() {
        super.onCleared()
        repo.onDestroy()
    }

}