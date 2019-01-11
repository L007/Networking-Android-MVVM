package id.onestep.networkingandroidmvvm.viewmodels

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import id.onestep.networkingandroidmvvm.models.ResultsItem

class ListMovieViewModel(model:ResultsItem ):ViewModel() {

    var title : ObservableField<String> = ObservableField()
    var popularity:ObservableField<Double> = ObservableField()
    var image : ObservableField<String> = ObservableField()
    var overview : ObservableField<String> = ObservableField()

    init {
        title.set(model.title)
        popularity.set(model.popularity)
        image.set("https://image.tmdb.org/t/p/w370_and_h556_bestv2${model.posterPath}")
        overview.set(model.overview)
    }
}