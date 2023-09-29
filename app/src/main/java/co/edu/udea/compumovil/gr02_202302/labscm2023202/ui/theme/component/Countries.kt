package co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import co.edu.udea.compumovil.gr02_202302.labscm2023202.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentCountries() {
    var pExpanded by remember { mutableStateOf(false) }

    val pLevels = listOf<String>(
        "EEUU",
        "Canadá",
        "México",
        "Panamá",
        "Costa Rica",
        "Guatemala",
        "Colombia",
        "Ecuador",
        "Venezuela",
        "Perú",
        "Bolivia",
        "Chile",
        "Urugay",
        "Paraguay",
        "Argentina",
        "Brasil"
    )

    var pSelectedText by remember { mutableStateOf("") }
    var pTextFieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (pExpanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Column(Modifier.padding(20.dp)) {

        OutlinedTextField(
            value = pSelectedText,
            onValueChange = { pSelectedText = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    pTextFieldSize = coordinates.size.toSize()
                },
            label = { Text(stringResource(R.string.selecione_su_pais)) },
            trailingIcon = {
                Icon(icon, "contentDescription",
                    Modifier.clickable { pExpanded = !pExpanded })
            }
        )

        DropdownMenu(
            expanded = pExpanded,
            onDismissRequest = {pExpanded = false},
            modifier = Modifier
                .width(with(LocalDensity.current) { pTextFieldSize.width.toDp() })
        ){
            pLevels.forEach { label ->
                DropdownMenuItem(text = { Text(text = label) }, onClick = {
                    pSelectedText = label
                    pExpanded = false
                })
            }
        }


    }
}