package co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.screens.ContactDataActivity
import co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.screens.ShowDataActivity
import co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.screens.UserInput

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val context = LocalContext.current
    val configuration = LocalConfiguration.current
    NavHost(navController = navController, startDestination = AppScreens.PersonalDataActivity.route){
        composable(route = AppScreens.PersonalDataActivity.route){
            UserInput(context, navController)
        }
        composable(route= AppScreens.ContactDataActivity.route){
            ContactDataActivity(context, navController)
        }
        composable(route= AppScreens.ShowDataActivity.route){
            ShowDataActivity(navController)
        }
    }
}