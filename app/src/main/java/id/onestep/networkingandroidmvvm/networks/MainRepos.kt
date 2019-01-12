package id.onestep.networkingandroidmvvm.networks

import id.onestep.networkingandroidmvvm.ApiObserver
import id.onestep.networkingandroidmvvm.models.Movie
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainRepos {
    private val apiService = ServiceFactory.create()
    private val compositeDisposable = CompositeDisposable()

    fun reqMovie(catgeory:String,onResult:(Movie)->Unit,onError:(Throwable)->Unit){
        apiService.getMovie(catgeory)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object :ApiObserver<Movie>(compositeDisposable){
                    override fun onApiSuccess(data: Movie) {
                        onResult(data)
                    }

                    override fun onApiFailure(er: Throwable) {
                        onError(er)
                    }

                })
    }
    fun onDestroy(){
        compositeDisposable.clear()

    }
}