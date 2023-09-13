package co.edu.udea.compumovil.gr02_202302.labscm2023202

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.LabsCM2023202Theme
import java.util.Calendar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LabsCM2023202Theme {
                UserInput()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun UserInput() {
    var firtsName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("") }
    var fechaNacimiento by remember { mutableStateOf("") }

    Column {
        TextField(
            value = firtsName,
            onValueChange = { firtsName = it },
            label = { Text("Nombre") },
            leadingIcon = {
                Icon(Icons.Default.Person, contentDescription = "null")
            }
        )

        TextField(value = lastName,
            onValueChange = { lastName = it },
            label = { Text("Apellido") },
            leadingIcon = {
                Icon(Icons.Default.Person, contentDescription = null)
            }
        )

        Spacer(
            modifier = Modifier
                .height(16.dp)
        )

        Text(text = "Género")
        GenderSelection(
            selectedGender = selectedGender,
            onGenderSelected = { gender -> selectedGender = gender })

        Spacer(
            modifier = Modifier
                .height(16.dp)
        )

        Text("Fecha de nacimiento")
        MyDatePicker()
    }
}

@Composable
fun GenderSelection(selectedGender: String, onGenderSelected: (String) -> Unit) {
    Row {

        Icon(
            imageVector = Icons.Rounded.AccountCircle, contentDescription = null
        )

        RadioButton(
            selected = selectedGender == "Hombre",
            onClick = { onGenderSelected("Hombre") }
        )
        Text("Hombre")

        RadioButton(
            selected = selectedGender == "Mujer",
            onClick = { onGenderSelected("Mujer") }
        )
        Text("Mujer")
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDatePicker() {
    var fecha: String by rememberSaveable { mutableStateOf("") }
    val anio: Int
    val mes: Int
    val dia: Int
    val mCalendar: Calendar = Calendar.getInstance()
    anio = mCalendar.get(Calendar.YEAR)
    mes = mCalendar.get(Calendar.MONTH)
    dia = mCalendar.get(Calendar.DAY_OF_MONTH)

    val mDatePickerDialog = DatePickerDialog(
        LocalContext.current,
        { _, anio: Int, mes: Int, dia: Int ->
            fecha = "$dia/${mes + 1}/$anio"
        }, anio, mes, dia
    )
    Box(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            OutlinedTextField(
                value = fecha,
                onValueChange = { fecha = it },
                readOnly = true,
                label = { Text(text = "Select Date") }
            )
            Icon(
                imageVector = Icons.Filled.DateRange,
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .padding(4.dp)
                    .clickable {
                        mDatePickerDialog.show()
                    }
            )
        }
    }

}
