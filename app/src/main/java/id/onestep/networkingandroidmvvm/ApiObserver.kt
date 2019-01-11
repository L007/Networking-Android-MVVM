package id.onestep.networkingandroidmvvm

import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class ApiObserver<T> constructor(private val compositeDisposeable:CompositeDisposable):Observer<T> {
    override fun onComplete() {

    }

    override fun onSubscribe(d: Disposable) {
        compositeDisposeable.add(d)
    }

    override fun onNext(t: T) {
        onApiSuccess(t)
    }

    override fun onError(e: Throwable) {
    onApiFailure(e)
    }
    abstract fun onApiSuccess(data : T)
    abstract fun onApiFailure(er : Throwable)
}