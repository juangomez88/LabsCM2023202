package com.example.lab01cm.ui.theme.component

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
fun ComponentCities() {
    var cExpanded by remember { mutableStateOf(false) }

    val cLeveles = listOf(
        "Aguachica",
        "Apartado",
        "Arauca",
        "Armenia",
        "Barrancabermeja",
        "Barranquilla",
        "Bello",
        "Bogotá D.C.",
        "Bucaramanga",
        "Buenaventura",
        "Buga",
        "Cali",
        "Cartago",
        "Cartagena",
        "Caucasia",
        "Cerete",
        "Chia",
        "Cienaga",
        "Cúcuta",
        "Dosquebradas",
        "Duitama",
        "Envigado",
        "Facatativa",
        "Florencia",
        "Floridablanca",
        "Fusagasugá",
        "Girardot",
        "Girón",
        "Ibagué",
        "Ipiales",
        "Itagüí",
        "Jamundí",
        "Lorica",
        "Los Patios",
        "Magangué",
        "Maicao",
        "Malambo",
        "Manizales",
        "Medellín",
        "Melgar",
        "Montería",
        "Neiva",
        "Ocaña",
        "Paipa",
        "Palmira",
        "Pamplona",
        "Pasto",
        "Pereira",
        "Piedecuesta",
        "Pitalito",
        "Popayán",
        "Quibdó",
        "Riohacha",
        "Rionegro",
        "Sabanalarga",
        "Sahagun",
        "Santa Marta",
        "Sincelejo",
        "Soacha",
        "Sogamoso",
        "Soledad",
        "Tibú",
        "Tuluá",
        "Tumaco",
        "Tunja",
        "Turbo",
        "Valledupar",
        "Villa de Leyva",
        "Villa del Rosario",
        "Villavicencio",
        "Yopal",
        "Zipaquirá"
    )

    var cSelectedText by remember { mutableStateOf("") }
    var cTextFieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (cExpanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Column(Modifier.padding(20.dp)) {

        OutlinedTextField(
            value = cSelectedText,
            onValueChange = { cSelectedText = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    cTextFieldSize = coordinates.size.toSize()
                },
            label = { Text(stringResource(R.string.selecione_su_cuidad)) },
            trailingIcon = {
                Icon(icon, "contentDescription",
                     Modifier.clickable { cExpanded = !cExpanded })
            }
        )

        DropdownMenu(
            expanded = cExpanded,
            onDismissRequest = {cExpanded = false},
            modifier = Modifier
                .width(with(LocalDensity.current) { cTextFieldSize.width.toDp() })
        ){
            cLeveles.forEach { label ->
                DropdownMenuItem(text = { Text(text = label) }, onClick = {
                    cSelectedText = label
                    cExpanded = false
                })
            }
        }


    }

}
