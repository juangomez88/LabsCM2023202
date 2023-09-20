package co.edu.udea.compumovil.gr02_202302.labscm2023202

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.EditCalendar
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Group
import androidx.compose.material.icons.rounded.Man
import androidx.compose.material.icons.rounded.Wc
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
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
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
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

    var selectedGender by remember { mutableStateOf("") }

    Column {

        Text(
            text = stringResource(R.string.informacion_personal),
            fontWeight = FontWeight.Black,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray)
                .padding(20.dp)
        )

        Spacer(
            modifier = Modifier
                .height(16.dp)
        )

        Row {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                modifier = Modifier.padding(top = 20.dp, start = 5.dp)
            )
            ComponentName()
        }

        Spacer(
            modifier = Modifier
                .height(16.dp)
        )

        Row {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                modifier = Modifier.padding(top = 20.dp, start = 5.dp)
            )
            ComponentLastName()
        }

        Spacer(
            modifier = Modifier
                .height(16.dp)
        )

        Text(text = stringResource(R.string.genero))
        GenderSelection(
            selectedGender = selectedGender,
            onGenderSelected = { gender -> selectedGender = gender })

        Spacer(
            modifier = Modifier
                .height(16.dp)
        )

        Row {
            Icon(
                imageVector = Icons.Default.EditCalendar,
                contentDescription = null, modifier = Modifier.padding(horizontal = 3.dp)
            )
            Text(stringResource(R.string.fecha_de_nacimiento))
        }

        MyDatePicker()

        Spacer(
            modifier = Modifier
                .height(16.dp)
        )

        Row {
            Icon(
                imageVector = Icons.Default.School,
                contentDescription = null,
                modifier = Modifier.padding(horizontal = 3.dp)
            )

            Text(text = stringResource(R.string.grado_de_escolaridad))
        }

        mySpinner()

        Spacer(
            modifier = Modifier
                .height(16.dp)
        )

        ButtonComponent()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentName() {
    var firstName by remember { mutableStateOf("") }
    Modifier.padding(12.dp)
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.BottomStart,
    ) {
        TextField(
            value = firstName,
            onValueChange = { firstName = it },
            label = { Text(stringResource(R.string.nombre)) },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        )
        Divider(
            thickness = 2.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp)
                .padding(start = 2.dp, end = 2.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentLastName() {
    var lastName by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.BottomStart
    ) {
        TextField(
            value = lastName,
            onValueChange = { lastName = it },
            label = { Text(stringResource(R.string.apellido)) },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent)
        )
        Divider(
            thickness = 2.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp)
        )
    }
}

@Composable
fun GenderSelection(selectedGender: String, onGenderSelected: (String) -> Unit) {
    Row {

        Icon(
            imageVector = Icons.Rounded.Wc,
            contentDescription = null,
            modifier = Modifier.padding(horizontal = 8.dp)
        )

        RadioButton(
            selected = selectedGender == stringResource(R.string.hombre),
            onClick = { onGenderSelected("Hombre") }
        )
        Text("Hombre")

        RadioButton(
            selected = selectedGender == stringResource(R.string.mujer),
            onClick = { onGenderSelected("Mujer") }
        )
        Text(stringResource(R.string.mujer))
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
                label = { Text(text = stringResource(R.string.selecione_una_fecha)) }
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun mySpinner() {
    var mExpanded by remember { mutableStateOf(false) }

    val mLevels = listOf(
        stringResource(R.string.primaria),
        stringResource(R.string.secundaria), stringResource(R.string.universidad),
        stringResource(R.string.otros)
    )

    var mSelectedText by remember { mutableStateOf("") }

    var mTextFieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (mExpanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Column(Modifier.padding(20.dp)) {

        OutlinedTextField(
            value = mSelectedText,
            onValueChange = { mSelectedText = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    mTextFieldSize = coordinates.size.toSize()
                },
            label = { Text(stringResource(R.string.grado_de_escolaridad)) },
            trailingIcon = {
                Icon(icon, "contentDescription",
                    Modifier.clickable { mExpanded = !mExpanded })
            }
        )

        DropdownMenu(
            expanded = mExpanded,
            onDismissRequest = { mExpanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { mTextFieldSize.width.toDp() })
        ) {
            mLevels.forEach { label ->
                DropdownMenuItem({ Text(text = label) }, onClick = {
                    mSelectedText = label
                    mExpanded = false
                })
            }

        }
    }
}

@Composable
fun ButtonComponent() {

    Box(
        contentAlignment = Alignment.BottomEnd,
        modifier = Modifier.fillMaxWidth()

    ) {


        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(Color.Gray)
        ) {
            Text(text = stringResource(R.string.siguiente))
        }
    }

}