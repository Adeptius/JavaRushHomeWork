package com.javarush.test.level03.lesson04.task03;

/* StarCraft
Создать 10 зергов, 5 протосов и 12 терран.
Дать им всем уникальные имена.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Zerg a = new Zerg();
        a.name = "a";
        System.out.println("zerg" + a.name);

        Zerg b = new Zerg();
        b.name = "b";
        System.out.println("zerg" + b.name);

        Zerg c = new Zerg();
        c.name = "c";
        System.out.println("zerg" + c.name);

        Zerg d = new Zerg();
        d.name = "d";
        System.out.println("zerg" + d.name);

        Zerg e = new Zerg();
        e.name = "e";
        System.out.println("zerg" + e.name);

        Zerg f = new Zerg();
        f.name = "f";
        System.out.println("zerg" + f.name);

        Zerg j = new Zerg();
        j.name = "j";
        System.out.println("zerg" + j.name);

        Zerg k = new Zerg();
        k.name = "k";
        System.out.println("zerg" + k.name);

        Zerg g = new Zerg();
        g.name = "g";
        System.out.println("zerg" + g.name);

        Zerg m = new Zerg();
        m.name = "m";
        System.out.println("zerg" + m.name);


        Protos ab = new Protos();
        ab.name = "ab";
        System.out.println("protos" + ab.name);

        Protos bc = new Protos();
        bc.name = "bc";
        System.out.println("protos" + bc.name);

        Protos cd = new Protos();
        cd.name = "cd";
        System.out.println("protos" + cd.name);

        Protos de = new Protos();
        de.name = "de";
        System.out.println("protos" + de.name);

        Protos ef = new Protos();
        ef.name = "ef";
        System.out.println("protos" + ef.name);


        Terran abc = new Terran();
        abc.name = "abc";
        System.out.println("terran" + abc.name);

        Terran bcd = new Terran();
        bcd.name = "bcd";
        System.out.println("terran" + bcd.name);

        Terran cde = new Terran();
        cde.name = "cde";
        System.out.println("terran" + cde.name);

        Terran htr = new Terran();
        htr.name = "htr";
        System.out.println("terran" + htr.name);

        Terran def = new Terran();
        def.name = "def";
        System.out.println("terran" + def.name);

        Terran efj = new Terran();
        efj.name = "efj";
        System.out.println("terran" + efj.name);

        Terran fjk = new Terran();
        fjk.name = "fjk";
        System.out.println("terran" + fjk.name);

        Terran jkl = new Terran();
        jkl.name = "jkl";
        System.out.println("terran" + jkl.name);

        Terran klm = new Terran();
        klm.name = "klm";
        System.out.println("terran" + klm.name);

        Terran lmn = new Terran();
        lmn.name = "lmn";
        System.out.println("terran" + lmn.name);

        Terran mno = new Terran();
        mno.name = "mno";
        System.out.println("terran" + mno.name);

        Terran nop = new Terran();
        nop.name = "nop";
        System.out.println("terran" + nop.name);



    }

    public static class Zerg
    {
        public String name;
    }

    public static class Protos
    {
        public String name;
    }

    public static class Terran
    {
        public String name;
    }
}
