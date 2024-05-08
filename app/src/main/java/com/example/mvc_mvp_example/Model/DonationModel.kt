package com.example.mvc_mvp_example.Model

class DonationModel {


    // inicializar las variables
    private var totalAmount: Int = 0


    init {

        this.totalAmount = 0
    }

    // funcion para guardar donaciones

    fun saveDonation( donation : String): Boolean{

        val amount = donation.toIntOrNull()

        if(amount != null && amount > 0)
        {
            totalAmount += amount
            return  true
        }
        return  false
    }


    fun getDonationAmount():Int{

        return totalAmount
    }


    // en Mvp se mantiene la misma estructura.
    fun checKAmount(): String {
        if(totalAmount >=200 && totalAmount<=500){
            return "#F31A1A"
        }
        if(totalAmount >=500 && totalAmount<=1000){
            return "#FFFB33"
        }
        return "#58FF11"
    }
}





