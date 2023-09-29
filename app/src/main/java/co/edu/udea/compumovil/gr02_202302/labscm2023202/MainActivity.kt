package co.edu.udea.compumovil.gr02_202302.labscm2023202

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.LabsCM2023202Theme
import co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.navigation.AppNavigation
import co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.screens.UserInput

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LabsCM2023202Theme {
                AppNavigation()
            }
        }
    }
}
