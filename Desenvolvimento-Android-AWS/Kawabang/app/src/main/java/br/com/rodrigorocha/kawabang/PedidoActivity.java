package br.com.rodrigorocha.kawabang;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import br.com.rodrigorocha.kawabang.models.Usuario;

public class PedidoActivity extends AppCompatActivity {

    private Usuario usuario;
    private TextView tvUsuario;

    private CheckBox cbAtum;
    private CheckBox cbBacon;
    private CheckBox cbMussarela;
    private CheckBox cbCalabresa;

    private RadioGroup rgTamanhoPizza;
    private Spinner spPagamentos;

    private CheckBox cbBordaRecheada;
    private CheckBox cbRecheioExtra;
    private CheckBox cbRefrigerante;
    private CheckBox cbSobremesa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        tvUsuario = (TextView) findViewById(R.id.tvUsuario);
        usuario = getIntent().getExtras().getParcelable("usuario");
        tvUsuario.setText(usuario.getLogin());

        cbAtum = (CheckBox) findViewById(R.id.cbPizzaAtum);
        cbBacon = (CheckBox) findViewById(R.id.cbPizzaBacon);
        cbMussarela = (CheckBox) findViewById(R.id.cbPizzaMussarela);
        cbCalabresa = (CheckBox) findViewById(R.id.cbPizzaCalabresa);

        rgTamanhoPizza = (RadioGroup) findViewById(R.id.rgTamanhoPizza);
        spPagamentos = (Spinner) findViewById(R.id.spinnerPagamento);

        cbBordaRecheada = (CheckBox) findViewById(R.id.cbBordaRecheada);
        cbRecheioExtra = (CheckBox) findViewById(R.id.cbRecheioExtra);
        cbRefrigerante = (CheckBox) findViewById(R.id.cbRefrigerante);
        cbSobremesa = (CheckBox) findViewById(R.id.cbSobremesa);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void calcular(View view) {
        int idSelecionado = rgTamanhoPizza.getCheckedRadioButtonId();

        double valorPizza = 0.0;
        switch (idSelecionado) {
            case R.id.rbPizzaGrande:
                valorPizza = 50;
                break;

            case R.id.rbPizzaMedia:
                valorPizza = 40;
                break;

            case R.id.rbPizzaPequena:
                valorPizza = 30;
                break;
        }

        if(cbBordaRecheada.isChecked())
            valorPizza += 5.25;

        if(cbRecheioExtra.isChecked())
            valorPizza += 8.5;

        if(cbRefrigerante.isChecked())
            valorPizza += 11;

        if(cbSobremesa.isChecked())
            valorPizza += 15.9;

        String pagamento = spPagamentos.getSelectedItem().toString();

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Confirmar Pedido");
        alert.setMessage("Valor R$" + valorPizza + "\nPagamento: " + pagamento);
        alert.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(PedidoActivity.this, "Pedido Confirmado", Toast.LENGTH_LONG).show();
            }
        });
        alert.setNegativeButton("Não", null);
        alert.show();
    }
}
