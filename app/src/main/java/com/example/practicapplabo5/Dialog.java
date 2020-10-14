package com.example.practicapplabo5;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.List;

public class Dialog extends DialogFragment {

    private NameDialogListener listener;
    private EditText editNombre;
    public Producto producto;

    public Dialog(Producto producto) {
        this.producto = producto;
    }


    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //Armo la vista con inflate()
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_dialog, null);

        editNombre= view.findViewById(R.id.tvNombreProductoNuevo);

        builder.setView(view)
                // botones del dialog
                .setPositiveButton(R.string.btnOk, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String nombre = editNombre.getText().toString();
                        listener.modificarNombre(nombre, producto);
                    }
                })
                .setNegativeButton(R.string.btnCancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Dialog.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (NameDialogListener)context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString());
        }
    }

    public interface  NameDialogListener{
        void modificarNombre(String nombre, Producto producto);
    }

}
