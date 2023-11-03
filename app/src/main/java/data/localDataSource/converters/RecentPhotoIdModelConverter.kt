package data.localDataSource.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import data.remoteDataSource.model.RecentPhotoIdModel


private val gson = Gson()


class RecentPhotoIdModelConverter {
    @TypeConverter
    fun recentPhotoIdModelToJson(
        recentPhotoIdModel: RecentPhotoIdModel
    ):String{
        return gson.toJson(recentPhotoIdModel)
    }

    @TypeConverter
    fun recentPhotoIdModelFromJson(
        json:String
    ):RecentPhotoIdModel{
        return gson.fromJson(json, RecentPhotoIdModel::class.java)
    }
}