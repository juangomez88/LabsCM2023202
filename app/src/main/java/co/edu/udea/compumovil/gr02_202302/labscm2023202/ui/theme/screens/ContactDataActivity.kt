package co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.screens

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Configuration
import android.util.Log
import android.widget.Toast
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavHostController
import co.edu.udea.compumovil.gr02_202302.labscm2023202.R
import co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.screens.orientation.ConctactDataFormLandScape
import co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.screens.orientation.ConctactDataFormPortrait

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactDataActivity(context: Context, navController: NavHostController) {
    Scaffold (topBar = {
        ContactDataBar(
            currentScreen = ScreenContact.Contact,
            canNavigateBack = navController.previousBackStackEntry != null,
            navigateUp = { navController.navigateUp() })
    })
    {
        val configuration = LocalConfiguration.current
        when (configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> {
                ConctactDataFormPortrait(navController, context = context)
            } else -> {
                ConctactDataFormLandScape(navController, context = context)
            }
        }

    }
}
val sharedViewModel = SharedUserViewModel()
var phone       by mutableStateOf(TextFieldValue(""))
var email       by mutableStateOf(TextFieldValue(""))
var address     by mutableStateOf(TextFieldValue(""))
var country     by mutableStateOf(TextFieldValue(""))
var city        by mutableStateOf(TextFieldValue(""))
//val cities = MutableLiveData<CitiesResponse>()


fun contactDataFormNextButtonOnClick(context: Context) {
    if (isContactDataValid(context)) {
        logcatAllContactData()
        val toastMessage = context.getString(R.string.contact_data_form_finished_toast_message)
        Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show()
    }
}
fun isContactDataValid(context: Context): Boolean {
    val toastMessage = StringBuilder()
    if (!phoneIsValid()) {
        toastMessage.append(context.getString(R.string.phone_invalid))
        toastMessage.append(". ")
    }
    if (!emailIsValid()) {
        toastMessage.append(context.getString(R.string.email_invalid))
        toastMessage.append(". ")
    }

    if (!countryIsValid()) {
        toastMessage.append(context.getString(R.string.country_invalid))
        toastMessage.append(". ")
    }

    if (!cityIsValid()) {
        toastMessage.append(context.getString(R.string.city_invalid))
        toastMessage.append(". ")
    }

    if (toastMessage.isNotEmpty()) {
        Toast.makeText(context, toastMessage.toString(), Toast.LENGTH_SHORT).show()
        return false
    }
    return true
}

fun cityIsValid(): Boolean {
    if (countryIsValid()) {
        if (city.text.isNotEmpty()) {
            return city.text.length == 10
        }
    }
    return true
}

fun countryIsValid(): Boolean {
    if (country.text.isNotEmpty()) {
        return country.text.length == 10
    }
    return false
}

fun emailIsValid(): Boolean {
    if (email.text.isNotEmpty()) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email.text).matches()
    }
    return false
}

fun phoneIsValid(): Boolean{
    if (phone.text.isNotEmpty()) {
        return phone.text.length == 10
    }
    return false
}
fun logcatAllContactData() {
    val logAllDataMessage = StringBuilder()
    logAllDataMessage.append("Información de contacto: \n")
    logAllDataMessage.append("Teléfono: ${phone.text} \n")
    logAllDataMessage.append("Email: ${email.text} \n")
    logAllDataMessage.append("País: ${country.text} \n")
    if (address.text.isNotEmpty()) {
        logAllDataMessage.append("Dirección: ${address.text} \n")
    }
    if (city.text.isNotEmpty()) {
        logAllDataMessage.append("Cuidad: ${city.text} \n")
    }
    Log.i("PersonalDataActivity", logAllDataMessage.toString())
}


