package co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.component

import android.app.DatePickerDialog
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.EditCalendar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import co.edu.udea.compumovil.gr02_202302.labscm2023202.R
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentDatePicker() {
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

        Icon(
            imageVector = Icons.Filled.EditCalendar,
            contentDescription = null,
            modifier = Modifier
                .size(35.dp)
                .padding(4.dp)
                .clickable {
                    mDatePickerDialog.show()
                }
        )
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)

        ) {
            OutlinedTextField(
                value = fecha,
                onValueChange = { fecha = it },
                readOnly = true,
                label = { Text(text = stringResource(R.string.selecione_una_fecha)) },
                modifier = Modifier.padding(start = 30.dp)
            )

        }
    }

}
