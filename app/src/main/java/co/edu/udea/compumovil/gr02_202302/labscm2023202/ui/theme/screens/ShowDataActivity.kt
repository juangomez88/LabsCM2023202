package co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowDataActivity(navController: NavHostController) {
    Scaffold (topBar = {
        ContactDataBar(
            currentScreen = ScreenContact.Contact,
            canNavigateBack = navController.previousBackStackEntry != null,
            navigateUp = { navController.navigateUp() })
    }){
        val userData = UserData()
        BodyShowData(userData)
    }
}

@Composable
fun BodyShowData(userData: UserData) {
    val columnModifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    LazyColumn(
        modifier = columnModifier
    ) {
        item {
            Spacer(modifier = Modifier.height(45.dp))
        }
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Text("stringResource(R.string.nombre): ${userData.name}")}
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Text("Apellido: ${userData.lastName}")}
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Text("Sexo: ${userData.gender}")}
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ){
                Text("Fecha de nacimiento: ${userData.birthDate}")}
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ){
                Text("Grado escolaridad: ${userData.educationLevel}")}
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ){
                Text("Teléfono: ${userData.phone}")}
        }
    }
}