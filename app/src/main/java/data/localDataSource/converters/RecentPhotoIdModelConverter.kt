package data.localDataSource.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import domain.entities.RecentPhotoIdModel


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
    ): RecentPhotoIdModel {
        return gson.fromJson(json, RecentPhotoIdModel::class.java)
    }
}