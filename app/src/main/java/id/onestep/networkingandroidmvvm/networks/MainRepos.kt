package id.onestep.networkingandroidmvvm.networks

import id.onestep.networkingandroidmvvm.ApiObserver
import id.onestep.networkingandroidmvvm.models.ResultsItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainRepos {
    private val apiService = ServiceFactory.create()
    private val compositeDisposable = CompositeDisposable()

    fun reqMovie(catgeory:String,onResult:(ResultsItem)->Unit,onError:(Throwable)->Unit){
        apiService.getMovie(catgeory)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object :ApiObserver<ResultsItem>(compositeDisposable){
                    override fun onApiSuccess(data: ResultsItem) {
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