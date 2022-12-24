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
import places.socialPlaces.Plaza;
import places.socialPlaces.SocialPlace;
import places.unknownPlaces.Field;
import places.unknownPlaces.Street;
import places.estate.*;
import requisite.*;

public class Project {
    @FunctionalInterface
    interface IMessenger{
        void message(String mes);
    }

    public static void main(String[] args) {

        IMessenger messenger = System.out::println;
        IMessenger byDefault = (mes) -> System.out.println("Автор пока ничего не придумал");

        byDefault.message("");
        SocialPlace plaza = new Plaza();
        Barge exBarge = new Barge();

        Loudthroat exLoudthroat1 = new Loudthroat(plaza);
        Loudthroat exLoudthroat2 = new Loudthroat(plaza);

        Citizen citizen1 = new Citizen("Павел", plaza);
        Citizen citizen2 = new Citizen(plaza);

        Government government = new Government(plaza, exBarge);

        Stock exampleStock1 = new Stock();
        Stock exampleStock2 = new Stock("рандомная", 15);
        Stock exampleStock3 = new Stock("хайповая", 7);

        messenger.message(exLoudthroat1.scream(Action.BUY, exampleStock1));
        messenger.message(exLoudthroat2.scream(Action.SELL, exampleStock1));
        messenger.message(exLoudthroat1.scream(Action.SELL, exampleStock2));
        messenger.message(exLoudthroat2.scream(Action.BUY, exampleStock2));
        messenger.message(exLoudthroat1.scream(Action.BUY, exampleStock3));
        messenger.message(exLoudthroat2.scream(Action.SELL, exampleStock3));

        Street UnknownStreet = new Street();
        Millioners protagonist = new Millioners("Скуперфильд", UnknownStreet, 15000000);

        Millioners exMill = new Millioners("Неизвестный", UnknownStreet, 100);

        Home protHome = new Home("свой дом", protagonist.getName(), Position.HOMETOWN);
        PastaFactory protFactory = new PastaFactory("своя фабрика", protagonist.getName(), Position.HOMETOWN);

        Barge grabBarge = new Barge("грабенгерская баржа", protagonist.getName(), Position.HOMETOWN);
        Barge davBarge = new Barge("давилонская баржа", protagonist.getName(), Position.DAVILON);

        protagonist.addImmovables(protHome, protFactory);

        Loudthroat nameless1 = new Loudthroat("Раб1", grabBarge);
        Loudthroat nameless2 = new Loudthroat("Раб2", grabBarge);
        grabBarge.addEmployee(nameless1);
        grabBarge.addEmployee(nameless2);

        Loudthroat nameless3 = new Loudthroat("Раб3", davBarge);
        Loudthroat nameless4 = new Loudthroat("Раб4", davBarge);
        davBarge.addEmployee(nameless3);
        davBarge.addEmployee(nameless4);

        messenger.message(protagonist.getImmovables());

        messenger.message(protagonist.giveInstruction(grabBarge,Instruction.BUY, exampleStock1));
        messenger.message(protagonist.giveInstruction(grabBarge,Instruction.BUY,exampleStock2));

        protagonist.addDestination(protHome.getName());
        protagonist.addDestination(protFactory.getName());
        protagonist.addDestination(Position.RAILWAY_STATION.getPlace());
        protagonist.addDestination(Position.DAVILON.getPlace());
        protagonist.addDestination(davBarge.getName());

        messenger.message(protagonist.getDestinationList());

        messenger.message(protagonist.getName() + ": находится " +protagonist.getStrPlace());

        protagonist.setPlace(new Field());
        messenger.message(protagonist.getName() + ": находится " + protagonist.getStrPlace());

        protagonist.setPlace(new Street());
        messenger.message(protagonist.getName() + ": находится " + protagonist.getStrPlace());

        protagonist.setPlace(new Street("неизветсный бульвар"));
        messenger.message(protagonist.getName() + ": находится " + protagonist.getStrPlace());

        protagonist.setPlace(new Street("новая неизветсная улица"));
        messenger.message(protagonist.getName() + ": находится " + protagonist.getStrPlace());

        Street curvedStreet = new Street("Кривая улица");

        protagonist.setPlace(curvedStreet);
        messenger.message(protagonist.getName() + ": находится " + protagonist.getStrPlace());

        try {
            Class myClass = Class.forName("places.socialPlaces.Plaza");
            String nameClass = myClass.getName();
            messenger.message(nameClass);
        } catch (ClassNotFoundException e){

        }
    }
}