package data.remoteDataSource.model

import com.google.gson.annotations.SerializedName

data class RecentPhotoIdListModel(
    @SerializedName("photos")
    val photos:RecentPhotoIdModel
)

data class RecentPhotoIdModel(
    @SerializedName("photo")
    val photo:ArrayList<IdList>
)

data class IdList(
    @SerializedName("title")
    val title:String,
    @SerializedName("id")
    val photoId:String,
    @SerializedName("secret")
    val secret:String,
    @SerializedName("server")
    val serverId:String
)