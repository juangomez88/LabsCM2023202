package co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.component

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import co.edu.udea.compumovil.gr02_202302.labscm2023202.R
import co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.navigation.AppScreens

@Composable
fun ComponentButtonData(
    context: Context,
    onClickFunction: () -> Unit,
    navHostController: NavHostController
) {
    Box(
        contentAlignment = Alignment.BottomEnd,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            onClick = {
                navHostController.navigate(route = AppScreens.ContactDataActivity.route)

            },
            modifier = Modifier
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(Color.Gray)
        ) {
            Text(text = stringResource(R.string.siguiente))
        }
    }

}