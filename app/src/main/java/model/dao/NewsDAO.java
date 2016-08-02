package model.dao;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import model.dto.New;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NewsDAO
{
    public ArrayList<New> getNewsList(String paramString)
    {
        Object localObject = Jsoup.parse(paramString);
        ArrayList<New> news = new ArrayList();
        localObject = ((Document)localObject).getElementsByClass("news-body").iterator();
        while (((Iterator)localObject).hasNext())
        {
            Element localElement1 = (Element)((Iterator)localObject).next();
            try
            {
                New localNew = new New();
                Element localElement2 = (Element)localElement1.getElementsByTag("h2").get(0);
                localNew.setLink(localElement2.getElementsByTag("a").attr("href"));
                localNew.setTitle(localElement2.text());
                localNew.setBody(localElement1.ownText());
                localNew.setImage(((Element)localElement1.getElementsByTag("a").get(5)).attr("href"));
                news.add(localNew);
            }
            catch (Exception localException)
            {
                Log.e("Error: NewsDAO", "Couldn't read HTML probably due HTML syntax.");
            }
        }
        return news;
    }
}
