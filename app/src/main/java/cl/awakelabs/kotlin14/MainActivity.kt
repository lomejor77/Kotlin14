package cl.awakelabs.kotlin14

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import cl.awakelabs.kotlin14.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var saldo = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnSelect.setOnClickListener {

            when (binding.radioGroup.checkedRadioButtonId) {
                R.id.radioSaldo -> binding.textSaldo.setText(saldo.toString())
                R.id.radioIngreso -> ingresoSaldo()
                R.id.radioRetiro -> retiroSaldo()
                R.id.radioExit -> finish()
            }
        }
    }

    private fun ingresoSaldo() {
        saldo += binding.editMonto.text.toString().toInt()
        limpiar()
        Toast.makeText(applicationContext, "Su saldo se ha actualizado correctamente", Toast.LENGTH_SHORT).show()
    }

    private fun retiroSaldo() {
        val monto =  binding.editMonto.text.toString().toInt()

        if (monto <= saldo ){
            saldo -= monto
            limpiar()
            Toast.makeText(applicationContext, "saldo insuficiente", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(applicationContext, "Su retiro se ha concretado correctamente", Toast.LENGTH_SHORT).show()
        }

    }

    private fun limpiar() {
        binding.editMonto.text.clear()
    }


}