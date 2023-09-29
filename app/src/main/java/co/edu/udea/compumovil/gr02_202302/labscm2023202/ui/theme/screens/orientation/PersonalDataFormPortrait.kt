package co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.screens.orientation

import android.content.Context
import android.content.res.Configuration
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import co.edu.udea.compumovil.gr02_202302.labscm2023202.R
import co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.component.ComponentButtonData
import co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.component.ComponentDatePicker
import co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.component.ComponentGenderSelection
import co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.component.ComponentInput
import co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.component.ComponentSpinner
import co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.component.keyboardName
import co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.screens.UserData
import co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.screens.name
import co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.screens.personalDataFormNextButtonOnClick
import co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.screens.surname


@Composable
fun PersonalDataFormPortrait(context: Context, navController: NavHostController) {
    var selectedGender by remember { mutableStateOf("") }

    val screenOrientation = LocalConfiguration.current.orientation
    val columnModifier = Modifier
        .fillMaxSize()
        .padding(16.dp)

    LazyColumn(
        modifier = columnModifier
    ) {
        val userData = UserData()

        item {
            Spacer(modifier = Modifier.height(45.dp))
        }
// Item: name
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 20.dp, start = 5.dp)
                        .size(if (screenOrientation == Configuration.ORIENTATION_LANDSCAPE) 20.dp else 35.dp)
                )
                ComponentInput(
                    value = name,
                    onValueChange = { name = it },
                    label = stringResource(R.string.nombre),
                    keyboardOptions = keyboardName,
                    //textStyle = TextStyle(fontSize = if (screenOrientation == Configuration.ORIENTATION_LANDSCAPE) 16.sp else 24.sp)
                )
            }
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 20.dp, start = 5.dp)
                        .size(if (screenOrientation == Configuration.ORIENTATION_LANDSCAPE) 20.dp else 35.dp)
                )
                ComponentInput(
                    value = surname,
                    onValueChange = { surname = it },
                    label = stringResource(R.string.apellido),
                    keyboardOptions = keyboardName,
                    //textStyle = TextStyle(fontSize = if (screenOrientation == Configuration.ORIENTATION_LANDSCAPE) 16.sp else 24.sp)
                )

            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Text(
                    text = stringResource(R.string.genero),
                    fontSize = if (screenOrientation == Configuration.ORIENTATION_LANDSCAPE) 16.sp else 24.sp
                )
                ComponentGenderSelection(
                    selectedGender = selectedGender,
                    onGenderSelected = { gender -> selectedGender = gender }
                )
                userData.gender = selectedGender
            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {

                Text(
                    text = stringResource(R.string.fecha_de_nacimiento),
                    fontSize = if (screenOrientation == Configuration.ORIENTATION_LANDSCAPE) 16.sp else 24.sp
                )
            }
        }


        item {
            ComponentDatePicker()
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        //Item ComponentSpinner
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.School,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(horizontal = 3.dp)
                        .size(if (screenOrientation == Configuration.ORIENTATION_LANDSCAPE) 20.dp else 35.dp)
                )

                Text(
                    text = stringResource(R.string.grado_de_escolaridad),
                    fontSize = if (screenOrientation == Configuration.ORIENTATION_LANDSCAPE) 16.sp else 24.sp
                )
            }
        }

        item {
            val education= ComponentSpinner()
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            ComponentButtonData(
                context =  context,
                onClickFunction = { personalDataFormNextButtonOnClick(context) },
                navController
            )
        }
    }
}