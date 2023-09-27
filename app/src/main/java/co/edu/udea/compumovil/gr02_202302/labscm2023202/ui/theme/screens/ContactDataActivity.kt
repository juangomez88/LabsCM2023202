package co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.screens

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationCity
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import co.edu.udea.compumovil.gr02_202302.labscm2023202.R
import co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.LabsCM2023202Theme
import co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.component.ComponentButtonContact
import co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.component.ComponentInput

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactDataActivity(navController: NavHostController) {
    Scaffold (topBar = {
        ContactDataBar(
            currentScreen = ScreenContact.Contact,
            canNavigateBack = navController.previousBackStackEntry != null,
            navigateUp = { navController.navigateUp() })
    }){
        ContactDataActivityPreview(navController)
    }
}
val sharedViewModel = SharedUserViewModel()
var phone by mutableStateOf(TextFieldValue(""))
var email by mutableStateOf(TextFieldValue(""))
var address by mutableStateOf(TextFieldValue(""))
var country  by mutableStateOf(TextFieldValue(""))
var city by mutableStateOf(TextFieldValue(""))
//val cities = MutableLiveData<CitiesResponse>()

@RequiresApi(Build.VERSION_CODES.M)
@Composable
fun BodyContentContactData(navController: NavHostController, context: Context) {
    var selectedGender by remember { mutableStateOf("") }
    val userData = UserData()
    Column {

        Spacer(
            modifier = Modifier
                .height(65.dp)
        )

        Row {
            Icon(
                imageVector = Icons.Default.Phone,
                contentDescription = null,
                modifier = Modifier.padding(top = 20.dp, start = 5.dp)
            )

            //var phone by remember { mutableStateOf("") }
            ComponentInput(
                value = phone,
                onValueChange = { phone = it },
                label = stringResource(R.string.telefono),
            )
        }
        Spacer(
            modifier = Modifier
                .height(16.dp)
        )

        Row {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = null,
                modifier = Modifier.padding(top = 20.dp, start = 5.dp)
            )
            //var address by remember { mutableStateOf("") }
            ComponentInput(
                value = address,
                onValueChange = { address = it },
                label = stringResource(R.string.direccion),
            )
        }

        Spacer(
            modifier = Modifier
                .height(16.dp)
        )
        Row {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = null,
                modifier = Modifier.padding(top = 20.dp, start = 5.dp)
            )

            //var email by remember { mutableStateOf("") }
            ComponentInput(
                value = email,
                onValueChange = { email = it },
                label = stringResource(R.string.Email),
            )
        }

        Spacer(
            modifier = Modifier
                .height(16.dp)
        )

        Row {
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = null,
                modifier = Modifier.padding(top = 20.dp, start = 5.dp)
            )

            //var country by remember { mutableStateOf("") }
            ComponentInput(
                value = country,
                onValueChange = { country = it },
                label = stringResource(R.string.Pais),
            )
        }

        Spacer(
            modifier = Modifier
                .height(16.dp)
        )

        Row {
            Icon(
                imageVector = Icons.Default.LocationCity,
                contentDescription = null,
                modifier = Modifier.padding(top = 20.dp, start = 5.dp)
            )
            //var city by remember { mutableStateOf("") }
            ComponentInput(
                value = city,
                onValueChange = { city = it },
                label = stringResource(R.string.Ciudad),
            )
        }
        Spacer(
            modifier = Modifier
                .height(16.dp)
        )
        ComponentButtonContact(navController)

    }
}

@RequiresApi(Build.VERSION_CODES.M)
@Composable
fun ContactDataActivityPreview(navController: NavHostController) {
    val context = LocalContext.current
    LabsCM2023202Theme {
        val context = LocalContext.current
        val contactDataFormTitle = context.getString(R.string.informacion_contacto);
        BodyContentContactData(navController, context);
    }
}