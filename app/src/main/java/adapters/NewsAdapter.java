package adapters;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import model.dto.New;
import reader.newsreader.R;

/**
 * Autor = Juan José Ramírez Sánchez
 * Fecha = 10/01/2016.
 * Licencia = gpl3.0
 * Version = 1.0
 * Descripcion = Script para controlar algunas de las animaciones y algunos de los efectos que aparecen
 * en la animación principal.
 * <p/>
 * Copyright (C) 2016 Juan José Ramírez Sánchez
 * <p/>
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * <p/>
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * <p/>
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 **/


public class NewsAdapter extends ArrayAdapter<New> {

    private Context context;
    private ArrayList<New> news;

    public NewsAdapter(Context context, ArrayList<New> news) {
        super(context, R.layout.adapter_news_list, news);
        this.context = context;
        this.news = news;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Este método crea cada una de las vistas.
        LayoutInflater inflater = LayoutInflater.from(context);
        View vista = inflater.inflate(R.layout.adapter_news_list, null);

        TextView newTitle = (TextView) vista.findViewById(R.id.newTitle);
        TextView newBody = (TextView) vista.findViewById(R.id.newBody);

        newTitle.setText(this.news.get(position).getTitle());
        newBody.setText(this.news.get(position).getShortNew());

        return vista;
    }
}
