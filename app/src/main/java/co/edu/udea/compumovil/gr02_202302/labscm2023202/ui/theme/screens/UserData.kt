package co.edu.udea.compumovil.gr02_202302.labscm2023202.ui.theme.screens

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class UserData(
    var name:           String? = "",
    var lastName:       String? = "",
    var gender:         String? = "",
    var birthDate:      String? = "",
    var educationLevel: String? = "",
    var phone:          String? = "",
    var address:        String? = "",
    var email:          String? = "",
    var country:        String? = "",
    var city:           String? = "",
){

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as UserData
        if (name            != other.name) return false
        if (lastName        != other.lastName) return false
        if (gender          != other.gender) return false
        if (birthDate       != other.birthDate) return false
        if (educationLevel  != other.educationLevel) return false
        if (phone           != other.phone) return false
        if (address         != other.address) return false
        if (email           != other.email) return false
        if (country         != other.country) return false
        if (city            != other.city) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + gender.hashCode()
        result = 31 * result + birthDate.hashCode()
        result = 31 * result + educationLevel.hashCode()
        result = 31 * result + phone.hashCode()
        result = 31 * result + address.hashCode()
        result = 31 * result + email.hashCode()
        result = 31 * result + country.hashCode()
        result = 31 * result + city.hashCode()
        return result
    }
}


class SharedUserViewModel : ViewModel() {
    private val userData = MutableLiveData<UserData>()

    fun saveUserData(userData: UserData) {
        this.userData.value = userData
    }
}
