package com.example.mvc_mvp_example.View

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mvc_mvp_example.Presenter.Controller
import com.example.mvc_mvp_example.Presenter.DonationPresenter
import com.example.mvc_mvp_example.Presenter.IviewPresenter
import com.example.mvc_mvp_example.R
import com.example.mvc_mvp_example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),IviewPresenter{

    private lateinit var binding: ActivityMainBinding
  //  private lateinit var controller: Controller
    private lateinit var  presenter: DonationPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // inicializar controller
      //   controller = Controller()
        presenter= DonationPresenter(this)
         binding.button.setOnClickListener{makeDonation()}

    }

    private fun makeDonation() {
        val donationText = binding.tvDonation.text.toString()
        if (donationText.isNotEmpty()) {
            presenter.saveDonation(donationText)
            binding.tvDonation.setText("")
            presenter.totalDonation()
            presenter.checkTotal()
        } else {
            // Manejar caso de donación vacía
            displayErrorMessage()
        }
    }
    override fun updateTotalDonation(totalAmount: Int) {
       val total = getString(R.string.total_donaciones, totalAmount.toString())
        binding.tvTotal.text = total
    }

    override fun displayConfirmationMessage() {
        val toast = Toast.makeText(applicationContext, "Donación Exitosa", Toast.LENGTH_LONG)
        toast.show()
    }

    override fun displayErrorMessage() {
        val toast = Toast.makeText(applicationContext, "Donación Fallida", Toast.LENGTH_LONG)
        toast.show()
    }

    override fun displayColorAlert(color: String) {
     binding.textView2.setBackgroundColor(Color.parseColor(color))
    }

}
