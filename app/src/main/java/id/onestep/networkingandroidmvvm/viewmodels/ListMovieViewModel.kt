package id.onestep.networkingandroidmvvm.viewmodels

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import id.onestep.networkingandroidmvvm.models.ResultsItem


class ListMovieViewModel(model: ResultsItem?):ViewModel() {

    var title : ObservableField<String> = ObservableField()
    var popularity:ObservableField<String> = ObservableField()
    var imgMovie : ObservableField<String> = ObservableField()
    var overview : ObservableField<String> = ObservableField()
    var tahunRilis : ObservableField<String> = ObservableField()
    var rbPopularity : ObservableField<Float> = ObservableField()

    init {
        title.set(model?.title)
        popularity.set("Rating : ${model?.voteAverage.toString()}")
        imgMovie.set("https://image.tmdb.org/t/p/w370_and_h556_bestv2${model?.posterPath}")
        overview.set(model?.overview)
        tahunRilis.set(model?.releaseDate)
        rbPopularity.set((model?.voteAverage?.toFloat()!! /2f))

    }
}