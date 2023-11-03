package data.remoteDataSource.model

import com.google.gson.annotations.SerializedName

data class DetailedPhotoInfo(
    val photo:DetailedPhotoInfoModel
)
data class DetailedPhotoInfoModel(
    @SerializedName("secret")
    val secret:String,
    @SerializedName("owner")
    val ownerModel:OwnerModel,
    @SerializedName("title")
    val titleModel:TitleModel
)

data class TitleModel(
    @SerializedName("_content")
    val title:String
)

data class OwnerModel(
    val username:String,
    @SerializedName("realname")
    val realName:String
)