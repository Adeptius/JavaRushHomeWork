package com.javarush.test.level27.lesson15.big01.ad;


import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.*;

/**
 * Created by Владелец on 18.08.2016.
 */
public class AdvertisementManager {

    private static final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;
    private long maxProfit = 0;
    private int minRemainingTime = timeSeconds;
    private List<Advertisement> videos = storage.list();


    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException {
        // Для хранения всех возможных сочетаний, создаем сортирующее множество
        SortedSet<List<Advertisement>> set = new TreeSet<>(new Comparator<List<Advertisement>>() {
            @Override
            public int compare(List<Advertisement> o1, List<Advertisement> o2) {
                long totalAmount1 = 0, totalAmount2 = 0;    // 1) сумма денег
                long totalTime1 = 0, totalTime2 = 0;        // 4.1) суммарное время
                int totalCount1 = 0, totalCount2 = 0;       // 4.2) количество Роликов

                for (Advertisement ad : o1) {
                    totalAmount1 += ad.getAmountPerOneDisplaying();
                    totalTime1 += ad.getDuration();
                }
                totalCount1 = o1.size();

                for (Advertisement ad : o2) {
                    totalAmount2 += ad.getAmountPerOneDisplaying();
                    totalTime2 += ad.getDuration();
                }
                totalCount2 = o2.size();

                if (totalAmount1 != totalAmount2)
                    return (int) (totalAmount1 - totalAmount2);
                else if (totalTime1 != totalTime2)
                    return (int) (totalTime1 - totalTime2);
                else if (totalCount1 != totalCount2)
                    return totalCount2 - totalCount1;
                else if (o1.hashCode() > o2.hashCode())
                    return 1;
                else
                    return -1;
            }
        });

        // Берем последнее сочетание - самое дорогое, максимально длинное, с меньшим к-вом роликов
        List<Advertisement> selectedVideos = selector(new ArrayList<Advertisement>(), set);

        if (selectedVideos.isEmpty())
            throw new NoVideoAvailableException();

        // сортируем выборку
        Collections.sort(selectedVideos, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                if (o1.getAmountPerOneDisplaying() != o2.getAmountPerOneDisplaying())
                    return (int) (o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying());
                else
                    return (int) ((1000.0 * o1.getAmountPerOneDisplaying() / o1.getDuration())
                            - (1000.0 * o2.getAmountPerOneDisplaying() / o2.getDuration()));

            }
        });

        // выводим на экран
        for (Advertisement video : selectedVideos) {
            ConsoleHelper.writeMessage(video.getName() + " is displaying... "
                    + video.getAmountPerOneDisplaying() + ", "
                    + (1000 * video.getAmountPerOneDisplaying() / video.getDuration()));
        }

        // пересчитываем
        for (Advertisement advertisement : selectedVideos) {
            advertisement.revalidate();
        }
    }

    // рекурсивная функция
    private List<Advertisement> selector(List<Advertisement> selection, SortedSet<List<Advertisement>> set) {
        boolean isAdded = false;

        // находим время всей выборки
        int timeSel = 0;
        for (Advertisement advSel : selection) {
            timeSel += advSel.getDuration();
        }

        // перебираем все ролики из общего списка
        for (Advertisement adv : storage.list()) {
            // если видео уже есть в выборке - пропускаем его
            if (selection.contains(adv))                    // 3) не более одного за раз
                continue;

            // если превысим время готовки - пропускаем его
            if (timeSel + adv.getDuration() > timeSeconds)  // 2) общее время
                continue;

            // если закончилось количество показов - пропускаем его
            if (adv.getHits() <= 0)                         // 5) количество показов - положительное число
                continue;

            // если дошли до этого места, создаём новый список на основе текущего
            // добавляем в него элемент
            // вызываем новый селектор
            // и ставим соответствующий флаг
            List<Advertisement> list = new ArrayList<>(selection);
            list.add(adv);
            selector(list, set);
            isAdded = true;
        }

        // если ничего добавлено не было, значит, в этой ветке дошли до конца
        // (или всё добавлено, или исчерпан лимит времени)
        // добавляем выборку во множество выборок
        if (!isAdded)
            set.add(selection);

        return set.last();
    }

}
