package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.NoAvailableVideoEventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Leonid on 19.12.2015.

 2. Разберем подробно метод void processVideos() в AdvertisementManager.
 2.1. Удаляем из него вывод в консоль "processVideos method calling"
 Метод должен:
 2.2. Подобрать список видео из доступных, просмотр которых обеспечивает максимальную выгоду. (Следующее задание)
 2.3. Если нет рекламных видео, которые можно показать посетителю, то бросить NoVideoAvailableException,
 которое перехватить в оптимальном месте (подумать, где это место) и с уровнем Level.INFO логировать фразу
 "No video is available for the order " + order
 2.4. Отобразить все рекламные ролики, отобранные для показа, в порядке уменьшения стоимости показа одного рекламного ролика
 в копейках. Вторичная сортировка - по увеличению стоимости показа одной секунды рекламного ролика в тысячных частях копейки
 Используйте метод Collections.sort
 (Будет тестироваться вместе со следующим заданием)
 Пример для заказа [Water]:
 First Video is displaying... 50, 277
 где First Video - название рекламного ролика
 где 50 - стоимость показа одного рекламного ролика в копейках
 где 277 - стоимость показа одной секунды рекламного ролика в тысячных частях копейки (равно 0.277 коп)
 Используйте методы из класса Advertisement.
 2.5. В классе Advertisement создайте метод void revalidate(). Этот метод должен:
 2.5.1. кидать UnsupportedOperationException, если количество показов не положительное число
 2.5.2. уменьшать количество показов
 2.6. Для каждого показанного рекламного ролика пересчитать его данные вызвав метод revalidate() у объекта класса Advertisement.
 */
public class AdvertisementManager
{
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds ;

    public AdvertisementManager(int timeSeconds )
    {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException {
        //Подобрать список видео из доступных, просмотр которых обеспечивает максимальную выгоду.

        List<Advertisement> videos = getBestVideos(storage.list());
        //Если нет рекламных видео, которые можно показать посетителю, то бросить NoVideoAvailableException
        if (videos.isEmpty()) {
            throw new NoVideoAvailableException();
        }

        //Отобразить все рекламные ролики, отобранные для показа, в порядке уменьшения стоимости показа
        // одного рекламного ролика в копейках. Вторичная сортировка - по увеличению стоимости показа
        // одной секунды рекламного ролика в тысячных частях копейки.

        Comparator<Advertisement> comparator = new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                long o1Price = o1.getAmountPerOneDisplaying();
                long o2Price = o2.getAmountPerOneDisplaying();
                if (o1Price != o2Price ) {
                    return (int) (o2Price - o1Price);
                } else {
                    long o1PricePerSec = 1000 * o1Price / o1.getDuration();
                    long o2PricePerSec = 1000 * o2Price / o2.getDuration();
                    return (int) (o1PricePerSec - o2PricePerSec);
                }
            }
        };

        Collections.sort(videos, comparator);
        //регистрируем событие "видео-выбрано"
        long amount = 0;                        //выручка за показ всех выбранных видео
        int totalDuration = 0;                  //общее время показа выбранных видео
        for (Advertisement video : videos) {
            amount += video.getAmountPerOneDisplaying();
            totalDuration += video.getDuration();
        }
        VideoSelectedEventDataRow videoSelectedEvent = new VideoSelectedEventDataRow(videos, amount, totalDuration);
        StatisticManager.getInstance().register(videoSelectedEvent);

        //выводим видео
        for (Advertisement video : videos) {
            String name = video.getName();
            long price = video.getAmountPerOneDisplaying();
            long pricePerSec = 1000 * price / video.getDuration();
            String out = String.format("%s is displaying... %d, %d", name, price, pricePerSec);
            System.out.println(out);
            video.revalidate();
        }
    }

    private  List<Advertisement> getBestVideos(List<Advertisement> allVideos) {

        return getVideos(allVideos, new ArrayList<Advertisement>(), new ArrayList<Advertisement>());
    }

    private List<Advertisement> getVideos(List<Advertisement> allVideos, List<Advertisement> someVideos,
                                          List<Advertisement> bestVideos) {
        if (allVideos == null)
            return Collections.emptyList();
        ArrayList<Advertisement> copy = new ArrayList<>(allVideos);
        //получаем параметры списка для добавления
        int someVideosTime = 0;
        if (!someVideos.isEmpty()) {
            for (Advertisement ad : someVideos) {
                someVideosTime += ad.getDuration();
            }
        }

        for (int i = 0; i < allVideos.size(); i++) {
            Advertisement someVideo = allVideos.get(i);
            if (someVideo.getHits() <= 0)
                continue;
            int someVideoTime = someVideo.getDuration();
            if (someVideoTime + someVideosTime <= timeSeconds) {
                someVideos.add(someVideo);
                copy.remove(someVideo);
                bestVideos = getVideos(copy, someVideos, bestVideos);
                someVideos.remove(someVideo);
            }
        }

        if (bestVideos.isEmpty())
        {
            if (!someVideos.isEmpty())
            {
                bestVideos.addAll(someVideos);
            }
        } else if (!someVideos.isEmpty()) {
            //Get params for bestVideos
            long bestVideosPrice = 0;
            int bestVideosTime = 0;
            int bestVideosCount =  bestVideos.size();
            for (Advertisement ad : bestVideos) {
                bestVideosPrice += ad.getAmountPerOneDisplaying();
                bestVideosTime += ad.getDuration();
            }
            //Get params for someVideos
            long someVideosPrice = 0;
            someVideosTime = 0;
            int someVideosCount = someVideos.size();
            for (Advertisement ad : someVideos) {
                someVideosPrice += ad.getAmountPerOneDisplaying();
                someVideosTime += ad.getDuration();
            }
            if (someVideosPrice > bestVideosPrice) {
                bestVideos.clear();
                bestVideos.addAll(someVideos);
            } else if (someVideosPrice == bestVideosPrice) {
                if (someVideosTime > bestVideosTime) {
                    bestVideos.clear();
                    bestVideos.addAll(someVideos);
                } else if (someVideosTime == bestVideosTime) {
                    if (someVideosCount < bestVideosCount) {
                        bestVideos.clear();
                        bestVideos.addAll(someVideos);
                    }
                }
            }

        }
        return bestVideos;
    }
}
