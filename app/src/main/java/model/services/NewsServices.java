package model.services;

import java.util.ArrayList;
import java.util.List;

import model.dao.NewsDAO;
import model.dto.New;
import model.utils.WebPageUtils;

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

public class NewsServices {

    private static int currentPage;


    public NewsServices(){
        currentPage = 1;
    }

    /**
     * Este va a ser el método encargado de obtener todas las paginas
     *
     * @param page
     * @return
     */
    private ArrayList<New> getNewsList(int page) {
        WebPageUtils webUtils = new WebPageUtils();
        NewsDAO newsDAO = null;
        String html = null;
        try {
            //Le indico la página que quiero ver.
            html = (String) webUtils.execute("https://www.meneame.net/?page=" + page).get();
            newsDAO = new NewsDAO();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newsDAO.getNewsList(html);
    }

    /**
     * Obtains previous page of meneame
     * @return List<New>
     */
    public ArrayList<New> getCurrentPage() {
        return this.getNewsList(currentPage);
    }

    /**
     * Obtains previous page of meneame
     * @return List<New>
     */
    public ArrayList<New> getPreviousPage() {
        if (currentPage > 1)
            currentPage--;
        return this.getNewsList(currentPage);
    }

    /***
     * Obtains next page of meneame
     * @return List<New>
     */
    public ArrayList<New> getNextPage() {
        if (currentPage < 100)
            currentPage++;
        return this.getNewsList(currentPage);
    }
}
