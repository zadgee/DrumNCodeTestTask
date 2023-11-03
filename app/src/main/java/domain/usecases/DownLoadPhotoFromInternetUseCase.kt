package domain.usecases

object DownLoadPhotoFromInternetUseCase{
     fun downloadPhotoFromInternet(
        serverId:String,
        photoId:String,
        secret:String
    ):String{
      return "https://live.staticflickr.com/$serverId/${photoId}_${secret}_w.jpg"
    }
}