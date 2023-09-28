package co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.screens

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import co.edu.udea.compumovil.gr02_202302.labscm2023202.R
import co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.component.ComponentButtonContact
import co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.component.ComponentCountries
import co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.component.ComponentInput
import com.example.lab01cm.ui.theme.component.ComponentCities

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactDataActivity(navController: NavHostController) {
    Scaffold(topBar = {
        ContactDataBar(
            currentScreen = ScreenContact.Contact,
            canNavigateBack = navController.previousBackStackEntry != null,
            navigateUp = { navController.navigateUp() })
    }) {
        BodyContentContactData(navController)
    }
}

@Composable
fun BodyContentContactData(navController: NavHostController) {

    val screenOrientation = LocalConfiguration.current.orientation
    val countries = mutableSetOf<String>()
    val context = LocalContext.current

    LazyColumn {
        item {
            Spacer(
                modifier = Modifier
                    .height(65.dp)
            )
        }
        item {
            Row {
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 20.dp, start = 5.dp)
                        .size(if (screenOrientation == Configuration.ORIENTATION_LANDSCAPE) 20.dp else 30.dp)
                )

                var phone by remember { mutableStateOf("") }
                ComponentInput(
                    value = phone,
                    onValueChange = { phone = it },
                    label = stringResource(R.string.telefono),
                )
            }
        }
        item {
            Spacer(
                modifier = Modifier
                    .height(16.dp)
            )
        }
        item {
            Row {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 20.dp, start = 5.dp)
                        .size(if (screenOrientation == Configuration.ORIENTATION_LANDSCAPE) 20.dp else 30.dp)
                )
                var address by remember { mutableStateOf("") }
                ComponentInput(
                    value = address,
                    onValueChange = { address = it },
                    label = stringResource(R.string.direccion),
                )
            }
        }

        item {
            Spacer(
                modifier = Modifier
                    .height(16.dp)
            )
        }

        item {
            Row {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 20.dp, start = 5.dp)
                        .size(if (screenOrientation == Configuration.ORIENTATION_LANDSCAPE) 20.dp else 30.dp)
                )

                var email by remember { mutableStateOf("") }
                ComponentInput(
                    value = email,
                    onValueChange = { email = it },
                    label = stringResource(R.string.Email),
                )
            }
        }

        item {
            Spacer(
                modifier = Modifier
                    .height(16.dp)
            )
        }

        item {
            Row {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 20.dp, start = 5.dp)
                        .size(if (screenOrientation == Configuration.ORIENTATION_LANDSCAPE) 20.dp else 30.dp)
                )

                var country by remember { mutableStateOf("") }
                ComponentCountries()
/*                ComponentInput(
                    value = country,
                    onValueChange = { country = it },
                    label = stringResource(R.string.Pais),
                )*/

            }
        }



        item {
            Spacer(
                modifier = Modifier
                    .height(16.dp)
            )
        }

        item {
            Row {
                Icon(
                    imageVector = Icons.Default.LocationCity,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 20.dp, start = 5.dp)
                        .size(if (screenOrientation == Configuration.ORIENTATION_LANDSCAPE) 20.dp else 30.dp)
                )
                var city by remember { mutableStateOf("") }

                ComponentCities()
/*                ComponentInput(
                    value = city,
                    onValueChange = { city = it },
                    label = stringResource(R.string.Ciudad),
                )*/
            }
        }
        item {
            Spacer(
                modifier = Modifier
                    .height(16.dp)
            )
        }
        item {
            ComponentButtonContact()
        }
    }
}