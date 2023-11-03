package domain.usecases

import data.event.RetrieveRecentPhotosInfoEvent
import data.remoteDataSource.repository.RecentPhotosInternetRepository
import javax.inject.Inject

class RetrieveRecentPhotosInfoUseCase @Inject constructor(
    private val repository: RecentPhotosInternetRepository
){

   suspend fun getPhotosInfo(): RetrieveRecentPhotosInfoEvent {
       return repository.getAllPhotosFromInternet()
   }
}