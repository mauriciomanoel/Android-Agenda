package br.com.sjcc.agenda.interfaces;

import android.view.View;

/**
 * Created by Mauricio on 18/08/2016.
 */
public interface IClickListener {
    void onClick(View view, int position);

    void onLongClick(View view, int position);
}
