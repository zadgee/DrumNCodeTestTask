package data.localDataSource.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import domain.entities.DetailedPhotoInfoModel


private val gson = Gson()

class DetailedPhotoInfoModelConverter {

    @TypeConverter
    fun detailedPhotoInfoModelToJson(
        detailedPhotoInfoModel : DetailedPhotoInfoModel
    ):String{
        return gson.toJson(detailedPhotoInfoModel)
    }

    @TypeConverter
    fun detailedPhotoInfoModelFromJson(
        json:String
    ): DetailedPhotoInfoModel {
        return gson.fromJson(json, DetailedPhotoInfoModel::class.java)
    }

}