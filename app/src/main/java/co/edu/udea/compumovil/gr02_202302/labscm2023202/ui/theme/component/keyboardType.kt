package co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.component

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType


val keyboardAddress  = KeyboardOptions(
    keyboardType   = KeyboardType.Text,
    imeAction      = ImeAction.Next,
    capitalization = KeyboardCapitalization.Words,
    autoCorrect    = false
);

val keyboardCity     = KeyboardOptions(
    keyboardType   = KeyboardType.Text,
    imeAction      = ImeAction.Done
);

val keyboardEmail    = KeyboardOptions(
    keyboardType   = KeyboardType.Email,
    imeAction      = ImeAction.Next,
    autoCorrect    = false
)

val keyboardName     = KeyboardOptions(
    keyboardType   = KeyboardType.Text,
    imeAction      = ImeAction.Next,
    capitalization = KeyboardCapitalization.Words,
    autoCorrect    = false
)

val keyboardPhone    = KeyboardOptions(
keyboardType       = KeyboardType.Number,
imeAction          = ImeAction.Next,
autoCorrect        = false
)
