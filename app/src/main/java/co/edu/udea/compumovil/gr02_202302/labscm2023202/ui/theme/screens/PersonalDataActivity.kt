package co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.screens

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Configuration
import android.util.Log
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavHostController
import co.edu.udea.compumovil.gr02_202302.labscm2023202.R
import co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.LabsCM2023202Theme
import co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.screens.orientation.PersonalDataFormLandscape
import co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.screens.orientation.PersonalDataFormPortrait


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactDataBar(
    currentScreen: ScreenContact,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {

    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBackIosNew,
                        contentDescription = stringResource(R.string.atras)
                    )
                }
            }
        }
    )
}

var name by mutableStateOf(TextFieldValue(""))
var surname by mutableStateOf(TextFieldValue(""))
var selectedSexOption = mutableStateOf("")
var birthDate = mutableStateOf("")
var selectedSchoolGradeOption by mutableStateOf("")


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun UserInput(context: Context, navController: NavHostController) {
    Scaffold(
        topBar = {
            ContactDataBar(
                currentScreen   = ScreenContact.Start,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp      = { navController.navigateUp() })
        }
    ) {
        val configuration = LocalConfiguration.current
        when (configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> {
                PersonalDataFormPortrait(context, navController)
            } else -> {
                PersonalDataFormLandscape(context, navController)
            }
        }

    }

}


fun trimNameAndSurname() {
    name = name.copy(text = name.text.trim())
    surname = surname.copy(text = surname.text.trim())
}

enum class ScreenContact(@StringRes val title: Int) {
    Start(title = R.string.informacion_personal),
    Contact(title = R.string.informacion_contacto),
}

fun personalDataFormNextButtonOnClick(context: Context) {
    if (isDataValid(context)) {
        trimNameAndSurname()
        logcatAllData()
    }
}

fun logcatAllData() {
    val logAllDataMessage = StringBuilder()
    logAllDataMessage.append("Información personal: \n")
    logAllDataMessage.append("Nombre completo: ${name.text} ${surname.text} \n")
    logAllDataMessage.append("Fecha de nacimiento: ${birthDate.value} \n")
    if (selectedSexOption.value.isNotEmpty()) {
        logAllDataMessage.append("Sexo: ${selectedSexOption.value} \n")
    }
    if (selectedSchoolGradeOption.isNotEmpty()) {
        logAllDataMessage.append("Grado escolaridad: $selectedSchoolGradeOption \n")
    }
    Log.i("PersonalDataActivity", logAllDataMessage.toString())
}

fun isDataValid(context: Context) : Boolean {
    val toastMessage = StringBuilder()
    if (!nameIsValid()) {
        toastMessage.append(context.getString(R.string.invalid_name_toast_message))
        toastMessage.append(". ")
    }
    if (!surnameIsValid()) {
        toastMessage.append(context.getString(R.string.invalid_surname_toast_message))
        toastMessage.append(". ")
    }
    if (toastMessage.isNotEmpty()) {
        Toast.makeText(context, toastMessage.toString(), Toast.LENGTH_SHORT).show()
        return false
    }
    return true
}

fun nameIsValid(): Boolean{
    if (name.text.isNotEmpty()) {
        return name.text.contains(Regex("[a-zA-Z]"))
    }
    return false
}

fun surnameIsValid(): Boolean {
    if (surname.text.isNotEmpty()) {
        return surname.text.contains(Regex("[a-zA-Z]"))
    }
    return false
}


@Composable
fun GreetingPreview2(navController: NavHostController) {
    val context = LocalContext.current
    LabsCM2023202Theme {
        PersonalDataFormPortrait(context, navController)
    }
}

