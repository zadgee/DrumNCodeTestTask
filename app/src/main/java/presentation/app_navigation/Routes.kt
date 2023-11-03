package presentation.app_navigation

sealed class Routes(val route:String){
    object LoadingScreen:Routes("loading_screen")
    object MainScreen:Routes("main_screen")
    object DetailsScreen:Routes("details_screen/{serverId}/{photoId}/{secret}")
}
