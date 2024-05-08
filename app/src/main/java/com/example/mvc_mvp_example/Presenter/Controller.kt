package com.example.mvc_mvp_example.Presenter

import com.example.mvc_mvp_example.Model.DonationModel

class Controller {


    // comunicar con el Donation Model

    private val model: DonationModel

    init {

        model = DonationModel()

    }

    // llamo funcion del model guardar
    fun saveDonation(amount : String) : Boolean{

        return model.saveDonation(amount)
    }


    // llamo la funcion del model   que muestra las donaciones

    fun totalDonation():Int{

        return model.getDonationAmount()
    }

}