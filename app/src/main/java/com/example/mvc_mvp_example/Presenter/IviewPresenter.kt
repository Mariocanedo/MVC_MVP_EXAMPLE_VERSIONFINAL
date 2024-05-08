package com.example.mvc_mvp_example.Presenter

interface IviewPresenter {

    //actualizar el monton en el texto de la vista
    fun updateTotalDonation(totalAmount:Int)

    // muestra mensaje de confirmación
    fun displayConfirmationMessage()

    fun displayErrorMessage()

    fun displayColorAlert(color:String)

}