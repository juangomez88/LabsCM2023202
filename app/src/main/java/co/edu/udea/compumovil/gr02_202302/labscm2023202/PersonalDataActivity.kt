package co.edu.udea.compumovil.gr02_202302.labscm2023202

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EditCalendar
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.component.ComponentButton
import co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.component.ComponentDatePicker
import co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.component.ComponentGenderSelection
import co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.component.ComponentInput
import co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.component.ComponentSpinner

@Composable
@Preview
fun UserInput() {

    var selectedGender by remember { mutableStateOf("") }

    Column {

        Text(
            text = stringResource(R.string.informacion_personal),
            fontWeight = FontWeight.Black,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray)
                .padding(50.dp)
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
            var name by remember { mutableStateOf("") }
            ComponentInput(
                value = name,
                onValueChange = { name = it },
                label = stringResource(R.string.nombre),
            )
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
            var lastName by remember { mutableStateOf("") }
            ComponentInput(
                value = lastName,
                onValueChange = { lastName = it },
                label = stringResource(R.string.apellido),
            )
        }

        Spacer(
            modifier = Modifier
                .height(16.dp)
                .padding(100.dp)
        )
        Row {
            Text(text = stringResource(R.string.genero))
            ComponentGenderSelection(
                selectedGender = selectedGender,
                onGenderSelected = { gender -> selectedGender = gender })
        }
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

        ComponentDatePicker()

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

        ComponentSpinner()

        Spacer(
            modifier = Modifier
                .height(16.dp)
        )

        ComponentButton()
    }
}






