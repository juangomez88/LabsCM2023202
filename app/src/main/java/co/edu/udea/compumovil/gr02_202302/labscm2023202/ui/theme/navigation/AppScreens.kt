package co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.navigation

sealed class AppScreens(val route: String) {
    object PersonalDataActivity: AppScreens("personal_data")
    object ContactDataActivity: AppScreens("contact_data")
    object ShowDataActivity: AppScreens("show_data")
}