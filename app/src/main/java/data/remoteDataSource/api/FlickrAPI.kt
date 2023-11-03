package data.remoteDataSource.api
import domain.entities.DetailedPhotoInfo
import domain.entities.RecentPhotoIdListModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrAPI {
    @GET("?method=flickr.interestingness.getList&api_key=531d11b4153d70488de3e69321772c9d&format=json&nojsoncallback=1")
    suspend fun getPhotosInfo():Response<RecentPhotoIdListModel>

    @GET("?method=flickr.photos.getInfo&api_key=531d11b4153d70488de3e69321772c9d&format=json&nojsoncallback=1")
    suspend fun getPhotoDetails(@Query("photo_id") photoId:String?):Response<DetailedPhotoInfo>
}