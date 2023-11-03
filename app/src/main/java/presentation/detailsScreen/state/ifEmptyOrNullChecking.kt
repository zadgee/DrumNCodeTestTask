package presentation.detailsScreen.state

import domain.entities.RecentPhotoIdModel


object EmptyOrNullChecking{
    fun realName(
        realName:String
    ):String{
        if(realName.isEmpty()){
            return "Real name not found"
        }
        return realName
    }

    fun title(
        title:String
    ):String{
        if(title.isEmpty()){
            return "Title not found"
        }
        return title
    }

    fun userName(
        userName:String
    ):String{
        if(userName.isEmpty()){
            return "User name not found"
        }
        return userName
    }

    fun recentPhotoIdModel(): RecentPhotoIdModel {
      return  RecentPhotoIdModel(
            photo = arrayListOf()
        )
    }
}