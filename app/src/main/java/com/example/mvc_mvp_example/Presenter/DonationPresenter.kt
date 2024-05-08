package com.example.mvc_mvp_example.Presenter

import com.example.mvc_mvp_example.Model.DonationModel

class DonationPresenter( private val view :IviewPresenter) {

    //comunica con el donation Model
    private val model: DonationModel

    init {
        model = DonationModel()
    }


    fun saveDonation(donation :String){
        if( model.saveDonation(donation)){

            view.displayConfirmationMessage()
            view.updateTotalDonation(model.getDonationAmount())
        }
        else
        {

            view.displayErrorMessage()
        }

    }


    fun totalDonation(){

        view.updateTotalDonation(model.getDonationAmount())
    }



    fun checkTotal(){
        view.displayColorAlert(model.checKAmount())
    }


}