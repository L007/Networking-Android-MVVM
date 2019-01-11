package id.onestep.networkingandroidmvvm.networks

import id.onestep.networkingandroidmvvm.models.ResultsItem
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface RestApi {
    @GET("{category}?api_key=a0ce48ec5a738cc34efa144078641018")
    fun getMovie(@Path("category") category:String):Observable<ResultsItem>

}