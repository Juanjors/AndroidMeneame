package model.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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


public class FileSerializationUtils {

    private static Context context;

    static {
        context = AppContextUtils.getAppContext();
    }

    public static void serializeObject(Object object,String fileName){
       FileOutputStream fos = null;
        ObjectOutputStream os = null;
        try {
            fos = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            os = new ObjectOutputStream(fos);
            os.writeObject(object);
            os.close();
            fos.close();
        } catch (IOException e) {
            Log.e("Error Serializando", e.getMessage());
        }
    }

    /**
     * Deserializa un objeto de un archivo
     * @param fileName
     * @return Objeto deserializado.
     */
    public static Object deserializeObject(String fileName){
        Object object = null;
        FileInputStream fis = null;
        ObjectInputStream is = null;
        try {
            fis = context.openFileInput(fileName);
            is = new ObjectInputStream(fis);
            object = is.readObject();
            is.close();
            fis.close();
        } catch (Exception e) {
            Log.e("Error deserializando", e.getMessage());
        }
        return object;
    }

}
