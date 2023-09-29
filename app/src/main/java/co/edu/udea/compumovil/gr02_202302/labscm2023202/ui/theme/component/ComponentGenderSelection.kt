package co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Wc
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import co.edu.udea.compumovil.gr02_202302.labscm2023202.R

@Composable
fun ComponentGenderSelection(selectedGender: String, onGenderSelected: (String) -> Unit) {
    Row {

        Icon(
            imageVector = Icons.Rounded.Wc,
            contentDescription = null,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        RadioButton(
            selected = selectedGender == stringResource(R.string.hombre),
            onClick = { onGenderSelected("Male") }
        )
        Text(stringResource(R.string.hombre))

        RadioButton(
            selected = selectedGender == stringResource(R.string.mujer),
            onClick = { onGenderSelected("Female") }
        )
        Text(stringResource(R.string.mujer))
    }

}
