package controllers;

import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;

import model.constants.FilesName;
import model.dto.New;
import model.services.NewsServices;
import model.utils.FileSerializationUtils;

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

public class NewsController {

    private int lastSeconds;

    public NewsController() {
        lastSeconds = 0;
    }

    public ArrayList<New> getCurrentNews() {
        ArrayList<New> noticias = null;
        int seconds = (int) System.currentTimeMillis() / 1000;
        try {
            NewsServices services = new NewsServices();

            if (seconds > lastSeconds) {
                noticias = services.getCurrentPage();
                lastSeconds = seconds + 60;
                FileSerializationUtils.serializeObject(noticias, FilesName.FILE_NAME);
            } else {
                noticias = (ArrayList<New>) FileSerializationUtils.deserializeObject(FilesName.FILE_NAME);
            }
            return noticias;
        } catch (Exception e) {
            Log.e("Error general:", "Conexión Internet, Error cast. (NewsController)");
        }
        return noticias;
    }
}
