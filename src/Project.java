/*
Как и у каждого миллионера, у Скуперфильда на каждой из этих барж имелись свои горлодерики,
которым он в любой момент мог отдать по телефону приказ покупать те или иные акции.

Однако всегда нужно было знать, когда начинать покупку акций, так как в противном случае можно было заплатить лишнее.

Чтобы быть в курсе дела и не совершить промаха, Скуперфильд решил поехать на давилонскую баржу
и разнюхать, по какой цене продаются гигантские акции.
Конечно, он не мог тут же отправиться на вокзал, так как хотел сначала зайти домой и побывать на своей макаронной фабрике.

Вспомнив, что ему надо домой, он огляделся по сторонам и заметил, что идет по какой-то незнакомой улице.

Он все же решил идти по этой улице дальше, надеясь,
что встретит какое-нибудь знакомое место и поймет, в какую сторону ему надо свернуть.

Улица, однако, скоро кончилась. Скуперфильд увидел, что вышел из города и очутился в открытом поле.
 */


import actors.*;
import enums.*;
import estate.*;
import requisite.*;

public class Project {
    public static void main(String[] args) {

        Millioners protagonist = new Millioners("Скуперфильд", Place.HOMETOWN, 15000000);

        Home protHome = new Home("свой дом", protagonist.getName(), Place.HOMETOWN);
        PastaFactory protFactory = new PastaFactory("своя фабрика", protagonist.getName(), Place.HOMETOWN);

        Barge BargeA = new Barge("Баржа1", protagonist.getName(), Place.HOMETOWN);
        Barge BargeB = new Barge("давилонская баржа", protagonist.getName(), Place.DAVILON);

        Loudthroat Nameless1 = new Loudthroat("Раб1", Place.HOMETOWN);
        Loudthroat Nameless2 = new Loudthroat("Раб2", Place.HOMETOWN);
        BargeA.addEmployee(Nameless1);
        BargeA.addEmployee(Nameless2);

        Loudthroat Nameless3 = new Loudthroat("Раб3", Place.DAVILON);
        Loudthroat Nameless4 = new Loudthroat("Раб4", Place.DAVILON);
        BargeB.addEmployee(Nameless3);
        BargeB.addEmployee(Nameless4);

        Stock ExampleStock1 = new Stock();
        Stock ExampleStock2 = new Stock("рандомная", 15);
        Stock ExampleStock3 = new Stock("хайповая", 7);
        Stock GigaStock = new Stock("гигантские акции", 1000);

        System.out.println(protagonist.getImmovables());

        System.out.println(protagonist.giveInstruction(BargeA,Instruction.BUY, ExampleStock1));
        System.out.println(protagonist.giveInstruction(BargeA,Instruction.BUY,ExampleStock2));

        System.out.println(protagonist.checkStock(ExampleStock2));
        System.out.println(protagonist.checkStock(ExampleStock3));

        protagonist.addDestination(protHome.getName());
        protagonist.addDestination(protFactory.getName());
        protagonist.addDestination(Place.RAILWAY_STATION.getPlace());
        protagonist.addDestination(Place.DAVILON.getPlace());
        protagonist.addDestination(BargeB.getName());

        System.out.println(protagonist.getDestinationList());

        protagonist.setPosition(Place.UNKNOWN);
        System.out.println(protagonist.getPosition());

        protagonist.setPosition(Place.FIELD);
        System.out.println(protagonist.getPosition());
    }
}